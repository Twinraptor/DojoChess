package com.johnfu.dojoplay.controllers;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import com.johnfu.dojoplay.models.Game;
import com.johnfu.dojoplay.models.User;
import com.johnfu.dojoplay.services.DojoPlayService;
import com.johnfu.dojoplay.validator.UserValidator;


@Controller
public class DojoPlayController {
	private final DojoPlayService DojoPlayService;
	private final UserValidator userValidator;
	public DojoPlayController(DojoPlayService DojoPlayService, UserValidator userValidator) {
		this.DojoPlayService=DojoPlayService;
		this.userValidator=userValidator;
	}
	
    @RequestMapping("")
    public String loginRegistration(@ModelAttribute("user") User user) {
    	return "signIn.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
	    userValidator.validate(user, result);
	    if(result.hasErrors()) {
	    	return "signIn.jsp";
	    } else {
	    User u = DojoPlayService.registerUser(user);
	    session.setAttribute("user", u);
	    return "redirect:/games";
	    }
    }
    @RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(RedirectAttributes redirectAttributes, @RequestParam("email") String email, @RequestParam("password") String password,Model model, HttpSession session) {
	    boolean check=DojoPlayService.authenticateUser(email, password);
	    if (check == false) {
	    	redirectAttributes.addFlashAttribute("error", "There was something wrong with your credintials.");
	    	return "redirect:/";
	    } else {
	    	User user=DojoPlayService.findByEmail(email);
	    	session.setAttribute("user", user);
	    	return "redirect:/games";
	    }
    }
	@RequestMapping("/games")
	public String home(Model model,HttpSession session) {
	    return "index.jsp";
	}
	@RequestMapping(value="/games/add", method=RequestMethod.POST)
	public String addGame(@Valid @ModelAttribute("game") Game game, BindingResult result) {
		Game g = DojoPlayService.addGame(game);
		return "redirect:/games";
	}
}

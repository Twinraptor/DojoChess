<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
	<h1>Welcome to Coding Dojo Chess!</h1>
	<p>Please sign in or register.</p>
	

	<div id="credintials">
    <div id="register">
	<h1>Register</h1>
    <p><form:errors path="user.*"/></p>
    <form:form method="POST" action="/registration" modelAttribute="user">
        <p>
            <form:label path="name">Name:</form:label>
            <form:errors path="name" />
            <form:input path="name"/>
        </p>

        <p>
            <form:label path="email">Email:</form:label>
            <form:errors path="email" />
            <form:input type="email" path="email"/>
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:errors path="password" />
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password path="passwordConfirmation"/>
        </p>
        <input type="submit" value="Register!"/>
    </form:form>
    </div>
    <div id="login">
		<h1>Login</h1>
    		<p><c:out value="${error}" /></p>
    			<form method="post" action="/login">
        			<p>
            			<label for="email">Email</label>
            			<input type="text" id="email" name="email"/>
        			</p>
        			<p>
            			<label for="password">Password</label>
            			<input type="password" id="password" name="password"/>
        			</p>
        			<input type="submit" value="Login!"/>
    			</form>
	</div>
	</div>
    </div>
</body>
</html>
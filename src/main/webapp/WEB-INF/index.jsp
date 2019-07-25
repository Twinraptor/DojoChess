<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Coding Dojo Chess</title>
</head>
<body>
	<h1>Welcome to Coding Dojo Chess, <c:out value="${user.name}"/>!</h1>
	<div id="gamelist">
		<h2>List of games:</h2>
	</div>
	<div id="addgame">
		<form:form action="/games/add" method="post" modelAttribute="game">
			<p>
            	<form:label path="title">Title:</form:label>
            	<form:errors path="title" />
            	<form:input path="title"/>
        	</p>
			<p>
            	<form:label path="location">Location:</form:label>
            	<form:errors path="location" />
            	<form:input path="location"/>
        	</p>
        <input type="submit" value="Create"/>
		</form:form>
	</div>
</body>
</html>
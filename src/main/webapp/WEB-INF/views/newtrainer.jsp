
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>New Trainer</title>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">New Trainer</h1>
            <div style="margin-top: 100px;"><p>Register a new Trainer.</p></div>
            <form:form method="POST" action="new" modelAttribute="trainer">
                <form:input type="hidden" path="id" id="id"/> 
                <div class="form-group">
                    <label for="fn">First name:</label>
                    <form:input path="firstName" type="text" class="form-control" id="fn"/>
                </div>
                <div class="form-group">
                    <label for="ln">Last name:</label>
                    <form:input path="lastName" type="text" class="form-control" id="ln"/>
                </div>
                <div class="form-group">
                    <label for="sbj">Subject:</label>
                    <form:input path="subject" type="text" class="form-control" id="sbj"/>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form:form>
            <div id="msg" style="color: ${color};">${message}</div>
            <a href="<c:url value='${listurl}' />" role="button" class="btn btn-secondary btn-md btn-block">Back to the list of Trainers</a>    
        </div>
    </body>
</html>

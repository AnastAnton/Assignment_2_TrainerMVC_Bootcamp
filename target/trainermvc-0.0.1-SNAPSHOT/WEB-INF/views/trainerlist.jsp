
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Trainers</title>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center" style="margin-top: 20px;">List of Trainers</h1>
            <div style="margin-top: 100px;"><p>Click on id's <u>number</u> to update the Trainer or on <u>Delete</u> button to delete the Trainer.</p></div>
            <table class="table table-hover table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>Subject</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${trainers}" var="trainer">
                        <tr>
                            <th><a href="<c:url value='${editurl}/${trainer.id}' />">${trainer.id}</a></th>
                            <td>${trainer.firstName}</td>
                            <td>${trainer.lastName}</td>
                            <td>${trainer.subject}</td>
                            <th><a href="<c:url value='${deleteurl}/${trainer.id}' />">Delete</a></th>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div id="msg">${msg}</div>
            <form action="new">
                <button type="submit" class="btn btn-primary">Register new Trainer</button>
            </form>
        </div>
    </body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Cupboard</title>
    <jsp:include page="setupPageJsp.jsp" flush="true"/>
</head>
<body>
<div class="container">
    <a class="btn btn-primary btn-xs" href="/" role="button">All Cupboard</a>
    <h1><p class="text-center">All Cupboard</p></h1>
    <p align="right"><a class="btn btn-info btn-xs" href="/save/cupboard" role="button">add cupboard</a></p>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th></th>
        </tr>
        <c:forEach var="cupboard" items="${cupboards}">
            <tr id="cupboardTrId${cupboard.id}">
                <td> ${cupboard.id}</td>
                <td> ${cupboard.name}</td>
                <td>
                    <p class="text-right">
                        <a class="btn btn-primary btn-xs" href="/view/cupboard/${cupboard.id}"
                           role="button">view</a>
                        <a onclick="deleteById(${cupboard.id}, 'cupboard')"
                           class="btn btn-danger btn-xs"
                           role="button">delete</a>
                        <a class="btn btn-success btn-xs" href="/save/cupboard/${cupboard.id}"
                           role="button">edit</a>
                    </p>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
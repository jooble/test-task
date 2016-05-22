<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All the equipment cupboard</title>
    <jsp:include page="setupPageJsp.jsp" flush="true"/>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="container">
    <p>
    <p>
        <a class="btn btn-primary btn-xs" href="" role="button">All Cupboard</a>
    </p>
    </p>
    <h1><p class="text-center">All the equipment cupboard (ID - ${cupboard.id})</p></h1>
    <p align="right"><a class="btn btn-info btn-xs" href="cupboard/${cupboard.id}/save/equipment" role="button">add
        equipment</a></p>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Type</th>
            <th>Model</th>
            <th>Inventory Number</th>
            <th></th>
        </tr>
        <c:forEach var="equipment" items="${cupboard.equipments}">
            <tr id="equipmentTrId${equipment.id}">
                <td> ${equipment.id}</td>
                <td> ${equipment.type}</td>
                <td> ${equipment.model}</td>
                <td> ${equipment.inventoryNumber}</td>
                <td>
                    <spring:url value="'delete/equipment/${equipment.id}'" var="deleteUrl"/>
                    <p class="text-right">
                        <a onclick="deleteById(${equipment.id}, 'equipment', ${deleteUrl})"
                           class="btn btn-danger btn-xs"
                           role="button">delete</a>
                        <a class="btn btn-success btn-xs" href="save/equipment/${equipment.id}"
                           role="button">edit</a>
                    </p>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
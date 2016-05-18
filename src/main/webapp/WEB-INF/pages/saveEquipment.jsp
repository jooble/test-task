<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Equipment</title>
    <jsp:include page="setupPageJsp.jsp" flush="true"/>
</head>
<body>
<div class="container">
    <a class="btn btn-primary btn-xs" href="/" role="button">All Cupboard</a>
    <h1><p class="text-center">Save equipment to cupboard (ID - ${equipmentForm.cupboardId}).</p></h1>
    <form:form method="post" action="/save/equipment" commandName="equipmentForm">
        <form:input class="form-control" id="id" path="id" value="${equipmentForm.id}" type="hidden"/>
        <form:input class="form-control" id="cupboardId" path="cupboardId" value="${equipmentForm.cupboardId}"
                    type="hidden"/>
        <div class="form-group">
            <label>Model</label>
            <form:input class="form-control" id="model" path="model" placeholder="Model"
                        value="${equipmentForm.model}"/>
            <form:errors path="model" cssStyle="color: #ff0000;"/>
        </div>
        <div>
            <label>Type</label>
            <form:select path="type" class="form-control">
                <c:forEach var="type" items="${types}">
                    <option value="${type}">${type}</option>
                </c:forEach>
            </form:select>
        </div>
        <br>
        <div class="form-group">
            <label>Inventory Number</label>
            <form:input class="form-control" id="inventoryNumber" path="inventoryNumber" placeholder="Inventory Number"
                        value="${equipmentForm.inventoryNumber}"/>
            <form:errors path="inventoryNumber" cssStyle="color: #ff0000;"/>
        </div>
        <input class="btn btn-success btn-xs" type="submit" value="save">
        <a class="btn btn-default btn-xs" href="/view/cupboard/${equipmentForm.cupboardId}" role="button">cancel</a>
    </form:form>
    </form>
</div>
</body>
</html>
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
    <p>
    <p>
        <a class="btn btn-primary btn-xs" href="" role="button">All Cupboard</a>
    </p>
    </p>
    <h1><p class="text-center">Save equipment to cupboard (ID - ${equipment.cupboard.id}).</p></h1>
    <form:form method="post" action="save/equipment" commandName="equipment">
        <form:input class="form-control" id="id" path="id" value="${equipment.id}" type="hidden"/>
        <form:input class="form-control" id="cupboard.id" path="cupboard.id" value="${equipment.cupboard.id}"
                    type="hidden"/>
        <div class="form-group">
            <label>Model</label>
            <form:input class="form-control" id="model" path="model" placeholder="Model"
                        value="${equipment.model}"/>
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
                        value="${equipment.inventoryNumber}"/>
            <form:errors path="inventoryNumber" cssStyle="color: #ff0000;"/>
        </div>
        <input class="btn btn-success btn-xs" type="submit" value="save">
        <a class="btn btn-default btn-xs" href="view/cupboard/${equipment.cupboard.id}" role="button">cancel</a>
    </form:form>
    </form>
</div>
</body>
</html>
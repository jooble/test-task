<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="setupPageJsp.jsp" flush="true"/>
</head>
<body>
<c:forEach var="cupboard" items="${cupboards}">
    ${cupboard.id}
    ${cupboard.name}
    <br>
    <c:forEach var="equipment" items="${cupboard.equipmentMap}">
        ${equipment.key} - ${equipment.value.size()}
        <br>
    </c:forEach>
    <br>
</c:forEach>
</body>
</html>

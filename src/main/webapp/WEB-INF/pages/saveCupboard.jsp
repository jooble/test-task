<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<?xml version="1.0" encoding="UTF-8" ?>
<html>
<head>
    <title>Save Currency</title>
    <jsp:include page="setupPageJsp.jsp" flush="true"/>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="container">
    <p>
    <p>
        <a class="btn btn-primary btn-xs" href="${contextPath}/" role="button">All Cupboard</a>
    </p>
    </p>
    <h1><p class="text-center">Save Cupboard</p></h1>
    <form:form method="post" action="${contextPath}/save/cupboard" commandName="cupboard">
        <form:input class="form-control" id="id" path="id" value="${cupboard.id}" type="hidden"/>
        <label>Name</label><br/>
        <div class="form-group">
            <form:input class="form-control" id="name" path="name" placeholder="Name"
                        value="${cupboard.name}"/>
            <form:errors path="name" cssStyle="color: #ff0000;"/>
        </div>
        <input class=" btn btn-success btn-xs" type="submit" value="save">
        <a class="btn btn-default btn-xs" href="${contextPath}/" role="button">cancel</a>
    </form:form>
</div>
</body>
</html>
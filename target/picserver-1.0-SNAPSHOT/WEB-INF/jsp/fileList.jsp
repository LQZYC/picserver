
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>File List</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>
<div id="global">
    <h4>已经成功上传的文件</h4>
    <p>
        <ol>
        <c:forEach items="${files}" var="file">
            <li>${file}
            <img width="100" src="<c:url value="/downLoadFile/"/>${file}"/>
            </li>
        </c:forEach>
        </ol>
    </p>
</div>
</body>
</html>

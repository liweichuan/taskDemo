<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
<h1 style="text-align: center">错误信息界面</h1>
 <c:if test="${errors!=null&&errors.size()>0}">
     <c:forEach items="${errors}" var="error">
         ${error.defaultMessage}<br/>
     </c:forEach>
 </c:if>
<a href="${pageContext.request.contextPath}/student/list">返回用户界面</a>
</body>
</html>

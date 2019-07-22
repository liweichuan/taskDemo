<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加用户</title>
</head>
<body>
<h1>添加用户</h1>
<form name="studentForm" action="${pageContext.request.contextPath}/student" method="post">

    姓名：<input type="text" name="name"><br>
    QQ:<input type="text" name="qq"><br>
    学习类型：<input type="text" name="type"><br>
    入学时间：<input type="text" name="start_time"><br>
    毕业院校：<input type="text" name="school"><br>
    ID：<input type="text" name="student_id"> <br>
    日报链接：<input type="text" name="link"><br>
    愿望：<input type="text" name="wish"><br>
    师兄：<input type="text" name="bro"><br>
    方式：<input type="text" name="way"><br>
    创建时间：<input type="text" name="create_time" value=""><br>
    更新时间：<input type="text" name="update_time" value=""><br>
    <input type="submit" value="添加" />
</form>
</body>
</html>

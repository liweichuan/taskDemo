<%@ page contentType="text/html;charset=GBK" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 <head>
    <title>JSTL: -- forEach��ǩʵ��</title>
 </head>
 <body>
<h4><c:out value="forEachʵ��"/></h4>
 <hr>
     <%
       List a=new ArrayList();
      a.add("����");
      a.add("����");
      a.add("����");
      a.add("ӨӨ");
      a.add("����");
  request.setAttribute("a",a);
%>
     <B><c:out value="��ָ��begin��end�ĵ�����" /></B><br>
    <c:forEach var="fuwa" items="${a}">
     &nbsp;<c:out value="${fuwa}"/><br>
       </c:forEach>
     <B><c:out value="ָ��begin��end�ĵ�����" /></B><br>
   <c:forEach var="fuwa" items="${a}" begin="1" end="3" step="2">
    &nbsp;<c:out value="${fuwa}" /><br>
    </c:forEach>
    <B><c:out value="���������������Ϣ��" /></B><br>
    <c:forEach var="fuwa" items="${a}" begin="3" end="4" step="1" varStatus="s">
    &nbsp;<c:out value="${fuwa}" />���������ԣ�<br>
    &nbsp;&nbsp;����λ�ã���������<c:out value="${s.index}" /><br>
    &nbsp;&nbsp;�ܹ��ѵ����Ĵ�����<c:out value="${s.count}" /><br>
    &nbsp;&nbsp;�Ƿ�Ϊ��һ��λ�ã�<c:out value="${s.first}" /><br>
    &nbsp;&nbsp;�Ƿ�Ϊ���һ��λ�ã�<c:out value="${s.last}" /><br>
 </c:forEach>
</body>
</html>

<%--<c:forTokens> ��������ַ�����������ָ�����ַ�����ȡ�ַ���--%>
<%-- �﷨��<c:forTokens items="stringOfTokens" delims="delimiters" [var="name" --%>
<%-- begin="begin" end="end" step="len" varStatus="statusName"]></c:forTokens>--%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
     <head>
        <title>JSTL: -- forTokens��ǩʵ��</title>
     </head>
  <body>
         <h4>
           <c:out value="forTokenʵ��" />
         </h4>
      <hr>
         <c:forTokens items="������������ӭ����" delims="��" var="c1">
            <c:out value="${c1}"></c:out>
         </c:forTokens>
         <br>
         <c:forTokens items="123-4567-8854" delims="-" var="t">
            <c:out value="${t}"></c:out>
         </c:forTokens>
         <br>
         <c:forTokens items="1*2*3*4*5*6*7" delims="*" begin="1" end="3"
            var="n" varStatus="s">
         &nbsp;<c:out value="${n}" />���������ԣ�<br>
         &nbsp;&nbsp;����λ�ã���������<c:out value="${s.index}" />
             <br>
         &nbsp;&nbsp;�ܹ��ѵ����Ĵ�����<c:out value="${s.count}" />
             <br>
         &nbsp;&nbsp;�Ƿ�Ϊ��һ��λ�ã�<c:out value="${s.first}" />
             <br>
         &nbsp;&nbsp;�Ƿ�Ϊ���һ��λ�ã�<c:out value="${s.last}" />
             <br>
         </c:forTokens>
     </body>
</html>
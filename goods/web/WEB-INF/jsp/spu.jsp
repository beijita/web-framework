<%@ page language="java" import="com.fanzs.entity.Spu" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<c:set var="BASE" value="${pageContext.request.contextPath}"></c:set>--%>
<html>
<head>
    <title>商品管理</title>
</head>
<body>
<%
    //取得域对象中的内容
    List<Spu> stringList = (List<Spu>) request.getAttribute("spuList");
%>
<table border="1" align="center">
    <caption>商品列表</caption>
    <tr>
        <th>商品编码</th>
        <th>商品名称</th>
        <td>操作</td>
    </tr>
    <%
        for (Spu spu : stringList) {
    %>
    <tr>
        <th><%=spu.getSpuCode()%>
        </th>
        <th><%=spu.getSpuName()%>
        </th>
        <td><a href="#">查看</a></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
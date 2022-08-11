<%@ page import="com.chukwuma.commerceweb.util.DBConnection" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>HOME PAGE</title>
    <%@include file="includes/header.jsp"%>
    <style>
        header {
            margin: 20px;
        }
        #home-image{
            width: 90vw;

        }
    </style>
</head>
<body>
<%@include file="includes/nav.jsp"%>
<header>
<div>
    <h2>Babbage Sound And Audio Reinforcements</h2>
    <br>
</div>
<img id = "home-image" src="https://th.bing.com/th/id/R.5a8f703067d351d7c66149c2c44d8587?rik=3y46%2fxJTMD9VmA&pid=ImgRaw&r=0&sres=1&sresct=1" >
</header>

<%--<%--%>
<%--   out.println(DBConnection.getConnection());--%>
<%--%>--%>

<%@include file="includes/footer.jsp"%>
</body>
</html>
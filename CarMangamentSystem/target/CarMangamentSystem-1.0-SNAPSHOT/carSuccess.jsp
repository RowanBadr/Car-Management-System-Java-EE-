<%--
  Created by IntelliJ IDEA.
  User: Badr
  Date: 11/19/2025
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car Added Successfully</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 50px; }
        .success { color: green; }
        a { display: inline-block; margin-top: 20px;
            padding: 10px 20px; background-color: #008CBA;
            color: white; text-decoration: none; }
    </style>
</head>
<body>
<h1 class="success">Success!</h1>
<p><%= request.getAttribute("message") %></p>
<a href="car2">Add Another Car</a>
</body>
</html>

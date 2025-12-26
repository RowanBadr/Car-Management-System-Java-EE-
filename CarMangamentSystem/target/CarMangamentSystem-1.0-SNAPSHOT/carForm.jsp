<%--
  Created by IntelliJ IDEA.
  User: Badr
  Date: 11/19/2025
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Car</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 50px; }
        form { max-width: 400px; }
        input { margin: 10px 0; padding: 5px; width: 100%; }
        button { padding: 10px 20px; background-color: #4CAF50;
            color: white; border: none; cursor: pointer; }
    </style>
</head>
<body>
<h1>Add New Car</h1>
<form method="POST" action="car2">
    <label for="id">Car ID:</label>
    <input type="text" id="id" name="id" required><br>
    <label for="model">Model:</label>
    <input type="text" id="model" name="model" required><br>
    <label for="make">Make:</label>
    <input type="text" id="make" name="make" required><br>
    <label for="year">Year:</label>
    <input type="number" id="year" name="year" required><br>
    <button type="submit">Add Car</button>
</form>
</body>
</html>

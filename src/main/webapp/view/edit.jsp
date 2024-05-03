<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/3/2024
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Document</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        .container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
            text-align: center;
        }
        form {
            margin-top: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #333;
        }
        input[type="text"],
        textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Edit Document</h1>
    <form action="documents" method="post">
        <input type="hidden" name="action" value="edit">
        <input type="hidden" name="id" value="${document.id}">
        <label for="code">Code:</label>
        <input type="text" id="code" name="code" value="${document.code}">
        <br>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${document.name}">
        <br>
        <label for="year">Year:</label>
        <input type="number" id="year" name="year" value="${document.year}">
        <br>
        <label for="description">Description:</label>
        <textarea id="description" name="description">${document.description}</textarea>
        <br>
        <input type="submit" value="Save Changes">
    </form>
</div>
</body>
</html>


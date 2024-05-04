<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create New Document</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        h2 {
            color: #333;
            margin-top: 0;
        }
        form {
            margin-top: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #333;
        }
        input[type="number"],
        input[type="text"],
        textarea {
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
    <h1>View Document</h1>
        <input type="hidden" name="action" value="edit">
        <input type="hidden" name="id" value="${document.id}" readonly>
        <label for="code">Code:</label>
        <input type="text" id="code" name="code" value="${document.code}" readonly>
        <br>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${document.name}" readonly>
        <br>
        <label for="year">Year:</label>
        <input type="number" id="year" name="year" value="${document.year}" readonly>
        <br>
        <label for="description">Description:</label>
        <textarea id="description" name="description" readonly>${document.description}</textarea>
        <br>
        <a href="/documents"> Quay lại </a>
</div>
</body>
</html>

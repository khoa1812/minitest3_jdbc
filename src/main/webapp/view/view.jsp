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
    <h2>Tạo Tài Liệu Mới</h2>
    <form action="/documents" method="post">
        <input type="hidden" name="action" value="create">
        <div>
            <label for="id">ID:</label>
            <input type="number" id="id" name="id" required>
        </div>
        <div>
            <label for="code">Loại tài liệu:</label>
            <input type="text" id="code" name="code" required>
        </div>
        <div>
            <label for="name">Tên tài liệu:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div>
            <label for="year">Năm lưu trữ:</label>
            <input type="number" id="year" name="year" required>
        </div>
        <div>
            <label for="description">Mô tả:</label>
            <textarea id="description" name="description" required></textarea>
        </div>
        <div>
            <button type="submit">Tạo</button>
        </div>
    </form>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/3/2024
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create New Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <link href="styles/custom.css" rel="stylesheet">
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
            <input type="text" id="description" name="description" required>
        </div>
        <div>
            <button type="submit">Tạo</button>
        </div>
    </form>
</div>
</body>
</html>


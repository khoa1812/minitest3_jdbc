<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/3/2024
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>List of Documents</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        h1 {
            color: #333;
            margin-top: 0;
        }
        .document {
            margin-bottom: 20px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #fff;
        }
        h2 {
            margin-top: 0;
            margin-bottom: 10px;
        }
        p {
            color: #666;
            margin-bottom: 10px;
        }
        .actions a {
            margin-right: 10px;
            text-decoration: none;
            color: #007bff;
        }
        .actions a:hover {
            text-decoration: underline;
        }
        .create-link {
            display: block;
            margin-top: 20px;
            text-decoration: none;
            color: #007bff;
        }
        .create-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>List of Documents</h1>
    <table>
        <tr>
            <th>id</th>
            <th>code</th>
            <th>name</th>
            <th>year</th>
            <th>description</th>
        </tr>
        <c:forEach var="document" items="${documents}">
            <tr>
                <td><c:out value="${document.id}"/></td>
                <td><c:out value="${document.code}"/></td>
                <td><c:out value="${document.name}"/></td>
                <td><c:out value="${document.year}"/></td>
                <td><c:out value="${document.description}"/></td>
                <td>
                    <a href="documents?action=view&id=${document.id}">View</a>
                    <a href="documents?action=edit&id=${document.id}">Edit</a>
                    <a href="documents?action=delete&id=${document.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>


    <a class="create-link" href="documents?action=create">Create New Document</a>
</div>
</body>
</html>


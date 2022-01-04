<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="elements" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="author" content="Ilya">
    <style>
        <%@include file="/WEB-INF/view/style/style-all-books.css" %>
    </style>
    <title>All books</title>
</head>
<body>
<h1>All books</h1>
<div class="table">
    <table>
        <tr>
            <th>Name</th>
            <th>Author</th>
            <th>Year</th>
            <th>Publisher</th>
            <th>Pages</th>
            <th>Genre</th>
            <th>ISBN</th>
        </tr>
        <elements:forEach var="element" items="${allBook}">
            <elements:url var="deleteButton" value="/delete-book">
                <elements:param name="bookId" value="${element.id}"/>
            </elements:url>

            <tr>
                <td>${element.name}</td>
                <td>${element.author}</td>
                <td>${element.yearOfPublication}</td>
                <td>${element.publisher}</td>
                <td>${element.pages}</td>
                <td>${element.genre}</td>
                <td>${element.isbn}</td>
                <td>
                    <input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'">
                </td>
            </tr>
        </elements:forEach>


    </table>
</div>
<input class="button-add" type="button" value="Add" onclick="window.location.href = '/add-book'"/>
</body>
</html>

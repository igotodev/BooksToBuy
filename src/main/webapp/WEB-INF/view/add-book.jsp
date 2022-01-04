<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="author" content="Ilya">
    <style>
        <%@include file="/WEB-INF/view/style/style-add-book.css" %>
    </style>
    <title>New Book</title>
</head>
<body>
<h1>New book</h1>

<form:form action="/save-book" modelAttribute="book" method="post">
    <form:hidden path="id"/>

    <h4>Name</h4>
    <p><form:input path="name"/> <form:errors path="name" cssStyle="color: red; font-size: small"/></p>
    <h4>Author</h4>
    <p><form:input path="author"/> <form:errors path="author" cssStyle="color: red; font-size: small"/></p>
    <h4>Year</h4>
    <p><form:input path="yearOfPublication"/> <form:errors path="yearOfPublication"
                                                           cssStyle="color: red; font-size: small"/></p>
    <h4>Genre</h4>
    <p><form:input path="genre"/> <form:errors path="genre" cssStyle="color: red; font-size: small"/></p>
    <h4>Pages</h4>
    <p><form:input path="pages"/> <form:errors path="pages" cssStyle="color: red; font-size: small"/></p>
    <h4>Publisher</h4>
    <p><form:input path="publisher"/> <form:errors path="publisher" cssStyle="color: red; font-size: small"/></p>
    <h4>ISBN</h4>
    <p><form:input path="isbn"/> <form:errors path="isbn" cssStyle="color: red; font-size: small"/></p>

    <br>
    <input type="submit" value="Add"/>
</form:form>

</body>
</html>
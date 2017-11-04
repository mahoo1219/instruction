<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mahoo
  Date: 2017/11/2
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>

<div id="global">
    <h1>Book List</h1>
    <a href="<c:url value="/input-book"/>">Add Book</a>
    <table>
        <tr>
            <th>Category</th>
            <th>Title</th>
            <th>ISBN</th>
            <th>Author</th>
            <th>Price</th>
            <th>Date</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.category.name}</td>
                <td>${book.title}</td>
                <td>${book.isbn}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
                <th>${book.localDate}</th>
                <td><a href="/edit-book/${book.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
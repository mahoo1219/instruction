<%--
  Created by IntelliJ IDEA.
  User: Mahoo
  Date: 2017/11/2
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div id="global">
    <form:form commandName="book" action="save-book" method="post">
        <fieldset>
            <legend>Add a book</legend>
            <p>
                <label for="category">Category:</label>
                <form:select id="category" path="category.id" items="${categories}" itemLabel="name" itemValue="id"/>
            </p>
            <p>
                <label for="author">Author: </label>
                <form:input path="author" id="author"/>
            </p>
            <p>
                <label for="isbn">ISBN:</label>
                <form:input id="isbn" path="isbn"/>
            </p>
            <p>
                <label for="price">Price:</label>
                <form:input path="price" id = "price" />
            </p>
            <p>
                <label for="date">Date:</label>
                <form:input path="localDate" id = "date" />
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5" value="Add Book">
            </p>
        </fieldset>
    </form:form>
</div>
</body>
</html>


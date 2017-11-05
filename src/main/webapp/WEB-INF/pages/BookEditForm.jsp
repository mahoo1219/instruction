<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mahoo
  Date: 2017/11/2
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Edit Book Form</title>
</head>
<body>
<div id="global">
    <c:url var="formAction" value="/update-book"/>
    <form:form commandName="book" action="${formAction}" method = "post">
    <fieldset>
        <legend>Edit a Book</legend>
        <form:hidden path="id"/>
        <p>
            <label for="category">Category: </label>
            <form:select id = "category" path="category.id" items="${categories}" itemLabel="name" itemValue="id"/>
            <%--这里有个问题，但是我不知道如何修改，当第一次添加失败（日期问题），会返回到BookEditForm页面，但是category不见了，出现
            NullPointerException(BookController.java)。--%>
        </p>
        <p>
            <label for="author">Author: </label>
            <form:input path="author" id="author" />
        </p>
        <p>
            <label for="isbn">ISBN:</label>
            <form:input id="isbn" path="isbn"/>
        </p>
        <p>
            <form:errors path="price"/>
        </p>
        <p>
            <label for = "price" >Price: </label>
            <form:input path="price" id = "price"/>
        </p>
        <p>
            <form:errors path="localDate"/>
        </p>
        <p>
            <label for = "date" >Date: </label>
            <form:input path="localDate" id = "date"/>
        </p>
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">
            <input id="submit" type="submit" tabindex="5" value="Update Book">
        </p>
    </fieldset>
    </form:form>
</div>
</body>
</html>

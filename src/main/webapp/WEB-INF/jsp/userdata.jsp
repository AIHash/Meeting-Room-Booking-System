<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <title>User Profile</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
          <div id="nav-placeholder"></div>
    <script>
$(function(){
  $("#nav-placeholder").load("header.html");
});
</script>
        <h2>Your Details</h2>
        <table class="table table-inverse">
            <tbody>
                <tr>
                    <td>Last Name:</td>
                    <td>${ln}</td>
                </tr>
                <tr>
                    <td>First Name:</td>
                    <td>${fn}</td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>${email}</td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td>${phone}</td>
                </tr>
            </tbody>
        </table>
        <h2>Your Bookings</h2>
        <table class="table table-inverse">
            <hbody>
                <th>Start Date</th>
                <th>&emsp;</th>
                <th>End Date</th>
                <th>&emsp;</th>
                <th>Room</th>
            </hbody>
            <tbody>
                <c:forEach items="${books}" var="outBook">
                    <tr>
                        <td><fmt:formatDate value="${outBook.startDate}" pattern="dd.MM.yyyy HH:mm"/></td>
                        <td>&emsp;</td>
                        <td><fmt:formatDate value="${outBook.endDate}" pattern="dd.MM.yyyy HH:mm"/></td>
                        <td>&emsp;</td>
                        <td>${outBook.room}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
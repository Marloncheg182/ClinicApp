<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Spring Security</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">

    <!-- Custom style -->
    <link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">


</head>

<body>

<div class="container">

    <div class="jumbotron" style="margin-top: 20px;">
        <h1>Clinic Administration Database</h1>

        <p class="lead">Clinic Administration Base is a specialized site for medical registration,
            orientation in archived data, active patients and sequence of work between all subjects of this
            system. We provide an easy way and economy of time in condition of work planning. This is a test
            version 1.0 . Thank you for choosing us, good day and take care!</p>
        <sec:authorize access="!isAuthenticated()">
            <p><a class="btn btn-lg btn-success" href="<c:url value="/login" />" role="button">Login</a></p>
            <span style="float: right">
                <a href="?lang=en">en</a>
                <p><spring:message code="label.login"/></p>
                <a href="lang=ru">ru</a>
            </span>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <p>Please login:
                <sec:authentication property="principal.username"/></p>

            <p><a class="btn btn-lg btn-danger" href="<c:url value="/logout" />" role="button">Logout</a></p>
            <span style="float: right">
                <a href="?lang=en">en</a>
                <p><spring:message code="label.logout"/></p>
                <a href="lang=ru">ru</a>
            </span>
        </sec:authorize>
    </div>

    <div class="footer">
        <p>© property of Oleg Romanenchuk 2015</p>
    </div>

</div>
</body>
</html>

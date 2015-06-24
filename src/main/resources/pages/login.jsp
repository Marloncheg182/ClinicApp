<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>

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
    <link href="<core:url value="/pages/css/bootstrap.css" />" rel="stylesheet">

    <!-- Custom styles -->
    <link href="<core:url value="/pages/css/signin.css" />" rel="stylesheet">


</head>

<body>

<div class="container" style="width: 300px;">
    <core:url value="/j_spring_security_check" var="loginUrl" />
    <form action="${loginUrl}" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control" name="j_username" placeholder="Email address" required autofocus value="colibri">
        <input type="password" class="form-control" name="j_password" placeholder="Password" required value="1234">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
    </form>
</div>

</body>
</html>
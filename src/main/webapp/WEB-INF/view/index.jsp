<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Oleg Romanenchuk">

  <title><spring:message code="label.title" /></title>

  <!-- Bootstrap core CSS -->
  <link href="<c:url value="/resources/pages/css/bootstrap.css" />" rel="stylesheet">

  <!-- Custom style -->
  <link href="<c:url value="/resources/pages/css/jumbotron-narrow.css" />" rel="stylesheet">

</head>
<body>
<a href="<c:url value="/logout"/> ">
  <spring:message code="label.logout"/>
</a>
<h2><spring:message code="label.title2" /></h2>

</body>
</html>

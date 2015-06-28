<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

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
<h2><spring:message code="label.title2"/></h2>
<form:form method="post" action="add" commandName="clinic">
  <table>
    <tr>
      <td><form:label path="name">
      <spring:message code="label.name" />
        </form:label></td>
      <td><form:input path="name"/></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit"
      value="<spring:message code="label.submit" />" /></td>
    </tr>
  </table>
</form:form>
<h3><spring:message code="label.clinic"/></h3>
<c:if test="${!empty clinicList}">
  <table class="data">
<tr>
  <th>
    <spring:message code="label.name"/></th>
  </tr>
    <c:forEach items="${clinicList}" var="clinic">
            <tr>
              <td>${clinic.id}</td>
              <td>${clinic.name}</td>
              <td><a href="/delete/${clinic.id}">
                <spring:message code="label.delete"/></a> </td>
            </tr>
    </c:forEach>
  </table>
</c:if>

<form:form method="post" action="add" commandName="doctor">
  <table>
    <tr>
      <td><form:label path="first_name"/></td>
      <spring:message code="label.firstname" />
    </tr>
    <tr>
      <td><form:label path="last_name"/></td>
      <spring:message code="label.lastname" />
    </tr>
    <tr>
      <td><form:label path="first_name"/></td>
      <spring:message code="label.firstname" />
    </tr>
  </table>
</form:form>
</body>
</html>

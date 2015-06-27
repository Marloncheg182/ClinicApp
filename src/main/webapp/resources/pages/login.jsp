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
    <meta name="author" content="Oleg Romanenchuk">

    <title><spring:message code="label.title" /></title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/pages/css/bootstrap.css" />" rel="stylesheet">

    <!-- Custom style -->
    <link href="<c:url value="/resources/pages/css/jumbotron-narrow.css" />" rel="stylesheet">

</head>
<body>
<form>

<a href="<c:url value="../../WEB-INF/view/index.jsp" /> " />
     <spring:message code="label.redirection" />
</a></br>

<c:if test="${not empty param.error}">
    <span style="color: #8b0000; "><spring:message code="label.loginerror" />
    : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
    </span>
</c:if>

<form method="post" action="<c:url value="/j_spring_security_check" />" />
<table>
    <tr>
        <td align="right"><spring:message code="label.login"/></td>
        <td><input type="text" name="j_username" /></td>
    </tr>
    <tr>
        <td align="right"><spring:message code="label.password"/></td>
        <td><input type="password" name="j_password" /></td>
    </tr>
    <tr>
        <td align="right"><spring:message code="label.remember"/></td>
        <td><input type="checkbox" name="_spring_security_remember_me"/></td>
    </tr>
    <tr>
        <td colspan="2" align="right"><input type="submit"
                value="Login" />
            <input type="reset" value="Reset"/></td>
    </tr>
</table>
</form>

<div class="container">
    <div class="jumbotron" style="margin-top: 20px;">
        <h1>Clinic Administration Database</h1>
        <p class="lead">Clinic Administration Base is a specialized site for medical registration,
            orientation in archived data, active patients and sequence of work between all subjects of this
            system. We provide an easy way and economy of time in condition of work planning. This is a test
            version 1.0 . Thank you for choosing us, good day and take care!</p>

    </div>

    <div class="footer">
        <p>© property of Oleg Romanenchuk 2015</p>
    </div>
</div>
</body>
</html>

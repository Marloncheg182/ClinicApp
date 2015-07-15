<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Oleg Romanenchuk">

    <title><spring:message code="label.title"/></title>

    <link href="<c:url value="/resources/pages/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/pages/css/jumbotron-narrow.css" />" rel="stylesheet">

</head>
<body>

<h2><spring:message code="label.title2"/></h2>
<form:form method="post" action="add" commandName="clinic">
    <table>
        <tr>
            <td><form:label path="name">
                <spring:message code="label.name"/>
            </form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   value="<spring:message code="label.submit" />"/></td>
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
                <td>${clinic.name}</td>
                <td><a href="/delete/${clinic.id}">
                    <spring:message code="label.delete"/></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<form:form method="post" action="add" commandName="doctor">
    <table>
        <tr>
            <td><form:label path="first name">
                <spring:message code="label.firstname"/>
            </form:label></td>
            <td><form:input path="first name"/></td>
        </tr>
        <tr>
            <td><form:label path="last name">
                <spring:message code="label.lastname"/>
            </form:label></td>
            <td><form:input path="last name"/></td>
        </tr>
        <tr>
            <td><form:label path="age">
                <spring:message code="label.age"/>
            </form:label></td>
            <td><form:input path="age"/></td>
        </tr>
        <tr>
            <td><form:label path="position">
                <spring:message code="label.position"/>
            </form:label></td>
            <td><form:input path="position"/></td>
        </tr>
        <tr>
            <td><form:label path="phone number">
                <spring:message code="label.phonenumber"/>
            </form:label></td>
            <td><form:input path="phone number"/></td>
        </tr>
        <tr>
            <td><form:label path="rating">
                <spring:message code="label.rating"/>
            </form:label></td>
            <td><form:input path="rating"/></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit"
                                   value="<spring:message code="label.submit" />"/></td>
        </tr>
    </table>
</form:form>
<h3><spring:message code="label.doctor"/></h3>
<c:if test="${!empty doctorList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.firstname"/></th>
            <th><spring:message code="label.lastname"/></th>
            <th><spring:message code="label.age"/></th>
            <th><spring:message code="label.position"/></th>
            <th><spring:message code="label.phonenumber"/></th>
            <th><spring:message code="label.rating"/></th>
        </tr>
        <c:forEach items="${doctorList}" var="clinic">
            <tr>
                <td>${doctor.firstName}</td>
                <td>${doctor.lastName}</td>
                <td>${doctor.age}</td>
                <td>${doctor.position}</td>
                <td>${doctor.phoneNumber}</td>
                <td>${doctor.rating}</td>
                <td><a href="/delete/${doctor.id}">
                    <spring:message code="label.delete"/></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<form:form method="post" action="add" commandName="card">
    <table>
        <tr>
            <td><form:label path="first name">
                <spring:message code="label.firstname"/>
            </form:label></td>
            <td><form:input path="first name"/></td>
        </tr>
        <tr>
            <td><form:label path="last name">
                <spring:message code="label.lastname"/>
            </form:label></td>
            <td><form:input path="last name"/></td>
        </tr>
        <tr>
            <td><form:label path="date">
                <spring:message code="label.date"/>
            </form:label></td>
            <td><form:input path="date"/></td>
        </tr>
        <tr>
            <td><form:label path="diagnosi">
                <spring:message code="label.diagnosis"/>
            </form:label></td>
            <td><form:input path="diagnosis"/></td>
        </tr>
        <tr>
            <td><form:label path="symptoms">
                <spring:message code="label.symptoms"/>
            </form:label></td>
            <td><form:input path="symptoms"/></td>
        </tr>
        <tr>
            <td><form:label path="additional notes">
                <spring:message code="label.additionalnotes"/>
            </form:label></td>
            <td><form:input path="additional notes"/></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit"
                                   value="<spring:message code="label.submit" />"/></td>
        </tr>
    </table>
</form:form>
<h3><spring:message code="label.card"/></h3>
<c:if test="${!empty cardList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.firstname"/></th>
            <th><spring:message code="label.lastname"/></th>
            <th><spring:message code="label.date"/></th>
            <th><spring:message code="label.diagnosis"/></th>
            <th><spring:message code="label.symptoms"/></th>
            <th><spring:message code="label.additionalnotes"/></th>
        </tr>
        <c:forEach items="${cardList}" var="card">
            <tr>
                <td>${card.firstName}</td>
                <td>${card.lastName}</td>
                <td>${card.date}</td>
                <td>${card.diagnosis}</td>
                <td>${card.symptoms}</td>
                <td>${card.addiyionalnotes}</td>
                <td><a href="/delete/${card.id}">
                    <spring:message code="label.delete"/></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<form:form method="post" action="add" commandName="nurse">
    <table>
        <tr>
            <td><form:label path="first name">
                <spring:message code="label.firstname"/>
            </form:label></td>
            <td><form:input path="first name"/></td>
        </tr>
        <tr>
            <td><form:label path="last name">
                <spring:message code="label.lastname"/>
            </form:label></td>
            <td><form:input path="last name"/></td>
        </tr>
        <tr>
            <td><form:label path="age">
                <spring:message code="label.age"/>
            </form:label></td>
            <td><form:input path="age"/></td>
        </tr>
        <tr>
            <td><form:label path="position">
                <spring:message code="label.position"/>
            </form:label></td>
            <td><form:input path="position"/></td>
        </tr>
        <tr>
            <td><form:label path="phone number">
                <spring:message code="label.phonenumber"/>
            </form:label></td>
            <td><form:input path="phone number"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   value="<spring:message code="label.submit" />"/></td>
        </tr>
    </table>
</form:form>
<h3><spring:message code="label.nurse"/></h3>
<c:if test="${!empty nurseList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.firstname"/></th>
            <th><spring:message code="label.lastname"/></th>
            <th><spring:message code="label.age"/></th>
            <th><spring:message code="label.position"/></th>
            <th><spring:message code="label.phonenumber"/></th>
        </tr>
        <c:forEach items="${nurseList}" var="nurse">
            <tr>
                <td>${nurse.firstName}</td>
                <td>${nurse.lastName}</td>
                <td>${nurse.age}</td>
                <td>${nurse.position}</td>
                <td>${nurse.phoneNumber}</td>
                <td><a href="/delete/${nurse.id}">
                    <spring:message code="label.delete"/></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<form:form method="post" action="add" commandName="patient">
    <table>
        <tr>
            <td><form:label path="first name">
                <spring:message code="label.firstname"/>
            </form:label></td>
            <td><form:input path="first name"/></td>
        </tr>
        <tr>
            <td><form:label path="last name">
                <spring:message code="label.lastname"/>
            </form:label></td>
            <td><form:input path="last name"/></td>
        </tr>
        <tr>
            <td><form:label path="age">
                <spring:message code="label.age"/>
            </form:label></td>
            <td><form:input path="age"/></td>
        </tr>
        <tr>
            <td><form:label path="phone number">
                <spring:message code="label.phonenumber"/>
            </form:label></td>
            <td><form:input path="phone number"/></td>
        </tr>
        <tr>
            <td><form:label path="state">
                <spring:message code="label.state"/>
            </form:label></td>
            <td><form:input path="state"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   value="<spring:message code="label.submit" />"/></td>
        </tr>
    </table>
</form:form>
<h3><spring:message code="label.patient"/></h3>
<c:if test="${!empty patientList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.firstname"/></th>
            <th><spring:message code="label.lastname"/></th>
            <th><spring:message code="label.age"/></th>
            <th><spring:message code="label.position"/></th>
            <th><spring:message code="label.phonenumber"/></th>
        </tr>
        <c:forEach items="${nurseList}" var="patient">
            <tr>
                <td>${patient.firstName}</td>
                <td>${patient.lastName}</td>
                <td>${patient.age}</td>
                <td>${patient.phoneNumber}</td>
                <td>${patient.state}</td>
                <td><a href="/delete/${patient.id}">
                    <spring:message code="label.delete"/></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<form:form method="post" action="add" commandName="analysis">
    <table>
        <tr>
            <td><form:label path="date">
                <spring:message code="label.date"/>
            </form:label></td>
            <td><form:input path="date"/></td>
        </tr>
        <tr>
            <td><form:label path="notes">
                <spring:message code="label.notes"/>
            </form:label></td>
            <td><form:input path="notes"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   value="<spring:message code="label.submit" />"/></td>
        </tr>
    </table>
</form:form>
<h3><spring:message code="label.analysis"/></h3>
<c:if test="${!empty analysisList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.date"/></th>
            <th><spring:message code="label.notes"/></th>
        </tr>
        <c:forEach items="${nurseList}" var="analysis">
            <tr>
                <td>${analysis.date}</td>
                <td>${analysis.notes}</td>
                <td><a href="/delete/${analysis.id}">
                    <spring:message code="label.delete"/></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<form:form method="post" action="add" commandName="procedure">
    <table>
        <tr>
            <td><form:label path="date">
                <spring:message code="label.date"/>
            </form:label></td>
            <td><form:input path="date"/></td>
        </tr>
        <tr>
            <td><form:label path="notes">
                <spring:message code="label.notes"/>
            </form:label></td>
            <td><form:input path="notes"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   value="<spring:message code="label.submit" />"/></td>
        </tr>
    </table>
</form:form>
<h3><spring:message code="label.procedure"/></h3>
<c:if test="${!empty procedureList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.date"/></th>
            <th><spring:message code="label.notes"/></th>
        </tr>
        <c:forEach items="${procedureList}" var="procedure">
            <tr>
                <td>${procedure.date}</td>
                <td>${procedure.notes}</td>
                <td><a href="/delete/${procedure.id}">
                    <spring:message code="label.delete"/></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<form:form method="post" action="add" commandName="operation">
    <table>
        <tr>
            <td><form:label path="date">
                <spring:message code="label.date"/>
            </form:label></td>
            <td><form:input path="date"/></td>
        </tr>
        <tr>
            <td><form:label path="type">
                <spring:message code="label.type"/>
            </form:label></td>
            <td><form:input path="type"/></td>
        </tr>
        <tr>
            <td><form:label path="result">
                <spring:message code="label.result"/>
            </form:label></td>
            <td><form:input path="result"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   value="<spring:message code="label.submit" />"/></td>
        </tr>
    </table>
</form:form>
<h3><spring:message code="label.operation"/></h3>
<c:if test="${!empty operationList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.date"/></th>
            <th><spring:message code="label.notes"/></th>
            <th><spring:message code="label.result"/></th>
        </tr>
        <c:forEach items="${operationList}" var="operation">
            <tr>
                <td>${operation.date}</td>
                <td>${operation.notes}</td>
                <td>${operation.result}</td>
                <td><a href="/delete/${operation.id}">
                    <spring:message code="label.delete"/></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<form:form method="post" action="add" commandName="insurance">
    <table>
        <tr>
            <td><form:label path="bankaccount">
                <spring:message code="label.bankaccount"/>
            </form:label></td>
            <td><form:input path="bankaccount"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   value="<spring:message code="label.submit" />"/></td>
        </tr>
    </table>
</form:form>
<h3><spring:message code="label.insurance"/></h3>
<c:if test="${!empty insuranceList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.bankaccount"/></th>
         </tr>
        <c:forEach items="${insuranceList}" var="insurance">
            <tr>
                <td>${insurance.bankaccount}</td>
                <td><a href="/delete/${insurance.id}">
                    <spring:message code="label.delete"/></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>

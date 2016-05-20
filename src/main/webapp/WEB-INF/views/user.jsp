<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/taglibs/customTaglib.tld" prefix="tag"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<c:url value='/webjars/bootstrap/3.3.5/css/bootstrap.min.css' />" />
    <title>User Page</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-8">
            <h3>Add/Edit a User</h3>
        </div>
        <div class="col-sm-4">
            <h3>Search a User</h3>
        </div>

        <div class="col-sm-8">
            <c:url var="addAction" value="/user/add?offset=${offset}" ></c:url>
            <form:form action="${addAction}" commandName="user" class="form-horizontal">
                <div class="form-group">
                    <form:label path="name" class="col-sm-3 control-label">
                        <spring:message text="Name"/>
                    </form:label>
                    <div class="col-sm-6">
                        <form:input path="name" class="form-control" placeholder="Name"/>
                        <form:hidden path="id" />
                    </div>
                </div>
                <div class="form-group">
                    <form:label path="age" class="col-sm-3 control-label">
                        <spring:message text="Age"/>
                    </form:label>
                    <div class="col-sm-6">
                        <form:input path="age" class="form-control" placeholder="Age"/>
                    </div>
                </div>
                <div class="form-group">
                    <form:label path="isAdmin" class="col-sm-3 control-label">
                        <spring:message text="Is Admin"/>
                    </form:label>
                    <div class="checkbox col-sm-6">
                        <label class="checkbox-inline">
                            <form:checkbox path="isAdmin" />
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <c:if test="${!empty user.name}">
                            <input type="submit" class="btn btn-primary"
                                   value="<spring:message text="Edit User"/>" />
                            <form:hidden path="createdDate" value="${user.createdDate}" />
                        </c:if>
                        <c:if test="${empty user.name}">
                            <input type="submit" class="btn btn-info"
                                   value="<spring:message text="Add User"/>" />
                        </c:if>
                    </div>
                </div>
            </form:form>
        </div>
        <div class="col-sm-4">
            <c:url var="searchAction" value="/search" ></c:url>
            <form:form action="${searchAction}" class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        <spring:message text="Name"/>
                    </label>
                    <div class="col-sm-6">
                        <input name="userName" class="form-control" placeholder="Name"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <input type="submit" class="btn btn-warning"
                               value="<spring:message text="Search User"/>" />
                    </div>
                </div>
            </form:form>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <h3>List of Users</h3>
        </div>
        <div class="col-sm-12">
            <c:if test="${!empty listUsers}">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Age</th>
                            <th>Is Admin</th>
                            <th>Creation Date</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listUsers}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.age}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${user.isAdmin}">
                                        <span class="glyphicon glyphicon-check" aria-hidden="true"></span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td><fmt:formatDate value="${user.createdDate}" type="date" dateStyle="medium" /></td>
                            <td><a class="btn btn-default btn-success" role="button" href="<c:url value='/edit/${user.id}?offset=${offset}' />" >Edit</a></td>
                            <td><a class="btn btn-default btn-danger" role="button" href="<c:url value='/remove/${user.id}?offset=${offset}' />" >Delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <c:url var="pageUrl" value="/users" />
                <tag:paginate max="10" uri="${pageUrl}" search="${search}" offset="${offset}" count="${count}" next="&raquo;" previous="&laquo;" />
            </c:if>
        </div>
    </div>
</div>

<script type="text/javascript" src="<c:url value='/webjars/jquery/2.1.1/jquery.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/webjars/bootstrap/3.3.5/js/bootstrap.min.js' />"></script>
</body>
</html>

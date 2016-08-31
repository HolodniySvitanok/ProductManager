<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<a href="${pageContext.servletContext.contextPath}/addUser">Добавить пользователя</a>

<table border="1px" cellspacing="0">
	<tr>
		<td width="30px">ID</td>
		<td  width="100px">Имя</td>
		<td  width="200px">Телефон</td>
		<td width="100px">Логин</td>
		<td width="200px">Дата регистрации</td>
		<td width="50px">Роль</td>
		<td width="300px">Адрес</td>
		<td width="100px">Действия</td>
	</tr>
	<c:forEach var="user" items="${users}">
		<tr>
		<td>${user.id}</td>
		<td>${user.name}</td>
		<td>${user.mobilePhone}</td>
		<td>${user.login}</td>
		<td>${user.dateRegistration}</td>
		<td>${user.role}</td>
		<td>${user.addressDescription}</td>
		<td>
			<a href="${pageContext.servletContext.contextPath}/showUser?id=${user.id}"> инф. </a>
			<a href="${pageContext.servletContext.contextPath}/setUser?id=${user.id}"> ред. </a>
			<a href="${pageContext.servletContext.contextPath}/deleteUser?id=${user.id}"> удл. </a>
		</td>
	</tr>
	</c:forEach>
	
</table>
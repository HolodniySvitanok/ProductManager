<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<form action="" method="POST">
		<table>
			<tr>
				<td colspan="2">${message}</td>
			</tr>
			<tr>
				<td>ID</td>
				<td><input type="text" value="${user.id}" readonly name="id"></td>
			</tr>
			<tr>
				<td>Имя</td>
				<td><input type="text" value="${user.name}" name="name" placeholder="введите имя"></td>
			</tr>
			<tr>
				<td>Телефон</td>
				<td><input type="text" value="${user.mobilePhone}" name="phone" placeholder="введите номер телефона"></td>
			</tr>
			<tr>
				<td>Логин</td>
				<td><input type="text" value="${user.login}" name="login" placeholder="введите Логин"></td>
			</tr>
			<tr>
				<td>Дата </td>
				<td><input type="text" value="${user.dateRegistration}" name="date" readonly></td>
			</tr>
			<tr>
				<td>Роль</td>
				<td><input type="text" value="${user.role}" name="role" placeholder="роль"></td>
			</tr>
			<tr>
				<td>Адрес</td>
				<td><input type="text" value="${user.addressDescription}" name="address" placeholder="введите адрес"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Сохранить"></td>
			</tr>
		</table>
	</form>
</div>
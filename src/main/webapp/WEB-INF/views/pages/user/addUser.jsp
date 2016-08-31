<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="" method="POST">
	<table>
		<tr>
			<td>Имя</td>
			<td><input type="text" name="name" placeholder="введите имя"></td>
		</tr>
		<tr>
			<td>Телефон</td>
			<td><input type="text" name="phone" placeholder="введите номер телефона"></td>
		</tr>
		<tr>
			<td>Логин</td>
			<td><input type="text" name="login" placeholder="введите Логин"></td>
		</tr>
		<tr>
			<td>Пароль</td>
			<td><input type="text" name="password" placeholder="введите пароль"></td>
		</tr>
		<tr>
			<td>Роль</td>
			<td><input type="text" name="role" placeholder="роль"></td>
		</tr>
		<tr>
			<td>Адрес</td>
			<td><input type="text" name="address" placeholder="введите адрес"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Сохранить"></td>
		</tr>
	</table>
</form>
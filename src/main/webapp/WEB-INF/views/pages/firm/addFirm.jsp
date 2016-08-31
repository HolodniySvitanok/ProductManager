<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<form action="" method="POST" enctype="multipart/form-data">
	<table>
		<tr>
			<td>Имя</td>
			<td><input type="text" name="name" placeholder="введите имя"></td>
		</tr>
		<tr>
			<td>Страна</td>
			<td><input type="text" name="country" placeholder="введите страну"></td>
		</tr>
		<tr>
			<td>Описание</td>
			<td><input type="text" name="description" placeholder="введите описание"></td>
		</tr>
		<tr>
			<td>Изображение</td>
			<td><input type="file" name="file"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Сохранить"></td>
		</tr>
	</table>
</form>
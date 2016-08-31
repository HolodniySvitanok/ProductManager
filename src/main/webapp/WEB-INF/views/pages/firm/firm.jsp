<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="link">
	<a href="${pageContext.servletContext.contextPath}/addFirm">Добавить производителя</a>
</div>
<div>
	<c:forEach var="firm" items="${firms}">
		<div class="imageFirm1">
			<div class="imageFirm2">
				<img src="${pageContext.servletContext.contextPath}/getImageFirm?id=${firm.id}">
				<div>${firm.id}${firm.name}</div>
				<div>
					<a href="#">ред.</a> <a href="${pageContext.servletContext.contextPath}/deleteFirm?id=${firm.id}">удл.</a>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
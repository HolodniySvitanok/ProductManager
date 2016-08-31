<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
	<title><tiles:insertAttribute name="title" ignore="true" /></title>

	<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/resources/css/style.css" />
	
	<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/resources/css/
		<tiles:insertAttribute name="css" ignore="true" />
	" />
	
	
	
<meta charset="utf-8">
</head>
<body>
	<tiles:insertAttribute name="header" />
	<div id="bodyPage">
		<div id="let">
			<tiles:insertAttribute name="left" />
		</div>
		<div id="main">
			<tiles:insertAttribute name="main" />
		</div>
	</div>
	<tiles:insertAttribute name="footer" />
</body>
</html>
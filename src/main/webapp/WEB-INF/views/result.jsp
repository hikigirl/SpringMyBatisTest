<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
</head>
<body class="wide">
	<!-- result.jsp -->
	<h1>result.jsp</h1>
	<div>result: ${result}</div>
	<br />
	<div>name: ${name}</div>
	<br />
	<div>dto: ${dto}</div>
	<div>seq: ${dto.seq}</div>
	<div>name: ${dto.name}</div>
	<div>age: ${dto.age}</div>
	<div>address: ${dto.address}</div>
	<div>gender: ${dto.gender}</div>
	<br />
	
</body>
</html>
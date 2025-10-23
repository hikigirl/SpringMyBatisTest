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
	<!-- list.jsp -->
	<h1>쿼리 결과</h1>
	<table class="content">
		<tr>
			<th>이름</th>
		</tr>
		<c:forEach items="${names}" var="name">
		<tr>
			<td>${name}</td>
		</tr>
		</c:forEach>
	</table>
	<hr />
	<table class="content">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>주소</th>
			<th>성별</th>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.seq}</td>
			<td>${dto.name}</td>
			<td>${dto.age}</td>
			<td>${dto.address}</td>
			<td>${dto.gender}</td>
		</tr>
		</c:forEach>
	</table>
	
	<hr />
	
	<c:forEach items="${alist}" var="adto">
	<div>${adto}</div>
	<hr />
	<div>${adto.pdto.aseq}</div>
	<hr />
	</c:forEach>
	
	<hr />
	<table>
		<c:forEach items="${ilist}" var="idto">
			<tr>
				<td>${idto.num}</td>
				<td>${idto.name}</td>
				<td>${idto.buseo}</td>
				<td>${idto.jikwi}</td>
				<td>${idto.salary}</td>
				<td class="left">
					<ul>
					<c:forEach items="${idto.project}" var="pdto">
						<li>${pdto.name}</li>
					</c:forEach>
					</ul>
				</td>
			</tr>
		
		</c:forEach>
	
	</table>
	
	
</body>
</html>
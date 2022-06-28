<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link href="resources/css/myStyle.css" rel="stylesheet" type="text/css">
<script>
	function selChange() {
		var sel = document.getElementById('cntPerPage').value;
		location.href="list?nowPage=${paging.nowPage}&cntPerPage="+sel;
	}
</script>
</head>
<body>
<div id="head">
<br><br>
<h1><a href="list"><i>HOME</i></a></h1>
</div>
<div id="mid">
<h1 align="center">도서관리 리스트</h1>
<br>
<table border="1" align="center" id="table1">
<tr>
	<th>등록번호</th><th>도서표지</th><th>도서 ISBN</th><th>도서 제목</th><th>저자</th><th>출판사</th><th>가격</th>
</tr>
<c:forEach var="book" items="${viewAll}" varStatus="status">
<tr>
	<td>${book.number }</td>
	<td><img src="resources/file/${book.imgName}" width="100px" height="150px"></td>
	<td>${book.isbn }</td>
	<td><a href="read?title=${book.title}">${book.title }</a></td>
	<td>${book.person }</td>
	<td>${book.publisher }</td>
	<td>${book.price }</td>
</tr>
</c:forEach>
</table>
<form action="search" method="get" align="center">
<h5>검색
	<input type="text" name="search">
	<input type="submit" value="찾기">
	<button type="button" onclick="location.href='add'">추가</button>
</h5>
</form>
	<div style="display: block; text-align: center;">		
		<c:if test="${paging.startPage != 1 }">
			<a href="list?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
		</c:if>
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<a href="list?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="list?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
		</c:if>
	</div>
</div>
</body>
</html>
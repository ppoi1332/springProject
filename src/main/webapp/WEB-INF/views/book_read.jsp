<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link href="resources/css/myStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="head">
<br><br>
<h1><a href="list"><i>HOME</i></a></h1>
</div>
<h1 align="center">도서정보관리 - 도서정보</h1>
<br>
<table border="1" align="center" id="table2">
	<tr>
		<td rowspan="5"><img src="resources/file/${showList.imgName}" width="100px" height="150px"></td><td>Book ISBN</td><td>${showList.isbn}</td>
	</tr>
	<tr>
		<td>도서명</td><td>${showList.title}</td>
	</tr>
	<tr>
		<td>저자</td><td>${showList.person}</td>
	</tr>
	<tr>
		<td>출판사</td><td>${showList.publisher}</td>
	</tr>
	<tr>
		<td>도서가격</td><td>${showList.price}</td>
	</tr>
	<tr>
		<td>책 소개</td><td colspan="3">${showList.cont}</td>	
	</tr>
</table>
<div id="bottom">
<button type="button" onclick="location.href='list'">목록</button>
</div>
</body>
</html>
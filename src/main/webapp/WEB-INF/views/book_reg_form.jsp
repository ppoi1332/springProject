<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link href="resources/css/myStyle.css" rel="stylesheet" type="text/css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="resources/script/script.js"></script>
</head>
<body>
<div id="head">
<br><br>
<h1><a href="list"><i>HOME</i></a></h1>
</div>
	<h1 align="center">도서정보관리 - 도서추가</h1>
	<form:form method="post" enctype="multipart/form-data" modelAttribute="bdt">
	<table border="1" align="center" id="table3">
		<tr><th colspan="3">* 표시는 필수 입니다</th></tr>
		<tr>
		<td rowspan="6"><img id="preview" width="100px" height="150px"></td>
		<td>* Book ISBN
		</td>
		<td>
		<form:input path="isbn"/>
		<form:errors path="isbn"/>
		</td>
		</tr>
		<tr>
		<td>* 도서명 <br>
		<form:errors path="title"/></td>
		<td>
		<form:input path="title"/>
		
		</td>
		</tr>
		<tr>
		<td>* 저자</td>
		<td>
		<form:input path="person"/>
		<form:errors path="person"/>
		</td>
		</tr>
		<tr>
		<td>* 출판사</td>
		<td>
		<form:input path="publisher"/>
		<form:errors path="publisher"/></td>
		</tr>
		<tr>
		<td>* 도서 가격</td>
		<td>
		<form:input path="price" />
		<form:errors path="price"/></td>
		</tr>
		<tr>
		<td>* 이미지</td>
		<td class="filebox">
			파일 <input class="upload-name" placeholder="첨부파일" name="imgName">
    		<label for="file">찾기
    		 </label>
    		<input type="file" id="file" class="upload-hidden" name="uploadFile" onchange="readURL(this);">
    		</td>
   		</tr>
		<tr>
		<td>* 책 소개</td>
		<td colspan="2"><textarea name="cont">
		</textarea><form:errors path="cont"/></td>
		</tr>
	</table>
	<div id="bottom">
	<input type="submit" value="추가">
	<button type="button" onclick="location.href='list'">목록</button>
	</div>
	</form:form>
</body>
</html>
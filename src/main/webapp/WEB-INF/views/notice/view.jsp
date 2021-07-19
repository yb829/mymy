<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ path }/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<h2>게시판</h2>
<div id="board-write-container">
	<table id="tbl-board">
		<tr>
			<th>글번호</th>
			<td>${notice.no}</td>
		</tr>
		<tr>
			<th>제 목</th>
			<td>${notice.title}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${notice.writerId}</td>
		</tr>
		<tr>
			<th>내 용</th>
			<td>${ notice.content }</td>
		</tr>
		<%--글작성자/관리자인경우 수정삭제 가능 --%>
		<tr>
			<th colspan="2">
				<c:if test="${ !empty loginMember && (loginMember.id == board.writerId 
									|| loginMember.role == 'ROLE_ADMIN') }">
					<button type="button" id="btnUpdate">수정</button>
					<button type="button" id="btnDelete">삭제</button>
				</c:if>

				<button type="button" onclick="location.href='${ path }/notice/list'">목록으로</button>
			</th>
		</tr>
	</table>
</div>
   
<script>
	$(document).ready(() => {
		$("#btnUpdate").on("click", (e) => {
			location.href = "${path}/notice/update?no=${notice.no}";
		});
		
		$("#btnDelete").on("click", (e) => {
			if(confirm("정말로 게시글을 삭제 하시겠습니까?")) {
				location.replace("${path}/notice/delete?boardNo=${notice.no}");
			}
		});
	});
</script>
</body>
</html>
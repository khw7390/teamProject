<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="update" method="post">
		<table width="300" cellpadding="0" cellspacing="0" border="1">
			<input type="hidden" name="num" value="${pd.num }">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="${pd.id }" size="20"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${pd.name }" size="20"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="age" value="${pd.age }"></input></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="입력">&nbsp;&nbsp; 
					<a href="list">목록보기</a>
				</td>
			</tr>
		</table>
	</form>
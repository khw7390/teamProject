<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="insert" method="post">
		<table width="300" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" size="20"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="20"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="age" value="20"></input></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="입력">&nbsp;&nbsp; 
					<a href="list">목록보기</a>
				</td>
			</tr>
		</table>
	</form>
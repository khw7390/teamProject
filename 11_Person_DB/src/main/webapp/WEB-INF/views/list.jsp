<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
list.jsp<br>
<!-- 
ArrayList list = dao.getAllPerson(); 
for( : list){

}
 -->

<table border="1">
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>이름</td>
		<td>나이</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>
	<c:forEach var="person" items="${requestScope.lists}">
        <tr>
            <td>${person.num}</td>
            <td>${person.getId()}</td>
            <td>${person['name']}</td>
            <td>${person.age}</td>
            <td><a href="updateForm?num=${person.num }">수정</a></td>
            <td><a href="delete?num=${person.num }">삭제</a></td>
        </tr>
    </c:forEach>

</table>
<br>
<a href="insertForm">삽입</a>

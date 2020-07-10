<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Emp Page</title>
<style type ="text/css">
table, th, td{
border: 1px solid black;
}
</style>
</head>
<body>
	<h1>Welcome to Employee Page</h1>
	<table>
		<thead>
		<tr>${cnt}</tr>
			<tr>
				<td>#</td>
				<td>员工姓名</td>
				<td>职位</td>
				<td>上级ID</td>
				<td>入职时间</td>
				<td>薪资</td>
				<td>部门ID</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="emp">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.mgr}</td>
					<td><fmt:formatDate value="${emp.hiredate}" pattern="yyyy/MM/dd"/></td>
					<td>${emp.sal}</td>
					<td>${emp.deptno}</td>
					
				</tr>
			</c:forEach>
		</tbody>






	</table>

</body>
</html>
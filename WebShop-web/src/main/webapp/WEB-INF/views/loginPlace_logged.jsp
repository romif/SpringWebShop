<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>


<%-- <script type="text/javascript">
var row = document.getElementById('topMenuRow');
var cell=row.insertCell(-1);
cell.innerHTML="<a href='/index?edit' alt='Редактор товаров'<%if (request.getParameter("edit")!=null){%>id='active'<%}%>>Редактор</a>";
</script> --%>

<h3>Добро пожаловать</h3>
<p class="welcomeLine">
	<strong><security:authentication property="principal.username" /></strong>
</p>
<p>
	<a href="${pageContext.request.contextPath}/index?userinfo" title="Личный кабинет">Личный
		кабинет</a> &nbsp;&nbsp; <a href="${pageContext.request.contextPath}/index?exit" title="Выйти">Выйти</a>
</p>
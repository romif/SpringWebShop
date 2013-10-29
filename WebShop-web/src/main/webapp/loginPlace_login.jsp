<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<h3>Авторизация</h3>
<s:url var="authUrl" value="/static/j_spring_security_check"></s:url>
<form name="login" id="loginF" action="${authUrl}" method="post">
	<input type="hidden" name="mode" id="log_mode" value="login"> <input type="hidden"
		name="type" id="log_type" value="email_password">
	<p class="posRelative">
		<!-- <label for="log_email" onclick="hideTitle(this)">e-mail</label> -->
		<input type="text" onfocus="clean(this)" onblur="showTitle(this)" name="j_username" id="log_email"
			value="">
	</p>
	<p class="posRelative">
		<!-- <label for="log_password" onclick="hideTitle(this)">пароль</label>  -->
		<input type="password" onfocus="clean(this)" onblur="showTitle(this)" id="log_password"
			name="j_password" value="">
	</p>
	<p class="errors" style="display: none;"></p>
	<div class="newLine">
		<input type="image" src="./TopmoBail_files/login_but.gif" class="formButton" id="signup"
			value="Войти" style="display: none;"> <a
			href="${pageContext.request.contextPath}/index?login#" title="Войти" class="formButton"
			onclick="javascript:document.getElementById(&#39;signup&#39;).click();return false">Войти</a>
		<p class="links">
			<a href="${pageContext.request.contextPath}/index?reg" title="Перейти на страницу регистрации"
				class="margLink">Регистрация</a> <a href="${pageContext.request.contextPath}/index?restore"
				title="Перейти на страницу востановления пароля">Забыли пароль?</a>
		</p>
	</div>
</form>
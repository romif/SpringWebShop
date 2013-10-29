<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>


<div class="content">

	<div id="shcart">
		<h3>Корзина</h3>
		<div class="shcartFrame">
			<iframe id="win_basket" name="win_basket" src="/index?shcart" class="shcart" scrolling="no"
				frameborder="0"></iframe>
		</div>
	</div>

	<div id="auth">
		<div id="loginPlace"
			style="background-image: none; background-position: initial initial; background-repeat: initial initial;">
			<security:authorize access="hasRole('ROLE_ANONYMOUS')">
				<jsp:include page="/loginPlace_login.jsp" />
			</security:authorize>
			<security:authorize access="hasRole('ROLE_USER')">
				<jsp:include page="/WEB-INF/views/loginPlace_logged.jsp" />
			</security:authorize>

		</div>
	</div>


</div>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>WebShop</title>
<link href="<s:url value="/" />/css/main.css" rel="stylesheet"
	type="text/css" />
</head>

<body>
	<div id="main">

		<div id="header">
			<t:insertAttribute name="header" />
		</div>
		<div id="topMenu">
			<t:insertAttribute name='topMenu' />
		</div>
		<div id="wrapper">
			<div class="content">
				<div id="centerColumn">
					<t:insertAttribute name='centerColumn' />
					<br>
				</div>
			</div>
			<div id="leftColumn">
				<t:insertAttribute name='leftColumn' />
			</div>
			<div id="rightColumn">
				<t:insertAttribute name='rightColumn' />
			</div>
		</div>
		<div id="footer">
			<t:insertAttribute name='footer' />
		</div>

	</div>
</body>
</html>

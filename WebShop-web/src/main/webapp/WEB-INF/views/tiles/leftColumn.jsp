<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>


<div id="search">
	<span>Поиск</span>
	<form action="/index" method="get" onsubmit="return CheckFind();">
		<input name="findtext" maxlength="20" alt="Поиск" type="text" class="find_txt">
		<button id="button_search" class="png"></button>
	</form>
	<a href="/index?findtext">Расширенный поиск</a>
</div>

<div id="leftColCont">
	<div id="leftCatalog">

	</div>
</div>

<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="servlet.*"%>
<table><tbody><tr id="topMenuRow">

<%String mode="";
if (request.getParameter("mode")!=null) mode=request.getParameter("mode");
%>

<td><a href="/index" class=main alt="Главная"
<%if (!request.getParameterNames().hasMoreElements()){%>id="active"<%}%> >Главная</a></td>

<td><a href="/index?basket" alt="Корзина" 
<%if (request.getParameter("basket")!=null){%>id="active"<%}%> >Корзина</a></td>

<td><a href="/index" alt="О магазине">О магазине</a></td>

<td><a href="/index?findtext" alt="Расширенный поиск"
<%if (request.getParameter("findtext")!=null){%>id="active"<%}%> >Расширенный поиск</a></td>

<td><a href="/index?delivery" class=delivery alt="Доставка и оплата"
<%if (request.getParameter("delivery")!=null){%>id="active"<%}%> >
Доставка и оплата</a></td>

</tr></tbody></table>

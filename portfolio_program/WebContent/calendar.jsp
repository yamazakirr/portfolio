<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/calendar.css">

<title>カレンダー画面</title>
</head>
<body>

<!-- ■ヘッダー -->
	<div id="header">
		<div id="page_title">
			マイカレンダー
		</div>
		<div id="select">
			<ul>
				<li><a href='<s:url action="AccountAction"/>'>アカウント情報</a></li>
				<li><a href='<s:url action="LogoutAction"/>'>ログアウト</a></li>
			</ul>
		</div>
	</div>

<!-- ■メイン -->
	<div id="main">
		<div id="year">
			<button id="lastYear">︎︎︎︎︎︎︎︎◀︎︎◀</button>
				<h2 id="year"></h2>
			<button id="nextYear">▶▶︎︎</button>
		</div>
		<div id="month">
			<button id="lastMonth">◀︎</button>
				<h2 id="month"></h2>
			<button id="nextMonth">▶︎</button>

		</div>
			<div id="calendar"></div>

	</div>

カレンダー画面<br>

<s:form action="AccountAction">
	<input type="text" id="test" value="ssss">
	<s:submit value="アカウント情報"/>

</s:form>


<script>
	let test = document.getElementById("test");
	test.setAttribute("name", "name");
</script>

<br>

メール：<s:property value="mail"/><br>
パスワード：<s:property value="password"/><br>

ユーザーID：<s:property value="#session.userId"/><br>
ユーザーネーム：<s:property value="#session.userName"/><br>

今日の日付
year :<s:property value="year"/><br>
month:<s:property value="month"/><br>
date :<s:property value="date"/><br>
dayOfWeek:<s:property value="dayOfWeek"/><br>
lastDate:<s:property value="lastDate"/><br>
startDate:<s:property value="startDate"/><br>

<input type="text" value="${dates[0][0] }"/>
<input type="text" value="${dates[1][6] }"/>
<input type="text" value="${dates[4][3] }"/>





<table>
	<tr>
		<th>日</th>
		<th>月</th>
		<th>火</th>
		<th>水</th>
		<th>木</th>
		<th>金</th>
		<th>土</th>
	</tr>

</table>


<script type="text/javascript" src="./javaScript/calendar.js"></script>
</body>
</html>
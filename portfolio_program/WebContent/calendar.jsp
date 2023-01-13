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
			<s:form action="CalendarAction" width="100">︎︎︎︎︎︎︎︎
				<s:submit value="◀︎︎◀"/>
				<input type="hidden" name="year" value="<s:property value='year'/>">
				<input type="hidden" name="month" value="<s:property value='month'/>">
				<input type="hidden" name="changeCalendarDate" value="lastYear"/>
			</s:form>

			<s:property value="year"/>

			<s:form action="CalendarAction">︎︎︎︎︎︎︎︎
				<s:submit value="▶▶︎"/>
				<input type="hidden" name="year" value="<s:property value='year'/>">
				<input type="hidden" name="month" value="<s:property value='month'/>">
				<input type="hidden" name="changeCalendarDate" value="nextYear"/>
			</s:form>
		</div>

		<div id="month">
			<s:form action="CalendarAction">︎︎︎︎︎︎︎︎
				<s:submit value="◀︎︎"/>
				<input type="hidden" name="year" value="<s:property value='year'/>">
				<input type="hidden" name="month" value="<s:property value='month'/>">
				<input type="hidden" name="changeCalendarDate" value="lastMonth"/>
			</s:form>

			<s:property value="month"/>

			<s:form action="CalendarAction">︎︎︎︎︎︎︎︎
				<s:submit value="▶︎"/>
				<input type="hidden" name="year" value="<s:property value='year'/>">
				<input type="hidden" name="month" value="<s:property value='month'/>">
				<input type="hidden" name="changeCalendarDate" value="nextMonth"/>
			</s:form>
		</div>
			<div id="calendar"></div>

	</div>

カレンダー画面<br>

<!-- カレンダーの表示 -->
<table border="1" id="calendar">
	<tr>
		<th>日</th>
		<th>月</th>
		<th>火</th>
		<th>水</th>
		<th>木</th>
		<th>金</th>
		<th>土</th>
	</tr>
	<tr>
		<s:iterator value="%{calendarLists}" var="item" status="key">
			<td>
				<!-- Action名はまだ未定 dateScheduleAction -->
				<a href='<s:url action="AccountAction"/>' id="">
					<s:property/>
				</a>
			</td>
			<s:if test="#key.count % 7 == 0">
				<tr></tr>
			</s:if>
		</s:iterator>
	</tr>
</table>





<s:property value="{dates[0][0] }"/><br>
<s:property value="%{dates[0][1] }"/><br>
<s:property value="%{dates[0][2] }"/><br>
<s:property value="%{dates[0][3] }"/><br>
<s:property value="{dates[0][4] }"/><br>



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
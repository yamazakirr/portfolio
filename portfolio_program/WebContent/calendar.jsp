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

			<table>
				<tr>
					<td>
						<s:form action="CalendarAction">︎︎︎︎︎︎︎︎
								<s:submit value="◀︎︎◀"/>
								<input type="hidden" name="year" value="<s:property value='year'/>">
								<input type="hidden" name="month" value="<s:property value='month'/>">
								<input type="hidden" name="changeCalendarDate" value="lastYear"/>
						</s:form>
					</td>
					<td>
						<s:property value="year"/>
					</td>
					<td>
						<s:form action="CalendarAction">︎︎︎︎︎︎︎︎
							<s:submit value="▶▶︎"/>
							<input type="hidden" name="year" value="<s:property value='year'/>">
							<input type="hidden" name="month" value="<s:property value='month'/>">
							<input type="hidden" name="changeCalendarDate" value="nextYear"/>
						</s:form>
					</td>
				</tr>
			</table>
		</div>

		<div id="month">
			<table>
				<tr>
					<td>
						<s:form action="CalendarAction">︎︎︎︎︎︎︎︎
							<s:submit value="◀︎︎"/>
							<input type="hidden" name="year" value="<s:property value='year'/>">
							<input type="hidden" name="month" value="<s:property value='month'/>">
							<input type="hidden" name="changeCalendarDate" value="lastMonth"/>
						</s:form>
					</td>
					<td>
						<s:property value="month"/>
					</td>
					<td>
						<s:form action="CalendarAction">︎︎︎︎︎︎︎︎
							<s:submit value="▶︎"/>
							<input type="hidden" name="year" value="<s:property value='year'/>">
							<input type="hidden" name="month" value="<s:property value='month'/>">
							<input type="hidden" name="changeCalendarDate" value="nextMonth"/>
						</s:form>
					</td>
				</tr>
			</table>
		</div>
			<div id="calendar"></div>

	</div>



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

				<a href='<s:url action="AccountAction"/>' id="calendar">
					<s:property/>
				</a>

				<s:form action="AccountAction">

					<s:submit name="date" value="<s:property/>"/><br>
					<input type="hidden" name="year" value="<s:property value='year'/>">
					<input type="hidden" name="month" value="<s:property value='month'/>">
<!--
					<s:submit name="date" value="%{calendarLists}"/><br>
-->
				</s:form>


<!--
				<s:url id="url" action="AccountAction">
					<s:param name="year">1</s:param>
				</s:url>
-->
<!--  					<s:param name="date" value="1"></s:param>
					<s:textfield name="date" value="%{calendarLists}"/>
-->





<%--
				<s:form action="AccountAction">

					<s:submit value="<s:property/>"/>
					<input type="hidden" name="year" value="<s:property value='year'/>">
					<input type="hidden" name="month" value="<s:property value='month'/>">

				</s:form>
 --%>


			</td>
			<s:if test="#key.count % 7 == 0">
				<tr></tr>
			</s:if>
		</s:iterator>
	</tr>
</table>

<br>



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


<script type="text/javascript" src="./javaScript/calendar.js"></script>
</body>
</html>
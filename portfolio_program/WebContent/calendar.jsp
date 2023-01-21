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
								<input type="hidden" name="date" value="<s:property value='date'/>">
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
							<input type="hidden" name="date" value="<s:property value='date'/>">
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
							<input type="hidden" name="date" value="<s:property value='date'/>">
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
							<input type="hidden" name="date" value="<s:property value='date'/>">
							<input type="hidden" name="changeCalendarDate" value="nextMonth"/>
						</s:form>
					</td>
				</tr>
			</table>
		</div>
			<div id="calendar"></div>

	</div>

値の合計 :<s:property value="date + #session.firstDayOfWeek -1"/>

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

			<!-- 現在選択されている日付 -->
			<s:if test="#key.count == date + #session.firstDayOfWeek -1">
				<td id="selectDate">
					<s:if test="#key.count >= #session.firstDayOfWeek ">
						<s:form action="ScheduleGetAction" >
							<input type="hidden" value="<s:property value='year'/>" name="year">
							<input type="hidden" value="<s:property value='month'/>" name="month">

							<input type="hidden" value="<s:property value='#session.userId'/>" name="userId">
							<input type="hidden" value="<s:property value='#session.userName'/>" name="userName">

							<input type="submit" value="<s:property/>" name="date">
						</s:form>
					</s:if>
				</td>

				<script>
					let selectDate = document.getElementById("selectDate");
					selectDate.style.backgroundColor = "red";
				</script>
			</s:if>

			<!-- 現在選択されている以外の日付 -->
			<s:if test="#key.count != date + #session.firstDayOfWeek -1">
				<td>
					<s:if test="#key.count >= #session.firstDayOfWeek ">
						<s:form action="ScheduleGetAction" >
							<input type="hidden" value="<s:property value='year'/>" name="year">
							<input type="hidden" value="<s:property value='month'/>" name="month">

							<input type="hidden" value="<s:property value='#session.userId'/>" name="userId">
							<input type="hidden" value="<s:property value='#session.userName'/>" name="userName">

							<input type="submit" value="<s:property/>" name="date">
						</s:form>
					</s:if>
				</td>
			</s:if>


			<s:if test="#key.count % 7 == 0">
				<tr></tr>
			</s:if>
		</s:iterator>
	</tr>
</table>

<br><br>

<s:property value="year"/>年 <s:property value="month"/>月 <s:property value="date" />日

<table>
	<s:iterator value="scheduleListDTO">
		<tr>
			<td>
				<s:if test="allDayFlg == 0">
					<s:property value="startTime"/>
					-
					<s:property value="endTime"/>
				</s:if>
				<s:elseif test="allDayFlg == 1">
					終日
				</s:elseif>
			</td>
			<td>
				<s:property value="schedule"/>
			</td>
			<td>
				<s:form action="ScheduleConfirmAction">
					<input type="hidden" name="userId" value="<s:property value='#session.userId'/>">
					<input type="hidden" name="id" value="<s:property value='id'/>">
					<input type="hidden" name="schedule" value="<s:property value='schedule'/>">
					<input type="hidden" name="memo" value="<s:property value='memo'/>">
					<input type="hidden" name="startDate" value="<s:property value='startDate'/>">
					<input type="hidden" name="endDate" value="<s:property value='endDate'/>">
					<input type="hidden" name="allDayFlg" value="<s:property value='allDayFlg'/>">
					<input type="hidden" name="startTime" value="<s:property value='startTime'/>">
					<input type="hidden" name="endTime" value="<s:property value='endTime'/>">

					<input type="hidden" name="year" value="<s:property value='year'/>">
					<input type="hidden" name="month" value="<s:property value='month'/>">
					<input type="hidden" name="date" value="<s:property value='date'/>">

					<input type="hidden" value="<s:property value='#session.userId'/>" name="userId">
					<input type="hidden" value="<s:property value='#session.userName'/>" name="userName">

					<input type="submit" value="確認"/>
				</s:form>

			</td>
			<td>
				<s:form action="ScheduleDeleteAction">
					<input type="hidden" name="userId" value="<s:property value='#session.userId'/>">
					<input type="hidden" name="id" value="<s:property value='id'/>">
					<input type="hidden" name="schedule" value="<s:property value='schedule'/>">
					<input type="hidden" name="memo" value="<s:property value='memo'/>">
					<input type="hidden" name="startDate" value="<s:property value='startDate'/>">
					<input type="hidden" name="endDate" value="<s:property value='endDate'/>">
					<input type="hidden" name="allDayFlg" value="<s:property value='allDayFlg'/>">
					<input type="hidden" name="startTime" value="<s:property value='startTime'/>">
					<input type="hidden" name="endTime" value="<s:property value='endTime'/>">

					<input type="hidden" name="year" value="<s:property value='year'/>">
					<input type="hidden" name="month" value="<s:property value='month'/>">
					<input type="hidden" name="date" value="<s:property value='date'/>">

					<input type="hidden" value="<s:property value='#session.userId'/>" name="userId">
					<input type="hidden" value="<s:property value='#session.userName'/>" name="userName">

					<input type="submit" value="削除"/>
				</s:form>
			</td>
		</tr>
	</s:iterator>

</table>



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
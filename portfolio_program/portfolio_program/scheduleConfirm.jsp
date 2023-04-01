<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/scheduleConfirm.css">

<title>スケジュール確認画面</title>
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
				<li><a href='<s:url action="CalendarAction"/>'>カレンダー</a></li>
				<li><a href='<s:url action="LogoutAction"/>'>ログアウト</a></li>
			</ul>
		</div>
	</div>

	<!-- ■メイン -->
	<div id="main">

		<div id="main_button" align="center">
			<table>
				<tr>
					<td>
						<s:form action="ScheduleDeleteAction">
							<input type="hidden" name="id" value="<s:property value='id'/>">
							<input type="hidden" value="<s:property value='#session.userId'/>" name="userId">
							<input type="hidden" value="<s:property value='#session.userName'/>" name="userName">

							<input type="submit" class="button" value="削除">
						</s:form>
					</td>
					<td>
						<s:form action="CalendarAction">
							<input type="hidden" name="year" value="<s:property value='year'/>">
							<input type="hidden" name="month" value="<s:property value='month'/>">
							<input type="hidden" name="date" value="<s:property value='date'/>">

							<input type="hidden" name="userId" value="<s:property value='#session.userId'/>">
							<input type="hidden" name="userName" value="<s:property value='#session.userName'/>" >

							<input type="submit" class="button" value="カレンダーに戻る">
						</s:form>
					</td>
					<td>
						<s:form action="ScheduleEditAction">
							<input type="hidden" name="id" value="<s:property value='id'/>">
							<input type="hidden" name="schedule" value="<s:property value='schedule'/>">
							<input type="hidden" name="memo" value="<s:property value='memo'/>">
							<input type="hidden" name="startDate" value="<s:property value='startDate'/>">
							<input type="hidden" name="startYear" value="<s:property value='startYear'/>">
							<input type="hidden" name="startMonth" value="<s:property value='startMonth'/>">
							<input type="hidden" name="startDay" value="<s:property value='startDay'/>">

							<input type="hidden" name="endDate" value="<s:property value='endDate'/>">
							<input type="hidden" name="endYear" value="<s:property value='endYear'/>">
							<input type="hidden" name="endMonth" value="<s:property value='endMonth'/>">
							<input type="hidden" name="endDay" value="<s:property value='endDay'/>">
							<input type="hidden" name="allDayFlg" value="<s:property value='allDayFlg'/>">
							<input type="hidden" name="startTime" value="<s:property value='startTime'/>">
							<input type="hidden" name="endTime" value="<s:property value='endTime'/>">

							<input type="hidden" name="year" value="<s:property value='year'/>">
							<input type="hidden" name="month" value="<s:property value='month'/>">
							<input type="hidden" name="date" value="<s:property value='date'/>">

							<input type="hidden" value="<s:property value='#session.userId'/>" name="userId">
							<input type="hidden" value="<s:property value='#session.userName'/>" name="userName">

							<input type="submit" class="button" value="編集"/>
						</s:form>
					</td>
				</tr>
			</table>

		</div>

		<div id="main_schedule" align="center">
			<table id="table_schedule" border="1">

					<!-- 日付表示 -->
					<tr>
						<td><s:property value="startDate"/></td>
						<td rowspan="2">〜</td>
						<td><s:property value="endDate"/></td>
					</tr>
					<!-- 時刻表示 -->
					<tr>
						<s:if test="allDayFlg == 1">
							<td>終日</td>
							<td>終日</td>
						</s:if>
						<s:elseif test="allDayFlg == 0">
							<td><s:property value="startTime"/></td>
							<td><s:property value="endTime"/></td>
						</s:elseif>
					</tr>
					<!-- スケジュール表示 -->
					<tr>
						<td colspan="3"><b>タイトル</b></td>
					</tr>
					<tr>
						<td colspan="3"><s:property value="schedule"/></td>
					</tr>
					<!-- メモの表示 -->
					<tr>
						<td colspan="3"><b>メモ</b></td>
					</tr>
					<tr>
						<td colspan="3"><s:property value="memo"/></td>
					</tr>

			</table>
		</div>

	</div>

</body>
</html>
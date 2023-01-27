<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/scheduleEdit.css">

<title>予定編集画面</title>
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
						<s:form action="scheduleConfirmAction">
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

							<input type="submit" class="button" value="キャンセル">
						</s:form>
					</td>
					<td>
						予定欄が空白であればエラー表示
					</td>
					<td>
						<s:form action="ScheduleEditCompleteAction">
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

							<input type="submit" class="button" value="保存"/>
						</s:form>
					</td>
				</tr>
			</table>

		</div>
	</div>

	<div id="main_schedule" align="center">
			<table id="table_schedule" border="1">

					<!-- 日付表示 -->
					<tr>
						<td>
							<select name="startYear" id="startYear">
								<script>
									var startYear = <s:property value="startYear"/>
									year = startYear - 5;

									for(let i = 0; i <= 11; i++){
										if(year == startYear){
											document.write("<option selected>");
										}else{
											document.write("<option>");
										}
										document.write(year);
										document.write("</oprion>");
										year++;
									}
								</script>
							</select>
							-
							<select name="startMonth" id="startMonth">
								<script>
									var startMonth = <s:property value="startMonth"/>

									for(let month = 1; month <= 12; month++){
										if(month == startMonth){
											document.write("<option selected>");
										}else{
											document.write("<option>");
										}
										document.write(month);
										document.write("</option>");
									}
								</script>
							</select>
							-
							<select name="startDay" id="startDay">
								<script>
									let startDay = <s:property value="startDay"/>
									let selectDate = new Date(startYear, startMonth, 0);
									let lastDate = selectDate.getDate();

									/* 初期表示 */
									for(let i = 1; i <= lastDate; i++){
										if(i == startDay){
											document.write("<option selected>");
										}else{
											document.write("<option>");
										}
										document.write(i);
										document.write("</option>");
									}

									/* 年、月変更時の表示 */


								</script>
							</select>

						</td>
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


<br>
====動作確認用====<br>
年：<s:property value="year"/><br>
月：<s:property value="month"/><br>
日：<s:property value="date"/><br>

予定開始日　年：<s:property value="startYear"/><br>
予定開始日　月：<s:property value="startMonth"/><br>
予定開始日　日：<s:property value="startDay"/><br>

予定終了日　年：<s:property value="endYear"/><br>
予定終了日　月：<s:property value="endMonth"/><br>
予定終了日　日：<s:property value="endDay"/><br>

================

</body>
</html>
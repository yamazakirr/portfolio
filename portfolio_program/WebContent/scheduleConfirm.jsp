<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

		<div id="button">
			<s:form action="ScheduleDeleteAction">
				<input type="submit" value="削除">
			</s:form>

			<s:form action="CalendarAction">
				<input type="submit" value="カレンダーに戻る">
			</s:form>

			<s:form action="ScheduleEditAction">
				<input type="submit" value="編集"/>
			</s:form>

		</div>

		<div id="schedule">
			<table border="1">
				<!-- 日付表示 -->
				<tr>
					<td><s:property value="startDate"/></td>
					<td>〜</td>
					<td><s:property value="endDate"/></td>
				</tr>
				<!-- 時刻表示 -->
				<tr>
					<s:if test="allDayFlg == 1">
						<td>終日</td>
						<td>〜</td>
						<td>終日</td>
					</s:if>
					<s:elseif test="allDayFlg == 0">
						<td><s:property value="startTime"/></td>
						<td>〜</td>
						<td><s:property value="endTime"/></td>
					</s:elseif>
				</tr>
				<!-- スケジュール表示 -->
				<tr>
					<td><b>タイトル</b></td>
				</tr>
				<tr>
					<td><s:property value="schedule"/></td>
				</tr>
				<!-- メモの表示 -->
				<tr>
					<td><b>メモ</b></td>
				</tr>
				<tr>
					<td><s:property value="memo"/></td>
				</tr>


			</table>
		</div>

	</div>

</body>
</html>
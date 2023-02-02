<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/scheduleEditComplete.css">

<title>予定編集完了画面</title>
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
		<div id="box">
			<div id="main_title">
				<p>予定編集完了画面</p>
			</div>
			<div id="input">
				<p>変更が完了しました</p>
			</div>
			<div id="btn">
				<s:form action="CalendarAction">
					<input type="hidden" name="year" value="<s:property value='year'/>">
					<input type="hidden" name="month" value="<s:property value='month'/>">
					<input type="hidden" name="date" value="<s:property value='date'/>">

					<input type="hidden" value="<s:property value='#session.userId'/>" name="userId">
					<input type="hidden" value="<s:property value='#session.userName'/>" name="userName">

					<s:submit class="btn" value="カレンダー画面に戻る"/>
				</s:form>
			</div>
		</div>

	</div>

====動作確認用====<br>
年：<s:property value="year"/><br>
月：<s:property value="month"/><br>
日：<s:property value="date"/><br>


予定開始日　年：<s:property value="startYear"/><br>
予定開始日　月：<s:property value="startMonth"/><br>
予定開始日　日：<s:property value="startDay"/><br>
予定開始時間　：<s:property value="startTime"/><br>
予定開始時間　時：<s:property value="startHour"/><br>
予定開始時間　分：<s:property value="startMinutes"/><br>
終日フラグ　：<s:property value="allDayFlg"/><br><br>

予定終了日　年：<s:property value="endYear"/><br>
予定終了日　月：<s:property value="endMonth"/><br>
予定終了日　日：<s:property value="endDay"/><br>
予定終了時間　：<s:property value="endTime"/><br>
予定終了時間　時：<s:property value="endHour"/><br>
予定終了時間　分：<s:property value="endMinutes"/><br>

================


</body>
</html>
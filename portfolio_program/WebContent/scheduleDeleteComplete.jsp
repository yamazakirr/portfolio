<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/scheduleDeleteComplete.css">

<title>予定削除完了画面</title>
</head>
<body>

!-- ■ヘッダー -->
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
				<p>予定削除更完了画面</p>
			</div>
			<div id="input">
				<p>予定の削除が完了しました</p>
			</div>
			<div id="btn">
				<s:form action="CalendarAction">
					<input type="hidden" name="year" value="<s:property value='year'/>">
					<input type="hidden" name="month" value="<s:property value='month'/>">
					<input type="hidden" name="date" value="<s:property value='date'/>">

					<input type="hidden" value="<s:property value='#session.userId'/>" name="userId">
					<input type="hidden" value="<s:property value='#session.userName'/>" name="userName">

					<input type="submit" class="btn" value="カレンダー画面に戻る">
				</s:form>
			</div>
		</div>

	</div>

</body>
</html>
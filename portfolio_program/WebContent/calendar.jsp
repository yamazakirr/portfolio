<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylsheet" type="text/css" href="./css/calendar.css">


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
				<li>アカウント情報</li>
				<li><a href='<s:url action="LogoutAction"/>'>ログアウト</a></li>
			</ul>
		</div>
	</div>

<!-- ■メイン -->
	<div id="main">
		<div id="box">
		</div>

	</div>

カレンダー画面<br>

メール：<s:property value="mail"/><br>
パスワード：<s:property value="password"/><br>

ユーザーID：<s:property value="#session.userId"/><br>
ユーザーネーム：<s:property value="#session.userName"/><br>



</body>
</html>
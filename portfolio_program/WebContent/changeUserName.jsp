<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/changeUserName.css">

<title>ニックネーム変更画面</title>
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
				<p>ニックネーム変更画面</p>
			</div>
			<div id="input">
				<p>新しいニックネーム</p>
				<input type="text" size="40" name="userName" class="input_box"><br>

				<p>パスワード</p>
				<input type="password" size="40" name="password" class="input_box">
			</div>
			<div id="btn">
				<table>
					<tr>
						<td>
							<s:form action= "AccountAction">
								<s:submit class="btn" value="キャンセル"/>
							</s:form>
						</td>
						<td>
							<s:form action= "ChangeUserNameCompleteAction">
								<s:submit class="btn" value="保存"/>
							</s:form>
						</td>
					</tr>
				</table>
			</div>

		</div>
	</div>


</body>
</html>
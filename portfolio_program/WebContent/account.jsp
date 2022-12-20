<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/account.css">

<title>アカウント画面</title>
</head>
<body>


<!-- ■ヘッダー -->
	<div id="header">
		<div id="page_title">
			マイカレンダー
		</div>
		<div id="select">
			<ul>
				<li><a href='<s:url action="CalendarAction"/>'>カレンダー</a></li>
				<li><a href='<s:url action="LogoutAction"/>'>ログアウト</a></li>
			</ul>
		</div>
	</div>

<!-- ■メイン -->
	<div id="main">
		<div id="box">
			<div id="main_title">
				<p>アカウント画面</p>
			</div>
			<div id="input">
				<table>
					<tr>
						<td>ニックネーム</td>
						<td><s:property value="userName"/></td>
						<td>
							<s:form action="ChangeUserNameAction">
								<s:submit value="ニックネーム変更"/>
							</s:form>
						</td>
					</tr>
					<tr>
						<td>メールアドレス</td>
						<td><s:property value="mail"/></td>
						<td>
							<s:form action="ChangeMailAction">
								<s:submit value="メールアドレス変更"/>
							</s:form>
						</td>
					</tr>
					<tr>
						<td>パスワード</td>
						<td>設定済み</td>
						<td>
							<s:form action="ChangePasswordAction">
								<s:submit value="パスワード変更"/>
							</s:form>
						</td>
					</tr>
				</table>
			</div>

			<div id="btn">
				<table>
					<tr>
						<td>
							<s:form action="calendar.jsp">
								<s:submit value="カレンダー画面に戻る"/>
							</s:form>
						</td>
						<td>
							<s:form action="DeleteAccountAction">
								<s:submit value="アカウントの削除"/>
							</s:form>
						</td>
					</tr>
				</table>

			</div>

		</div>

	</div>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アカウント登録画面</title>
</head>
<body>

<!-- ■ヘッダー -->
	<div id="header">
		<div id="page_title">
			マイカレンダー
		</div>
	</div>

	<!-- ■メイン -->
	<div id="main">
		<div id="box">
		<s:form action="RegistConfirmAction">
			<div id="main_title">
				<p>ログイン</p>
			</div>
			<div id="input">
				<table>
					<tr>
						<td>ニックネーム</td>
						<td><input type="text" size="40" name="user_name"></td>
					</tr>
					<tr>
						<td>メールアドレス</td>
						<td><input type="text" size="40" name="mail"></td>
					</tr>
					<tr>
						<td>パスワード</td>
						<td><input type="text" size="40" name="password"></td>
					</tr>
				</table>
			</div>
			<div id="btn">
				<s:submit value="確認する"/>
			</div>
		</s:form>

		</div>
	</div>

</body>
</html>
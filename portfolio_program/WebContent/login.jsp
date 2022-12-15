<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="./css/login.css"/>

<title>ログイン画面</title>
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
			<div id="main_title">
				<p>ログイン</p>
			</div>
			<div id="input">
				<p>メールアドレス</p>
				<input type="text" size="40" name="mailCopy" id="mailInput" value='<s:property value="mailCopy"/>'>

				<p>パスワード</p>
				<input type="password" size="40" name="passwordCopy" id="passwordInput">

				<div class="errorMessage">
					<s:if test="loginErrorMessage != null">
						<s:property value="loginErrorMessage"/>
					</s:if>
				</div>
			</div>


			<div id="btn">
				<table>
					<tr>
					<td>
						<s:form action="RegistAccountAction" class="btn_pattern1">
							<s:submit class="btn" value="アカウント登録はこちら"/>
						</s:form>
					</td>
					<td>
						<s:form action="LoginAction" class="btn_pattern1">
							<s:submit class="btn" value="ログイン"/>
							<input type="hidden" name="mail" id="mailOutput"/>
							<input type="hidden" name="password" id="passwordOutput"/>

							<script>
								window.onload = function(){
									document.getElementById('mailInput').onkeyup = function(){
										copyMailValue();
									};
									document.getElementById('passwordInput').onkeyup = function(){
										copyPasswordValue();
									}
								}
								function copyMailValue(){
									let mailInput = document.getElementById('mailInput').value;
									document.getElementById('mailOutput').value = mailInput;
								}
								function copyPasswordValue(){
									let passwordInput = document.getElementById('passwordInput').value;
									document.getElementById('passwordOutput').value = passwordInput;
								}

							</script>
						</s:form>
					</td>
					</tr>
				</table>
			</div>

		</div>
	</div>



</body>
</html>
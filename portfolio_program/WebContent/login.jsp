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

			<table id="input">
				<tr>
					<td><p>メールアドレス</p></td>
				</tr>
				<tr>
					<td><input type="text" size="40" name="mailCopy" id="mailInput" value='<s:property value="mail"/>'></td>
				</tr>
				<tr>
					<td><p>パスワード</p></td>
				</tr>
				<tr>
					<td><input type="password" size="40" name="passwordCopy" id="passwordInput" value='<s:property value="password"/>'></td>
				</tr>
				<tr>
					<td>
						<div class="errorMessage">
							<s:if test="loginErrorMessage != null">
								<s:property value="loginErrorMessage"/>
							</s:if>
						</div>
					</td>
				</tr>

			</table>


			<div id="btn">
				<table>
					<tr>
					<td>
						<s:form action="RegistAccountAction" class="btn_pattern1">
							<s:submit class="btn" value="アカウント登録はこちら"/>
						</s:form>
					</td>
					<td id="test">
						<s:form action="LoginAction" class="btn_pattern1">
							<s:submit class="btn" value="ログイン"/>
							<input type="hidden" name="mail" id="mailOutput" value='<s:property value="mail"/>'>
							<input type="hidden" name="password" id="passwordOutput" value='<s:property value="password"/>'>

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
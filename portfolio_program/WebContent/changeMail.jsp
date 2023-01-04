<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/changeMail.css">

<title>メールアドレス変更画面</title>
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
				<p>メールアドレス変更画面</p>
			</div>
			<div id="input">
				<p>新しいメールアドレス</p>
				<input type="text" size="40" class="input_box" id="changeMailInput" value="<s:property value='changeMail'/>">
				<p><s:property value="changeMailErrorMessage"/></p>

				<p>パスワード</p>
				<input type="password" size="40" class="input_box" id="passwordInput" value="<s:property value='password'/>"><br>
				<s:property value="passwordErrorMessage"/>
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
							<s:form action= "ChangeMailCompleteAction">
								<s:submit class="btn" value="保存"/>
								<input type="hidden" name="changeMail" id="changeMailOutput" value="<s:property value='changeMail'/>">
								<input type="hidden" name="password" id="passwordOutput" value="<s:property value='password'/>">

								<script>
									window.onload  = function(){
										document.getElementById('changeMailInput').onkeyup = function(){
											copyChangeMail();
										};
										document.getElementById('passwordInput').onkeyup = function(){
											copyPassword();
										}
									}
										function copyChangeMail(){
											let changeMailInput = document.getElementById('changeMailInput').value;
											document.getElementById('changeMailOutput').value = changeMailInput;
										}
										function copyPassword(){
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
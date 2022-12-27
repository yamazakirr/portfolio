<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>パスワード変更画面</title>
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
				<p>パスワード変更画面</p>
			</div>
			<div id="input">
				<p>新しいパスワード</p>
				<input type="password" size="40" class="input_box" id="changePasswordInput" value="<s:property value='changePassword'/>">
				<button id="btn_passview">表示</button><br>
				<s:property value="changePasswordErrorMessage"/>

				<!-- パスワードの表示・非表示切り替え処理 -->
				<script>
					window.addEventListener('DOMContentLoaded', function(){
						let btn_passview = document.getElementById("btn_passview");
						let changePasswordInput = document.getElementById("changePasswordInput");

						btn_passview.addEventListener("click", (e)=>{
							e.preventDefault();

							if(changePasswordInput.type === 'password'){
								changePasswordInput.type = 'text';
								btn_passview.textContent = '非表示';
							}else{
								changePasswordInput.type = 'password';
								btn_passview.textContent = '表示';
							}
						});
					});
				</script>

				<p>現在のパスワード</p>
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
							<s:form action= "ChangePasswordCompleteAction">
								<s:submit class="btn" value="保存"/>
								<input type="hidden" name="changePassword" id="changePasswordOutput">
								<input type="hidden" name="password" id="passwordOutput">

								<script>
									window.onload  = function(){
										document.getElementById('changePasswordInput').onkeyup = function(){
											copyChangePassword();
										};
										document.getElementById('passwordInput').onkeyup = function(){
											copyPassword();
										}
									}
										function copyChangePassword(){
											let changePasswordInput = document.getElementById('changePasswordInput').value;
											document.getElementById('changePasswordOutput').value = changePasswordInput;
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
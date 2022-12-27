<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/registAccount.css"/>

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
		<s:form action="RegistAccountConfirmAction">
			<div id="main_title">
				<p>アカウント登録画面</p>
			</div>
			<div id="input">
				<table>
					<tr>
						<td>ニックネーム</td>
						<td>
							<input type="text" size="40" name="userName" value="<s:property value='userName'/>">
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<div class="errorMessage">
								<s:if test="userNameErrorMessage != null">
									<s:property value="userNameErrorMessage"/>
								</s:if>
							</div>
						</td>
					</tr>

					<tr>
						<td>メールアドレス</td>
						<td>
							<input type="text" size="40" name="mail" value="<s:property value='mail'/>"><br>

						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<div class="errorMessage">
								<s:if test="mailErrorMessage != null">
									<s:property value="mailErrorMessage"/>
								</s:if>
							</div>
						</td>
					</tr>

					<tr>
						<td>パスワード</td>
						<td>
							<input type="password" id="input_pass" size="40" name="password" value="<s:property value='password'/>">
							<button id="btn_passview">表示</button>

							<!-- パスワードの表示・非表示切り替え処理 -->
							<script>
								window.addEventListener('DOMContentLoaded', function(){
									let btn_passview = document.getElementById("btn_passview");
									let input_pass = document.getElementById("input_pass");

									btn_passview.addEventListener("click", (e)=>{
										e.preventDefault();

										if(input_pass.type === 'password'){
											input_pass.type = 'text';
											btn_passview.textContent = '非表示';
										}else{
											input_pass.type = 'password';
											btn_passview.textContent = '表示';
										}
									});
								});
							</script>


						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<div class="errorMessage">
								<s:if test="passwordErrorMessage != null">
									<s:property value="passwordErrorMessage"/>
								</s:if>
							</div>
						</td>
					</tr>

				</table>
			</div>
			<div id="btn">
				<s:submit class="btn" value="確認する"/>
			</div>
		</s:form>

		</div>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アカウント登録確認画面</title>
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
				<p>アカウント登録確認画面</p>
			</div>
			<div id="input">
				<table>
					<tr>
						<td>ニックネーム</td>
						<td>
							<s:property value='userName'/>
						</td>
					</tr>

					<tr>
						<td>メールアドレス</td>
						<td>
							<s:property value='mail'/>
						</td>
					</tr>

					<tr>
						<td>パスワード</td>
						<td>
							<s:property value='passwordText'/>
						</td>
					</tr>

				</table>
			</div>

			<div id="btn">
				<table>
					<tr>
					<td>
						<s:form action="RegistAccountCompleteAction">
							<div class="btn_pattern1">
								<s:submit class="btn" value="登録する"/>
								<input type="hidden" name="userName" value="<s:property value='userName'/>"/>
								<input type="hidden" name="mail" value="<s:property value='mail'/>"/>
								<input type="hidden" name="password" value="<s:property value='password'/>"/>
							</div>
						</s:form>
					</td>
					<td>

						<s:form action="RegistAccountAction" class="btn_pattern1">
							<s:submit class="btn" value="前に戻る"/>
							<input type="hidden" name="userName" value="<s:property value='userName'/>"/>
							<input type="hidden" name="mail" value="<s:property value='mail'/>"/>
							<input type="hidden" name="password" value="<s:property value='password'/>"/>
						</s:form>
					</td>
					</tr>

				</table>
			</div>
		</div>
	</div>



</body>
</html>
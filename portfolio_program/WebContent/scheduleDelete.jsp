<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/deleteScheduleConfirm.css">

<title>スケジュール削除画面</title>
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
				<p>アカウント削除確認画面</p>
			</div>
			<div id="input">
				<p>本当に削除しますか？</p>
			</div>
			<div id="btn">
				<table>
					<tr>
						<td>
							<s:form action="CalendarAction">
								<s:submit class="btn" value="キャンセル"/>
							</s:form>
						</td>
						<td>
							<s:form action="DeleteScheduleCompleteAction">
								<s:submit class="btn" value="削除"/>
							</s:form>
						</td>
					</tr>
				</table>
			</div>
		</div>

	</div>


	</div>

</body>
</html>
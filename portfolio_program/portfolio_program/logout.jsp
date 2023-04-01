<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/logout.css">

<title>ログアウト画面</title>
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
			<div id="input">
				<p>ログアウトが完了しました。</p>
			</div>
			<div id="btn">
				<s:form action="login.jsp">
					<s:submit class="btn" value="ログイン画面に戻る"/>
				</s:form>
			</div>
		</div>
	</div>

</body>
</html>
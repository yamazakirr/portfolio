<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>予定追加画面</title>
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
		<div id="button">
			<s:form action="CalendarAction">
				<input type="hidden" value="<s:property value='year'/>" name="year">
				<input type="hidden" value="<s:property value='month'/>" name="month">
				<input type="hidden" value="<s:property value='date'/>" name="date">
				<input type="hidden" value="<s:property value='#session.userId'/>" name="userId">
				<input type="hidden" value="<s:property value='#session.userName'/>" name="userName">

				<s:submit value="キャンセル"/>
			</s:form>


			<!-- 予定欄が空白時はエラーメッセージを表示するを追加する -->

			<s:form action="CalendarAddCompleteAction">
				<input type="hidden" value="<s:property value='year'/>" name="year">
				<input type="hidden" value="<s:property value='month'/>" name="month">
				<input type="hidden" value="<s:property value='date'/>" name="date">
				<input type="hidden" value="<s:property value='#session.userId'/>" name="userId">
				<input type="hidden" value="<s:property value='#session.userName'/>" name="userName">

				<input type="submit" value="追加" id="scheduleAddButton">

				<!-- ボタン押下後1.5秒間ボタンを非活性にする処理 -->
				<script>
					var scheduleAddButton = document.getElementById("scheduleAddButton");
					scheduleAddButton.addEventListener("click", function(){
						scheduleAddButton.disabled = true;

						window.setTimeout(function(){
							scheduleAddButton.disabled = false;
						}, 1500);
					});
				</script>

			</s:form>
		</div>

		<div id="schedule">
			<table>
				<tr>
					<td>
						<select name="year" id="selectYear">
							<script>
								let today = new Date();
								let year = "<s:property value='year'/>"

								/* 現在の年から前後15年の合計31年分の年を取得する */
								/* 繰り返し処理にて値を追加する */
								let yearAll = [""];
								year = year - 15;

								for(i =0 ; i <= 31; i++){
									yearAll.push(year);
									year++;
								}

								for(let i = 0; i < 31; i++){
									if(yearAll[i] == year){
										document.write("<option selected>");
									}else{
										document.write("<option>");
									}
									document.write(yearAll[i]);
									document.write("</option>");
								}

								console.log("yearAll : "+yearAll);
								console.log("year : "+year);
							</script>
						</select>

						<select name="month" id="selectMonth">
							<script>
								let monthAll = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"]
								let month = "<s:property value='month'/>";

								for(var i = 0; i < monthAll.length; i++){
									if(monthAll[i] == month){
										document.write("<option selected>");
									}else{
										document.write("<option>");
									}
									document.write(monthAll[i]);
									document.write("</option>");
								}
								console.log("monthAll : "+monthAll);
								console.log("month : "+month);
							</script>
						</select>

						<select name="date" id="selectDate">
							<script>
								let dateAll = "<s:property value='%{calendarLists}'/>"
								let dateAll2 = "<s:property value='calendarLists'/>"
								var date = "<s:property value='date'/>"

								for(let i = 0; i < dateAll.length; i++){
									if(dateAll[i] == date){
										document.write("<option selected>");
									}else{
										document.write("<option>");
									}
									document.write(dateAll[i]);
									document.write("</option>");
								}

								console.log("dateAll : "+dateAll);
								console.log("dateAll2 : "+dateAll2);
								console.log("date : "+date);
							</script>


						</select>
					</td>
					<td></td>
					<td></td>
				</tr>

				<!-- 時刻の表示 -->
				<tr>


				</tr>

				<!-- 予定の内容の表示 -->
				<tr></tr>

				<!-- メモの内容の表示 -->
				<tr></tr>


			</table>


		</div>




	</div>

予定追加画面

year :<s:property value="year"/>
month :<s:property value="month"/>
date : <s:property value="date"/>

userId :<s:property value="#session.userId"/>
userName :<s:property value="#session.userName"/>

</body>
</html>
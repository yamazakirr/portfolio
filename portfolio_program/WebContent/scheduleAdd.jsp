<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/scheduleAdd.css">

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



		<div id="schedule">
			<table>
				<tr>
					<td>
						<select name="startYear" id="startYear">
							<script>
								var startYear = <s:property value="startYear"/>
								let startYearAll = startYear - 5;
								var startYearElement = document.querySelector("[name='startYear']");

								for(let i = 0; i <= 11; i++){
									if(startYearAll == startYear){
										document.write("<option selected>");
									}else{
										document.write("<option>");
									}
									document.write(startYearAll);
									document.write("</oprion>");
									startYearAll++;
								}
							</script>
						</select>
						-
						<select name="startMonth" id="startMonth">
							<script>
								var startMonth = <s:property value="startMonth"/>
								var startMonthElement = document.querySelector("[name='startMonth']");

								for(let month = 1; month <= 12; month++){
									if(month == startMonth){
										document.write("<option selected>");
									}else{
										document.write("<option>");
									}
									document.write(month);
									document.write("</option>");
								}
							</script>
						</select>
						-
						<select name="startDay" id="startDay">
							<script>
								let startDay = <s:property value="startDay"/>

								var selectDate = new Date(startYear, startMonth, 1);
								selectDate.setDate(selectDate.getDate() -1);
								var lastDate = selectDate.getDate();

								/* 初期表示 ページ読み込み時に実行 */
								for(let i = 1; i <= lastDate; i++){
									if(i == startDay){
										document.write("<option selected>");
									}else{
										document.write("<option>");
									}
									document.write(i);
									document.write("</option>");
								}

								/* プルダウンにて年、月を変更した場合に日付変更処理を実行 */
								startMonthElement.onchange = event => {
									dateChange();
									console.log("月変更の処理呼び出し");
								}
								startYearElement.onchange = event => {
									dateChange();
									console.log("年変更の処理呼び出し");
								}

								/* 日付のプルダウンを変更する処理 */
								function dateChange(){
									startDay = document.getElementById("startDay");
									/* 選択中の年取得 */
									startYear = document.getElementById("startYear");
									var startYearValue = Number(startYear.value);
									/* 選択中の月取得 */
									startMonth = document.getElementById("startMonth");
									var startMonthValue = Number(startMonth.value);

									var date = new Date(startYearValue, startMonthValue, 0);
									var testDate = date.getDate();

									/* 日付の<select option>要素の一括削除 */
									while(startDay.lastChild){
										startDay.removeChild(startDay.lastChild);
									}

									/* 日付の追加 */
									for(let i = 1; i <= testDate; i++){
										startDay = document.getElementById("startDay");
										let option = document.createElement("option");
										option.value = i;
										option.textContent = i;
										startDay.appendChild(option);
									}
								}
							</script>
						</select>
					</td>
					<td rowspan="2">〜</td>

					<!-- 終了日の表示 -->
					<td>
						<select name="endYear" id="endYear">
							<script>
								var endYear = <s:property value="endYear"/>
								let endYearAll = endYear - 5;
								var endYearElement = document.querySelector("[name='endYear']");

								for(let i = 0; i <= 11; i++){
									if(endYearAll == endYear){
										document.write("<option selected>");
									}else{
										document.write("<option>");
									}
									document.write(endYearAll);
									document.write("</option>");
									endYearAll++;
								}
							</script>
						</select>
						-
						<select name="endMonth" id="endMonth">
							<script>
								var endMonth = <s:property value="endMonth"/>
								var endMonthElement = document.querySelector("[name='endMonth']");

								for(let month = 1; month <= 12; month++){
									if(month == endMonth){
										document.write("<option selected>");
									}else{
										document.write("<option>");
									}
									document.write(month);
									document.write("</option>");
								}
							</script>
						</select>
						-
						<select name="endDay" id="endDay">
							<script>
								let endDay = <s:property value="endDay"/>

								/* 方法が誤っている可能性あり */
								var endSelectDate = new Date(endYear, endMonth -1, 1);
								endSelectDate.setDate(endSelectDate.getDate() -1);
								var endlastDate = endSelectDate.getDate();

								/* 日付の初期表示 */
								for(let i = 1; i <= endlastDate; i++){
									if(i == endDay){
										document.write("<option selected>");
									}else{
										document.write("<option>");
									}
									document.write(i);
									document.write("</option>");
								}

								endYearElement.onchange = event => {
									dateChangeTest();
									console.log("終了日の年処理");

								}
								endMonthElement.onchange = event => {
									dateChangeTest();
									console.log("終了日の月処理");
								}

							 	/* 日付のプルダウンを変更する処理 */
							 	/* 後ほど開始日と終了日にてdateChange()を統一予定 */
								function dateChangeTest(){
									endDay = document.getElementById("endDay");
									/* 選択中の年取得 */
									endYear = document.getElementById("endYear");
									var endYearValue = Number(endYear.value);
									/* 選択中の月取得 */
									endMonth = document.getElementById("endMonth");
									var endMonthValue = Number(endMonth.value);

									var date = new Date(endYearValue, endMonthValue, 0);
									var testDate = date.getDate();

									console.log("endDay :"+endDay);
									console.log("endYear :"+endYear);
									console.log("endYearValue :"+endYearValue);
									console.log("endMonth :"+endMonth);
									console.log("endMonthValue :"+endMonthValue);
									console.log("date :"+date);
									console.log("testDate :"+testDate);

									/* 日付の<select option>要素の一括削除 */
									while(endDay.lastChild){
										endDay.removeChild(endDay.lastChild);
									}

									/* 日付の追加 */
									for(let i = 1; i <= testDate; i++){
										endDay = document.getElementById("endDay");
										let option = document.createElement("option");
										option.value = i;
										option.textContent = i;
										endDay.appendChild(option);
									}
								}
							</script>
						</select>
					</td>
				</tr>

				<!-- 時刻の表示 -->
				<tr>
					<s:if test="allDayFlg == 1">
						<td>終日</td>
						<td>終日</td>
					</s:if>
					<s:elseif test="allDayFlg == 0">
						<!-- 開始日の時刻表示 -->
						<td>
							<select name="startHour" id="startHour">
								<script>
									var startTime = "<s:property value='startTime'/>"
									var startTimeHour = Number(startTime.substr(0, 2));

									console.log("startTime :"+startTime);
									console.log("startTimeHour :"+startTimeHour);


									for(let i = 0; i <= 23; i++){
										if(i == startTimeHour){
											document.write("<option selected>");
										}else{
											document.write("<option>");
										}
										document.write(getDoubleNumber(i));
										console.log("getDoubleNumber(i) :"+getDoubleNumber(i));
										document.write("</option>");
									}

									/* 2桁表示する処理 */
									function getDoubleNumber(number){
										return("0" + number).slice(-2);
									}
								</script>
							</select>
							:
							<select name="startMinutes" id="startMinutes">
								<script>
									let startTimeMinutes = Number(startTime.substr(3, 5));

										for(let i = 0; i<= 59; i++){
											if(i == startTimeMinutes){
												document.write("<option selected>");
											}else{
												document.write("<option>");
											}
											document.write(getDoubleNumber(i));
											document.write("</option>");
										}

								</script>
							</select>
						</td>

						<!-- 終了日の時刻 -->
							<td>
								<select name="endHour" id="endHour">
									<script>
										var endTime = "<s:property value='endTime'/>"
										var endTimeHour = Number(endTime.substr(0, 2));

										console.log("endTime :"+endTime);
										console.log("endTimeHour :"+endTimeHour);


										for(let i = 0; i <= 23; i++){
											if(i == endTimeHour){
												document.write("<option selected>");
											}else{
												document.write("<option>");
											}
											document.write(getDoubleNumber(i));
											console.log("getDoubleNumber(i) :"+getDoubleNumber(i));
											document.write("</option>");
										}

										/* 2桁表示する処理 */
										function getDoubleNumber(number){
											return("0" + number).slice(-2);
										}
									</script>
								</select>
								:
								<select name="endMinutes" id="endMinutes">
									<script>
										let endTimeMinutes = Number(endTime.substr(3, 5));

										for(let i = 0; i<= 59; i++){
											if(i == endTimeMinutes){
												document.write("<option selected>");
											}else{
												document.write("<option>");
											}
											document.write(getDoubleNumber(i));
											document.write("</option>");
										}

									</script>
								</select>
							</td>
					</s:elseif>
				</tr>

				<!-- 予定の内容の表示 -->
				<tr>
					<td colspan="3"><b>予定</b></td>
				</tr>
				<tr>
					<td colspan="3">
						<textarea name="schedule">
							<s:property value='schedule'/>
						</textarea>

						<s:textarea value="<s:property value='schedule'/>">
							<s:property value='schedule'/>
						</s:textarea>
						<s:textfield value="<s:property value='schedule'/>">
							<s:property value='schedule'/>
						</s:textfield>
					</td>
				</tr>

				<!-- メモの内容の表示 -->
				<tr>
					<td colspan="3"><b>メモ</b></td>
				</tr>
				<tr>
					<td colspan="3">
						<textarea name="memo">
							<s:property value='memo'/>
						</textarea>
					</td>
				</tr>

			</table>

		</div>
	</s:form>


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
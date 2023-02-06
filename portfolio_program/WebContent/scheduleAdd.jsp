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
				<input type="hidden" name="schedule" id="scheduleOutput" value="<s:property value='schedule'/>">
				<input type="hidden" name="memo" id="memoOutput" value="<s:property value='memo'/>">
				<input type="hidden" name="allDayFlg" id="allDayFlgOutput" value="<s:property value='allDayFlg'/>">

				<input type="hidden" name="startYear" id="startYearOutput" value="<s:property value='startYear'/>">
				<input type="hidden" name="startMonth" id="startMonthOutput" value="<s:property value='startMonth'/>">
				<input type="hidden" name="startDay" id="startDayOutput" value="<s:property value='startDay'/>">
				<input type="hidden" name="endYear" id="endYearOutput" value="<s:property value='endYear'/>">
				<input type="hidden" name="endMonth" id="endMonthOutput" value="<s:property value='endMonth'/>">
				<input type="hidden" name="endDay" id="endDayOutput" value="<s:property value='endDay'/>">

				<input type="hidden" name="startTime" value="<s:property value='startTime'/>">
				<input type="hidden" name="startHour" id="startHourOutput" value="">
				<input type="hidden" name="startMinutes" id="startMinutesOutput" value="">
				<input type="hidden" name="endTime" value="<s:property value='endTime'/>">
				<input type="hidden" name="endHour" id="endHourOutput" value="">
				<input type="hidden" name="endMinutes" id="endMinutesOutput" value="">

				<input type="hidden" name="year" value="<s:property value='year'/>">
				<input type="hidden" name="month" value="<s:property value='month'/>">
				<input type="hidden" name="date" value="<s:property value='date'/>">

				<input type="hidden" value="<s:property value='#session.userId'/>" name="userId">
				<input type="hidden" value="<s:property value='#session.userName'/>" name="userName">

				<input type="submit" value="追加" id="scheduleAddButton">
			</s:form>
		</div>

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



		<div id="main_schedule" align="center">
			<table id="table_schedule" border="1">

					<!-- 日付表示 -->
					<tr>
						<!-- 開始日の表示 -->
						<td>
							<select name="startYearInput" id="startYearInput">
								<script>
									var startYear = <s:property value="startYear"/>
									let startYearAll = startYear - 5;
									var startYearInput = document.querySelector("[name='startYearInput']");

									console.log();
									console.log("startYearInput :"+startYearInput);
									console.log();

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
							<select name="startMonthInput" id="startMonthInput">
								<script>
									var startMonth = <s:property value="startMonth"/>
									var startMonthInput = document.querySelector("[name='startMonthInput']");

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
							<select name="startDayInput" id="startDayInput">
								<script>
									let startDay = <s:property value="startDay"/>
									var startDayElement = document.getElementById("startDayInput");

									var selectDate = new Date(startYear, startMonth, 1);
									selectDate.setDate(selectDate.getDate() -1);
									var lastDate = selectDate.getDate();

									/* 開始日「日」の初期表示*/
									for(let i = 1; i <= lastDate; i++){
										if(i == startDay){
											document.write("<option selected>");
										}else{
											document.write("<option>");
										}
										document.write(i);
										document.write("</option>");
									}

									/* 開始日の「年」変更時の処理 */
									startYearInput.onchange = event => {
										console.log("年変更の処理呼び出し");
										dateChange();

										/* <form action>のstartYearOutputに値を格納 */
										var startYearOutput = document.getElementById("startYearOutput");
										startYearOutput.value = startYearInput.value;
									}
									/* 開始日の「月」変更時の処理 */
									startMonthInput.onchange = event => {
										console.log("月変更の処理呼び出し");
										dateChange();

										/* <form action>のstartMonthOutputに値を格納 */
										var startMonthOutput = document.getElementById("startMonthOutput");
										startMonthOutput.value = startMonthInput.value;
									}
									/* 開始日の「日」変更時の処理 */
									startDayElement.onchange = event => {
										/* <form action>のstartDayOutputに値を格納 */
										var startDayOutput = document.getElementById("startDayOutput");
										startDayOutput.value = startDayInput.value;
									}

									/* 日付のプルダウンを変更する処理 */
									function dateChange(){
										startDayInput = document.getElementById("startDayInput");
										/* 選択中の年取得 */
										startYearInput = document.getElementById("startYearInput");
										var startYearValue = Number(startYearInput.value);
										/* 選択中の月取得 */
										startMonthInput = document.getElementById("startMonthInput");
										var startMonthValue = Number(startMonthInput.value);

										var date = new Date(startYearValue, startMonthValue, 0);
										var testDate = date.getDate();

										console.log("startDay :"+startDay);
										console.log("startYear :"+startYear);
										console.log("startYearValue :"+startYearValue);
										console.log("startMonth :"+startMonth);
										console.log("startMonthValue :"+startMonthValue);
										console.log("date :"+date);
										console.log("testDate :"+testDate);

										/* 日付の<select option>要素の一括削除 */
										while(startDayInput.lastChild){
											startDayInput.removeChild(startDayInput.lastChild);
										}

										/* 日付の追加 */
										for(let i = 1; i <= testDate; i++){
											startDayInput = document.getElementById("startDayInput");
											let option = document.createElement("option");
											option.value = i;
											option.textContent = i;
											startDayInput.appendChild(option);
										}
									}
								</script>
							</select>

						</td>
						<td rowspan="2">〜</td>


						<!-- 終了日の表示 -->
						<td>

							<select name="endYearInput" id="endYearInput">
								<script>
									var endYear = <s:property value="endYear"/>
									let endYearAll = endYear - 5;
									var endYearInput = document.querySelector("[name='endYearInput']");

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
							<select name="endMonthInput" id="endMonthInput">
								<script>
									var endMonth = <s:property value="endMonth"/>
									var endMonthInput = document.querySelector("[name='endMonthInput']");

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
							<select name="endDayInput" id="endDayInput">
								<script>
									let endDay = <s:property value="endDay"/>
									var endDayInput = document.getElementById("endDayInput");

									var endSelectDate = new Date(endYear, endMonth -1, 1);
									endSelectDate.setDate(endSelectDate.getDate() -1);
									var endlastDate = endSelectDate.getDate();

									/* 終了日「日」の初期表示*/
									for(let i = 1; i <= endlastDate; i++){
										if(i == endDay){
											document.write("<option selected>");
										}else{
											document.write("<option>");
										}
										document.write(i);
										document.write("</option>");
									}

									/* 終了日の「年」変更時の処理 */
									endYearInput.onchange = event => {
										dateChangeTest();
										console.log("終了日の年処理");

										var endYearOutput = document.getElementById("endYearOutput");
										endYearOutput.value = endYearInput.value;

									}
									/* 終了日の「月」変更時の処理 */
									endMonthInput.onchange = event => {
										dateChangeTest();
										console.log("終了日の月処理");

										var endMonthOutput = document.getElementById("endMonthOutput");
										endMonthOutput.value = endMonthInput.value;
									}
									/* 終了日の「日」変更時の処理 */
									endDayInput.onchange = event => {
										var endDayOutput = document.getElementById("endDayOutput");
										endDayOutput.value = endDayInput.value;
									}

								 	/* 日付のプルダウンを変更する処理 */
								 	/* 後ほど開始日と終了日にてdateChange()を統一予定 */
									function dateChangeTest(){
										endDayInput = document.getElementById("endDayInput");
										/* 選択中の年取得 */
										endYearInput = document.getElementById("endYearInput");
										var endYearValue = Number(endYearInput.value);
										/* 選択中の月取得 */
										endMonthInput = document.getElementById("endMonthInput");
										var endMonthValue = Number(endMonthInput.value);

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
										while(endDayInput.lastChild){
											endDayInput.removeChild(endDayInput.lastChild);
										}

										/* 日付の追加 */
										for(let i = 1; i <= testDate; i++){
											endDayInput = document.getElementById("endDayInput");
											let option = document.createElement("option");
											option.value = i;
											option.textContent = i;
											endDayInput.appendChild(option);
										}
									}
								</script>
							</select>
						</td>
						<td>
							<input type="checkbox" name="allDayFlgInput" id="allDayFlgInput">
							終日フラグ
						</td>
					</tr>

					<!-- 時刻表示 -->
					<tr>

						<!-- 開始日の時刻表示 -->
						<td>
							<div id="scheduleStartTime">
								<select name="startHourInput" id="startHourInput">
									<script>
										var startTime = "<s:property value='startTime'/>"
										var startTimeHour = Number(startTime.substr(0, 2));
										var startHourInput = document.getElementById("startHourInput");
										var startHourOutput = document.getElementById("startHourOutput");
										startHourOutput.value = startTimeHour;

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

										/* 開始時刻の「時」変更時の処理 */
										startHourInput.onchange = event =>{
											startHourOutput.value = startHourInput.value;
										}
									</script>
								</select>
								:
								<select name="startMinutesInput" id="startMinutesInput">
									<script>
										let startTimeMinutes = Number(startTime.substr(3, 5));
										var startMinutesInput = document.getElementById("startMinutesInput");
										var startMinutesOutput = document.getElementById("startMinutesOutput");
										startMinutesOutput.value = startTimeMinutes;

											for(let i = 0; i<= 59; i++){
												if(i == startTimeMinutes){
													document.write("<option selected>");
												}else{
													document.write("<option>");
												}
												document.write(getDoubleNumber(i));
												document.write("</option>");
											}

										/* 開始時刻の「分」変更時の処理 */
										startMinutesInput.onchange = event =>{
											startMinutesOutput.value = startMinutesInput.value;
										}
									</script>
								</select>
							</div>
							<b id="startAllDay" style="display:none">終日</b>
						</td>

						<!-- 終了日の時刻 -->
						<td>
							<div id="scheduleEndTime">
								<select name="endHourInput" id="endHourInput">
									<script>
										var endTime = "<s:property value='endTime'/>"
										var endTimeHour = Number(endTime.substr(0, 2));
										var endHourInput = document.getElementById("endHourInput");
										var endHourOutput = document.getElementById("endHourOutput");
										endHourOutput.value = endTimeHour;

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

										/* 終了時刻の「時」変更時の処理 */
										endHourInput.onchange = event =>{
											endHourOutput.value = endHourInput.value;
										}
									</script>
								</select>
								:
								<select name="endMinutesInput" id="endMinutesInput">
									<script>
										let endTimeMinutes = Number(endTime.substr(3, 5));
										var endMinutesInput = document.getElementById("endMinutesInput");
										var endMinutesOutput = document.getElementById("endMinutesOutput");
										endMinutesOutput.value = endTimeMinutes;

											for(let i = 0; i<= 59; i++){
												if(i == endTimeMinutes){
													document.write("<option selected>");
												}else{
													document.write("<option>");
												}
												document.write(getDoubleNumber(i));
												document.write("</option>");
											}

										/* 終了時刻の「分」変更時の処理 */
										endMinutesInput.onchange = event =>{
											endMinutesOutput.value = endMinutesInput.value;
										}

									</script>
								</select>
							</div>
							<b id="endAllDay" style="display:none">終日</b>
						</td>

						<!-- チェックの有無にて文字とプルダウン表示を入れ替える -->
						<script>
							var allDayFlg = <s:property value="allDayFlg"/>;
							var allDayFlgTest = <s:property value="#session.allDayFlg"/>;

							var allDayFlgInput = document.getElementById("allDayFlgInput");

							var startHourInput = document.getElementById("startHourInput");
							var startMinutesInput = document.getElementById("startMinutesInput");
							var endHourInput = document.getElementById("endHourInput");
							var endMinutesInput = document.getElementById("endMinutesInput");

							var startAllDay = document.getElementById("startAllDay");
							var endAllDay = document.getElementById("endAllDay");

							var scheduleStartTime = document.getElementById("scheduleStartTime");
							var scheduleEndTime = document.getElementById("scheduleEndTime");

							console.log("allDayFlg :"+ allDayFlg);
							console.log("startHourInput :"+ startHourInput);
							console.log("startMinutesInput :"+ startMinutesInput);

							/* 初期表示の判定 */
							if(allDayFlg == 1){
								document.querySelector("input[type='checkbox'][name='allDayFlgInput']").checked = true;
								startAllDay.style.display = "";
								endAllDay.style.display = "";
								scheduleStartTime.style.display = "none";
								scheduleEndTime.style.display = "none";
							}

							/* 「終日」と「時刻のプルダウン」表示・非表示切り替え */
							allDayFlgInput.onchange = event => {
								var allDayFlgOutput = document.getElementById("allDayFlgOutput");

								if(allDayFlgInput.checked){
									/* 「終日」の文字表示 */
									startAllDay.style.display = "";
									endAllDay.style.display = "";
									scheduleStartTime.style.display = "none";
									scheduleEndTime.style.display = "none";

									allDayFlgOutput.value = "1";
								}else{
									/* 「時刻のプルダウン」表示 */
									startAllDay.style.display = "none";
									endAllDay.style.display = "none";
									scheduleStartTime.style.display = "";
									scheduleEndTime.style.display = "";

									/* 「終日フラグ」解除後に表示されている時刻を<form aciton>の値それぞれに代入 */
									startHourOutput.value = startHourInput.value;
									startMinutesOutput.value = startMinutesInput.value;
									endHourOutput.value = endHourInput.value;
									endMinutesOutput.value = endMinutesInput.value;

									allDayFlgOutput.value = "0";
								}
							}
						</script>

					</tr>
					<!-- スケジュール表示 -->
					<tr>
						<td colspan="3"><b>予定</b></td>
					</tr>
					<tr>
						<td colspan="3">
							<textarea name="scheduleInput" id="scheduleInput"><s:property value='schedule'/></textarea>
						</td>
					</tr>
					<!-- メモの表示 -->
					<tr>
						<td colspan="3"><b>メモ</b></td>
					</tr>
					<tr>
						<td colspan="3">
							<textarea name="memoInput" id="memoInput"><s:property value='memo'/></textarea>
						</td>
					</tr>

					<script>
						var scheduleInput = document.getElementById("scheduleInput");
						var scheduleOutput = document.getElementById("scheduleOutput");
						var memoInput = document.getElementById("memoInput");
						var memoOutput = document.getElementById("memoOutput");

						function inputSchedule(){
							scheduleOutput.value = scheduleInput.value;
						}
						function inputMemo(){
							memoOutput.value = memoInput.value;
						}
						scheduleInput.addEventListener("input" , inputSchedule);
						memoInput.addEventListener("input" , inputMemo);


					</script>

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
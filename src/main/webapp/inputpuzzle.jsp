<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		.button1{
			width:200px;
			height:60px;
			font-size:20px;
			font-weight:bold;
		}
	</style>
	<script type="text/javascript">
		
		function resetInputColor(){
			var inputArray = document.getElementsByName("mapij");
			for(var i = 0; i < 81; i++){
				if(inputArray[i].readOnly == true){
					inputArray[i].style.backgroundColor = "lightgrey";
				}else{
					inputArray[i].style.backgroundColor = "white";
				}
			}
		}
		
		function getLocation(thisInput){
			var inputArray = document.getElementsByName("mapij");
			for(var i = 0; i < 9; i++){
				for(var j = 0; j < 9; j++){
					if(inputArray[i*9+j] == thisInput){
						var m = i;
						var n = j;
						return;
					}
				}
			}	
		}
		
		function checkAnswer(){
			var inputArray = document.getElementsByName("mapij");
			var flag = true;
			var numCode = /^[1-9]{1}$/;
			for(var m = 0; m < 9; m++){
				for(var n = 0; n < 9; n++){
					var thisNum = inputArray[m*9+n].value;
					if(numCode.test(thisNum) == true){
						for(var i = 0; i < 9; i++){
							for(var j = 0; j < 9; j++){
								if(i == m || j == n || (parseInt(i/3)==parseInt(m/3) && parseInt(j/3)==parseInt(n/3))){
									if(inputArray[i*9+j].value == thisNum && !(i==m && j==n)){
										flag = false;
										alert("有错误，请修改");
										return;
									}			
								}
							}
						}
					}
				}
			}
			if(flag == true){
				document.getElementById("f1").submit();
			}
		}
		
		function clickInputColor(thisInput){
			resetInputColor();
			var inputArray = document.getElementsByName("mapij");
			for(var i = 0; i < 9; i++){
				for(var j = 0; j < 9; j++){
					if(inputArray[i*9+j] == thisInput){
						var m = i;
						var n = j;
					}
				}
			}
			if(document.getElementById("colorcb1").checked == false){
				for(var i = 0; i < 9; i++){
					for(var j = 0; j < 9; j++){			
						if(i == m || j == n || (parseInt(i/3)==parseInt(m/3) && parseInt(j/3)==parseInt(n/3))){
							if(inputArray[i*9+j].readOnly == true){
								inputArray[i*9+j].style.backgroundColor = "LightSkyBlue";
							}else{
								inputArray[i*9+j].style.backgroundColor = "LightBlue";
							}				
						}
					}
				}
				if(inputArray[m*9+n].readOnly == true){
					inputArray[m*9+n].style.backgroundColor = "LightSkyBlue";
				}else{
					inputArray[m*9+n].style.backgroundColor = "PowDerBlue";
				}	
			}	
			var clickNum = inputArray[m*9+n].value;
			var numCode = /^\d{1}$/;
			if(numCode.test(clickNum)==true){
				if(document.getElementById("colorcb2").checked == false || document.getElementById("colorcb3").checked == true){
					if(document.getElementById("colorcb3").checked == true){
						for(var x = 0; x < 9; x++){
							for(var y = 0; y < 9; y++){
								var currentNum = inputArray[x*9+y].value;
								if(numCode.test(currentNum)==true){
									if(inputArray[x*9+y].readOnly == true){	
										/* if(inputArray[x*9+y].style.backgroundColor != "Plum"){ */
											inputArray[x*9+y].style.backgroundColor = "LightSkyBlue";												
										/* } */
									}else{
										/* if(inputArray[x*9+y].style.backgroundColor != "LightPink"){ */
											inputArray[x*9+y].style.backgroundColor = "LightBlue";												
										/* } */
									}
								}
							}
						} 
					}	
					for(var i = 0; i < 9; i++){
						for(var j = 0; j < 9 ; j++){
							if(inputArray[i*9+j].value == clickNum){
								if(document.getElementById("colorcb3").checked == true){
									for(var x = 0; x < 9; x++){
										for(var y = 0; y < 9; y++){			
											if(!(x == i && y == j) && (x == i || y == j || (parseInt(x/3)==parseInt(i/3) && parseInt(y/3)==parseInt(j/3)))){
												if(inputArray[x*9+y].readOnly == true){
													inputArray[x*9+y].style.backgroundColor = "LightSkyBlue";
												}else{
													inputArray[x*9+y].style.backgroundColor = "LightBlue";
												}				
											}
										}
									}
								}
								if(document.getElementById("colorcb2").checked == false){
									if(inputArray[i*9+j].readOnly == true){
										inputArray[i*9+j].style.backgroundColor = "Plum";
									}else{
										inputArray[i*9+j].style.backgroundColor = "LightPink";
									}
								}						
							}					
						}
					}
					
				}		
			}else{
				if(document.getElementById("idea").style.display == "block"){
					var ideaInput = document.getElementsByName("ideaInput");
					for(var num = 1; num < 10; num++){
						var flag1 = true;
						for(var i = 0; i < 9; i++){
							for(var j = 0; j < 9 ; j++){
								if(i == m || j == n || (parseInt(i/3)==parseInt(m/3) && parseInt(j/3)==parseInt(n/3))){
									if(inputArray[i*9+j].value == num && !(i==m && j==n)){
										flag1 = false;
										break;
									}			
								}
							}
							if(flag1 == false){
								break;
							}
						}
						if(flag1 == true){
							ideaInput[num-1].value = num;
						}else{
							ideaInput[num-1].value = "";
						}
					}
				}						
			}
		}
	
		function checkNum(thisInput){
			var inputArray = document.getElementsByName("mapij");
			var numCode = /^\d{1}$/;
			var thisNum = thisInput.value;	
			if(numCode.test(thisNum)==true){
				thisInput.style.color = "blue";
				for(var i = 0; i < 9; i++){
					for(var j = 0; j < 9; j++){
						if(inputArray[i*9+j] == thisInput){
							var m = i;
							var n = j;
						}
					}
				}
				for(var i = 0; i < 9; i++){
					for(var j = 0; j < 9; j++){
						if(i == m || j == n || (parseInt(i/3)==parseInt(m/3) && parseInt(j/3)==parseInt(n/3))){
							if(inputArray[i*9+j].value == thisNum && !(i==m && j==n)){
								inputArray[m*9+n].style.color = "red";
								inputArray[i*9+j].style.color = "red";								
							}			
						}
					}
				}
			}else{
				thisInput.style.color = "gray";
			}
			checkRedNum();
		}
		
		function checkRedNum(){
			var inputArray = document.getElementsByName("mapij");
			for(var i = 0; i < 9; i++){
				for(var j = 0; j < 9; j++){
					if(inputArray[i*9+j].style.color == "red"){
						var errorNum = inputArray[i*9+j].value;
						var flag = false;
						for(var m = 0; m < 9; m++){
							for(var n = 0; n < 9; n++){
								if(i == m || j == n || (parseInt(i/3)==parseInt(m/3) && parseInt(j/3)==parseInt(n/3))){
									if(inputArray[m*9+n].value == errorNum && !(i==m && j==n)){
										flag = true;
										break;
									}
								}
							}
							if(flag == true){
								break;
							}
						}
						if(flag == false){
							if(inputArray[i*9+j].readOnly == true){
								inputArray[i*9+j].style.color = "black";
							}else{
								inputArray[i*9+j].style.color = "blue";
							}
						}
					}
				}
			}
		}
		function clickcb1(){
			var cb1 = document.getElementById("cb1");
			var idea = document.getElementById("idea");
			if(cb1.checked == true){
				idea.style.display = "block";
			}else{
				idea.style.display = "none";
			}
		}
		function getSolution(){
			var inputArray = document.getElementsByName("mapij");
			var numCode = /^[0-9-]{1,}$/;
			var flag = true;
			for(var i = 0; i < 81 ;i++){
				var thisNum = inputArray[i].value;
				if(numCode.test(thisNum) == false && !(thisNum == null || thisNum == "")){
					flag = false;
					break;
				}
			}
			if(flag == true){
				document.getElementById("f1").submit();
			}
		}
		function focusInput(thisInput){
			var numCode = /^[1-9]{1}$/;
			var thisNum = thisInput.value;
			if(numCode.test(thisNum)){
				thisInput.select();
			}		
		}
		function dblclickInput(thisInput){
			var numCode = /^[1-9]{1}$/;
			var thisNum = thisInput.value;
			if(numCode.test(thisNum)){
				if(thisInput.readOnly == true){
					thisInput.readOnly = false;
					thisInput.backgroundColor = "white";
				}else{
					thisInput.readOnly = true;
					thisInput.backgroundColor = "lightgrey";
				}
			}else{
				thisInput.select();
			}
		}
	</script>
</head>
<body>
	${testMsg}
	<c:set var="i" value="0"></c:set>		
		<form id="f1" method="post" action="TryGetSolutionServlet">
			<div style="float:left">
				<table border="5" style="/* border-collapse:collapse; */font-size:30px">
					<c:forEach var="row" items="${requestScope.map}">
						<c:choose>
							<c:when test="${i eq 2 || i eq 5 }">
								<c:set var="trstyle" value="border-bottom:5px solid #000"></c:set>
							</c:when>
							<c:otherwise>
								<c:set var="trstyle" value="border-bottom:1px solid #000"></c:set>
							</c:otherwise>
						</c:choose>
						<tr align="center" style="${trstyle}">
							<c:set var="j" value="0"></c:set>
							<c:forEach var="col" items="${row }">
								<c:choose>
									<c:when test="${j eq 2 || j eq 5 }">
										<c:set var="tdstyle" value="border-right:5px solid #000"></c:set>
									</c:when>
									<c:otherwise>
										<c:set var="tdstyle" value="border-right:1px solid #000"></c:set>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${(record[i][j] eq 2) && col != 0}">
										<td style="height:90px;width:90px;${tdstyle};${trstyle}">
										<input type="text" name="mapij" value="${col}" autocomplete="off" 
										style="height:85px;width:85px;font-size:45px;text-align:center;color:blue;font-weight:bold" 
										onclick="clickInputColor(this)" onchange="checkNum(this)" onfocus="focusInput(this)" ondblclick="dblclickInput(this)">
										</td>
									</c:when>
									<c:when test="${col eq 0}">
										<td style="height:90px;width:90px;${tdstyle};${trstyle}">
										<input type="text" name="mapij" autocomplete="off" 
										style="height:85px;width:85px;font-size:45px;text-align:center;color:blue;font-weight:bold" 
										onclick="clickInputColor(this)" onchange="checkNum(this)" onfocus="focusInput(this)" ondblclick="dblclickInput(this)">
										</td>
									</c:when>			
									<c:otherwise>
										<td style="height:90px;width:90px;${tdstyle};${trstyle};background-color:lightgrey">
										<input type="text" name="mapij" value="${col}" readonly="readonly" autocomplete="off" 
										style="height:85px;width:85px;font-size:45px;text-align:center;background-color:lightgrey;font-weight:bold" 
										onclick="clickInputColor(this)">
										</td>
									</c:otherwise>
								</c:choose>
								<c:set var="j" value="${j+1 }"></c:set>
							</c:forEach>				
						</tr>
						<c:set var="i" value="${i+1 }"></c:set>							
					</c:forEach>
				</table><br><br>
			</div>
			<div style="float:left;margin-left:30px">			
				<div>		
					<input type="button" class="button1" value="提交" onclick="checkAnswer()"><br><br>			
					<input type="reset" class="button1" value="重置"><br><br>
					<input type="button" class="button1" value="重置背景颜色" onclick="resetInputColor()"><br><br>
					<input type="button" class="button1" value="返回" onclick="window.history.back()"><br><br>
					<font style="color:red;font-size:20px">${requestScope.msg }</font>
				</div>
				<c:if test="${creatTime != null }">
					<div>
						<font>本次数独生成时间：</font><br>
							<c:choose>
							<c:when test="${creatTime >= 5000 }">
								<font color="red">${creatTime }</font>
								<c:set var="timeMsg" value="较难"></c:set>
								<c:set var="timeMsgColor" value="red"></c:set>
							</c:when>
							<c:otherwise>
								<font color="green">${creatTime }</font>
								<c:set var="timeMsg" value="较易"></c:set>
								<c:set var="timeMsgColor" value="green"></c:set>
							</c:otherwise>
						</c:choose>
						<font>毫秒</font><br>
						<%-- <font style="color:${timeMsgColor}">${timeMsg }</font>	 --%>				
					</div>
				</c:if>
				<br>
				<div>
					<table>
						<tr>
							<td><font>我不想看到蓝色了，蓝色太刺眼</font></td>
							<td><input type="checkbox" style="height:20px;width:20px;" id="colorcb1"></td>
						</tr>
						<tr>
							<td><font>我不想看到粉色了，粉色太刺眼</font></td>
							<td><input type="checkbox" style="height:20px;width:20px;" id="colorcb2"></td>
						</tr>
						<tr>
							<td><font>这个功能花了胡哨，慎用</font></td>
							<td><input type="checkbox" style="height:20px;width:20px;" id="colorcb3"></td>
						</tr>
					</table>
				</div>		
				<br>	
				<c:if test="${complete != 1 }">	
					<table>
						<tr>
							<td width="50px" align="right"><font><b>提示区</b></font></td>
							<td width="150px" align="left"><input type="checkbox" style="height:20px;width:20px;" id="cb1" onclick="clickcb1()"></td>	
						</tr>	
						<tr>
							<td width="200px" colspan="2">（这里是看起来没什么用但是用处却很大的提示区）</td>
						</tr>
					</table>				
					<div id="idea" style="display:none">
						<table border="1" style="border-collapse:collapse">
							<tr>
								<td><input type="text" id="idea1" name="ideaInput" readonly="readonly" 
								style="height:55px;width:55px;font-size:30px;text-align:center;font-weight:bold" value="1"></td>
								<td><input type="text" id="idea2" name="ideaInput" readonly="readonly" 
								style="height:55px;width:55px;font-size:30px;text-align:center;font-weight:bold" value="2"></td>
								<td><input type="text" id="idea3" name="ideaInput" readonly="readonly" 
								style="height:55px;width:55px;font-size:30px;text-align:center;font-weight:bold" value="3"></td>
							</tr>
							<tr>
								<td><input type="text" id="idea4" name="ideaInput" readonly="readonly" 
								style="height:55px;width:55px;font-size:30px;text-align:center;font-weight:bold" value="4"></td>
								<td><input type="text" id="idea5" name="ideaInput" readonly="readonly" 
								style="height:55px;width:55px;font-size:30px;text-align:center;font-weight:bold" value="5"></td>
								<td><input type="text" id="idea6" name="ideaInput" readonly="readonly" 
								style="height:55px;width:55px;font-size:30px;text-align:center;font-weight:bold" value="6"></td>
							</tr>
							<tr>
								<td><input type="text" id="idea7" name="ideaInput" readonly="readonly" 
								style="height:55px;width:55px;font-size:30px;text-align:center;font-weight:bold" value="7"></td>
								<td><input type="text" id="idea8" name="ideaInput" readonly="readonly" 
								style="height:55px;width:55px;font-size:30px;text-align:center;font-weight:bold" value="8"></td>
								<td><input type="text" id="idea9" name="ideaInput" readonly="readonly" 
								style="height:55px;width:55px;font-size:30px;text-align:center;font-weight:bold" value="9"></td>
							</tr>
						</table>
					</div>
				</c:if>		
			</div>		
		</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			.button1{
				width:400px;
				height:80px;
				font-size:20px;
				font-weight:bold;
			}
		</style>
		<!-- <link rel="stylesheet" href="styles/common.css"/> -->
		<script type="text/javascript">
			
			function button1(){
				var f1 = document.getElementById("f1");
				f1.action="CreateRandomMapServlet";
				f1.submit();
			}
			function button2(){
				var f1 = document.getElementById("f1");
				f1.action="CreateNewMapServlet";
				f1.submit();
			}
			function button3(){
				var f1 = document.getElementById("f1");
				f1.action="InputNewMapServlet";
				f1.submit();
			}
		</script>
	</head>
	<body>
		<div align="center">
			<form action="" method="post" id="f1">
				
				<input type="button" class="button1" value="生成新的数独题目" onclick="button2()"><br><br>
				<input type="button" class="button1" value="自己出题自己做" onclick="button3()"><br><br>
				<input type="button" class="button1" value="生成一个已完成的题目（这个钮没什么用）" onclick="button1()"><br><br>
			</form>
		</div>
	</body>
</html>
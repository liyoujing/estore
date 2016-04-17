<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
</head>
<body>
	<center>
  			<h1>添加商品</h1>
  			<hr>
  			<form action="addProduct" method="post"><br>
  			商品名： <input type="text" name="pro_name"><br>
  			商品产地： <input type="text" name="pro_address"><br>
  			商品价格： <input type="text" name="price"><br>
  			商品描述： <input type="text" name="describle"><br>
  			<input type="submit" value="添加商品">
  			</form>
  
  	</center>
  
</body>
</html>
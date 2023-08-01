<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD ITEMS </title>
</head>
<body>
<table width="100%" height="100%">


	
<form method =  "POST" action = "/ExtensionofShop/addItemDetails">
  <table border="1" cellpadding="10" cellspacing="0" align="center">
  <caption>Items </caption>
  	<tr>

  		<td>itemName</td>
  		<td> <input type="text" name="name" value=" "/></td><br>
  		

  		<td>itemDescription</td>
  		<td> <input type="text" name="description" value=" "/></td><br>
  		
  		<td>itemPrice</td>
  		<td> <input type="text" name="price" value=" "/></td><br>
  		
  	
 <th><input type = "submit" name="additems" value = "Next"/></th>
  	
  	 </tr>

  	</form>
  	</table>
</body>
</html>

 
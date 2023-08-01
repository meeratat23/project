<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@page import = "cart.Item" %>
	<%@page import = "cart.ItemDAO" %>
	<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 
	<form name="loginForm" method="GET" action="/ExtensionofShop/removeItemDetails?id=<%=item.getId()>"	
	<table align="center">
	<caption>Cataloq</caption>
	<tr>
	<th>Image</th><th>Description</th><th>Rate</th><th>&nbsp;</th>
	</tr>
<% ItemDAO dao = new ItemDAO();
Collection items = dao.getAllItems();
	Iterator it = items.iterator();
		while(it.hasNext())
		{
			Item item = (Item)it.next();
%>
	<tr>
		<td cellpadding="30"><img src="<%= item.getImagePath() %>"  width="60" height="50" ></td>
		<td cellpadding="30"><B><%= item.getDescription() %></B></td>
		<td cellpadding="30">INR <%= item.getPrice() %></td>
		<td>&nbsp;<input type="checkbox" name="item<%= item.getId() %>" value="ON"></td>
	</tr>
	<% } %>    
	
	<tr>
		<td cellpadding="30" colspan="4" align="center"><input type="submit" name="submit" value="Remove"/></td>
		
	</tr>
	
	</table>
	
	</form>
</td>
</tr>
<tr>
<td width="100%" height="20%" bgcolor="blue">&nbsp;</td>
</tr>
</table>
</html>
</body>
</html>
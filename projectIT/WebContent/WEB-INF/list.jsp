<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="uqu.jeelab.model.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
</head>
<body>
	
	<%
		ArrayList books = (ArrayList) request.getAttribute("books");
		out.println("<table border><tr><th>Name</th><th>Pages</th><tr>");
		for(Object obj : books){
			Book book = (Book) obj;
			String name = book.getName();
			String pages = book.getPages();
			out.print("<tr><td>" +name +"</td><td>" +pages +"</td></tr>");
		}
		out.println("</table>");
	%>
</body>
</html>
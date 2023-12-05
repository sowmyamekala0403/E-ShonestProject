<%@page import="java.util.List"%>
<%@page import="buyNest.dbHandler.DataFetcher"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>E Library</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <%
        List bookList = DataFetcher.fetchBooksInfos();
        HttpSession sessions = request.getSession();
        String uname = (String) sessions.getAttribute("username");
    %>

    <header>
        <h1>E Library</h1>
        <p>Welcome, <%= (uname != null) ? uname : "Guest" %></p>
    </header>


	<main>
		<%
		String[] prodArr2 = null;
		;
		for (int i = 0; i < bookList.size(); i++) {
			String[] bookArr = ((String) bookList.get(i)).split(":");
			prodArr2 = bookArr;
		%>
		<section class="book">
			<img src="prodImg/<%=bookArr[4]%>" alt="book 1">
			<h2><%=bookArr[1]%></h2>
			<p><%=bookArr[2]%></p>
			<span class="price"><%=bookArr[3]%></span>
			<form method="post" action="bookit">
				<input type="hidden" name="bookId"
					value="<%=Integer.parseInt(bookArr[0])%>"> 
					<input type="hidden" name="bookName" value="<%=bookArr[1]%>">
					<input	type="hidden" name="userName" value="<%=uname %>">
				<button type="submit" value="Book Now">Borrow Now</button>
			</form>


		</section>
		<%
		}
		%>


	</main>


</body>
</html>

<%@page import="buyNest.dbHandler.DataFetcher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Admin home</title>
		<link rel="stylesheet" type="text/css" href="adminStyles.css">
	</head>
	<body>
	<h1>Hello Admin!!!</h1>
		<%
			List userList=DataFetcher.fetchUsersInfo();
			List prodList=DataFetcher.fetchBooksInfos();
			List transList = DataFetcher.fetchTransInfos();
		%>	
	
		<div class="panel">
		  <div class="button-container">
		    <button class="active" data-tab="tab1">View Members info</button>
		    <button data-tab="tab2">View Books info</button>
		    <button data-tab="tab3">Add new Books</button>
		    <button data-tab="tab4">View books Transactions </button>
		  </div>
		  <div class="content-container">
		    <div class="tab active" id="tab1">
		      	<table border>
				  <thead>
				    <tr>
				      <th>Username</th>
				      <th>Email</th>
				      <th>Gender</th>
				      <th>Address</th>
				    </tr>
				  </thead>
				  <tbody>
				  
				  	<%
				          for(int i=0; i<userList.size(); i++) {
				        	 String[] custArr=((String)userList.get(i)).split(":");    	 
				    %>
				  	  <tr>
				          <td><%= custArr[0] %></td>
					      <td><%= custArr[1] %></td>
					      <td><%= custArr[2] %></td>
					      <td><%= custArr[3] %></td>
					   </tr>
				     <%
				   	      }                              
				     %>
				    <tr>
				      
				    </tr>
				  </tbody>
				</table>
		    </div>
		    <div class="tab" id="tab2">
		      
		      			<table border>
				  <thead>
				    <tr>
				      <th>ID</th>
				      <th>Name</th>
				      <th>Description</th>
				      <th>Price</th>
				      <th>Image</th>
				    </tr>
				  </thead>
				  <tbody>
				  
				  	<%
				          for(int i=0; i<prodList.size(); i++) {
				        	 String[] prodArr=((String)prodList.get(i)).split(":");    	 
				    %>
				  	  <tr>
				          <td><%= prodArr[0] %></td>
					      <td><%= prodArr[1] %></td>
					      <td><%= prodArr[2] %></td>
					      <td><%= prodArr[3] %></td>
					      <td><img src="prodImg/<%=prodArr[4]%>" alt="book 1" id="imgs" style="width:200px"></td>
					   </tr>
				     <%
				   	      }                              
				     %>
				    <tr>
				      
				    </tr>
				  </tbody>
				</table>
	
				
		    </div>
		   
		   
		    <div class="tab" id="tab3" >
		      	
		      	<form action="addP" method="post" style="width:75vw">
				  <div class="form-group">
				    <label for="book-id">Book ID:</label>
				    <input type="text" id="book-id" name="book-id" required>
				  </div>
				  <br><br>
				  <div class="form-group">
				    <label for="book-name">Book Name:</label>
				    <input type="text" id="book-name" name="book-name" required>
				  </div>
				  <br><br>
				  <div class="form-group">
				    <label for="book-description">Book Description:</label>
				    <textarea id="book-description" name="book-description" required></textarea>
				  </div>
				  <br><br>
				  <div class="form-group">
				    <label for="book-price">Author Name:</label>
				    <input type="text" id="book-price" name="book-price" required>
				  </div>
				  <br><br>
				  <div class="form-group">
				    <label for="book-image">Book Image file name:</label>
				    <input type="text" id="book-image" name="book-image"  required>
				  </div>
				  <br><br>
				  <button type="submit">Submit</button>
				</form>
		      	
		      	     	
		    </div>
		     <div class="tab active" id="tab4">
		      	<table border>
				  <thead>
				    <tr>
				      <th>Book ID</th>
				      <th>Book Name</th>
				      <th>Taken By</th>
				    </tr>
				  </thead>
				  <tbody>
				  
				  	<%
				          for(int i=0; i<transList.size(); i++) {
				        	 String[] mems=((String)transList.get(i)).split(":");    	 
				    %>
				  	  <tr>
				          <td><%= mems[0] %></td>
					      <td><%= mems[1] %></td>
					      <td><%= mems[2] %></td>
					      
					   </tr>
				     <%
				   	      }                              
				     %>
				    <tr>
				      
				    </tr>
				  </tbody>
				</table>
		    </div>
		    
		  </div>
		  
		  
		</div>
		
		
		
		
		<script type="text/javascript">
		const buttons = document.querySelectorAll('.button-container button');
		const tabs = document.querySelectorAll('.tab');

		buttons.forEach(button => {
		  button.addEventListener('click', () => {
		    const tabId = button.dataset.tab;
		    const tab = document.getElementById(tabId);
		    tabs.forEach(tab => tab.classList.remove('active'));
		    buttons.forEach(button => button.classList.remove('active'));
		    tab.classList.add('active');
		    button.classList.add('active');
		  });
		});

		</script>
	</body>
</html>
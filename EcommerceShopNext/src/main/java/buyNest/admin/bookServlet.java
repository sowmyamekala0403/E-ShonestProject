package buyNest.admin;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import buyNest.dbHandler.DataInjector;
@WebServlet("/addP")

public class bookServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println(req.getParameter("book-id"));
		int bid=Integer.parseInt(req.getParameter("book-id"));
		String bname=req.getParameter("book-name");
		String bdesc=req.getParameter("book-description");
		String author=req.getParameter("book-price");
		String bimg=req.getParameter("book-image");
		
		DataInjector.addbook(bid, bname, bdesc, author, bimg);
	}

}

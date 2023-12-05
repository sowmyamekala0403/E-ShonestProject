package buyNest.admin;

import buyNest.dbHandler.DataAdder;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/bookit")
public class transServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		String uname = req.getParameter("userName");
		String bname = req.getParameter("bookName");
		int bid = Integer.parseInt(req.getParameter("bookId"));
		DataAdder.addtrans(bid,uname,bname);
	}
}

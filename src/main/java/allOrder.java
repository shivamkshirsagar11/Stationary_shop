import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(urlPatterns = {"/allorder"})
public class allOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(300);
		res.setContentType("text/html");
		try {

			out.print(
					"<html><head><title>Products</title><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'></head>");

			out.print(
					"<body><nav class='navbar navbar-dark bg-dark'><div class='container-fluid'><a class='navbar-brand' href='#'>Stationary Shop</a><a class='navbar-brand navbar-right' href='index.jsp'>Log out</a></div></nav>");
			
			String mob = (String) session.getAttribute("mob");
			String start = "<tr><th>Product ID</th><th>Item Name</th><th>Quantity</th><th>Price(per item)</th></tr>",
					start2, name = null, odate, tot, ll = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/stationary";
			Connection conn = DriverManager.getConnection(url, "root", "2002");
			Statement stm = conn.createStatement();
			Statement stm2 = conn.createStatement();
			String query = "select * from users where `mobile` = '" + mob + "'";
			ResultSet rs, rs2;
			int idc = -1;
			String email = null;
			rs = stm.executeQuery(query);
			if (rs.next()) {
				idc = rs.getInt("id");
				name = rs.getString("name");
				ll = rs.getString("last_login");
				email = rs.getString("email");
				out.print(
						"<form class='container' style='max-width:50%;'><h4>Your Personal Details:</h4><table class='table table-striped'><tr><th>Name:</th><td>"
								+ name + "</td></tr><tr><th>Email:</th><td>" + email
								+ "</td></tr><tr><th>Mobile No:</th><td>" + mob
								+ "</td></tr><tr><th>Last Login:</th><td>" + ll + "</td></tr></table></form><hr><br>");
			}
			out.print("<form class='container' style='max-width:70%'><h4>Your Past Orders:</h4><hr>");
			query = "select * from orderhistory where id = '" + idc + "' order by odate desc";
			rs = stm.executeQuery(query);
			while (rs.next()) {
				String ssid = rs.getString("sid");
				odate = rs.getString("odate");
				tot = rs.getString("pay");
				start2 = "<table class='table table-striped'><tr><th>Order ID</th><td>" + ssid
						+ "</td><th>Ordering date</th><td>" + odate + "</td></tr>";
				out.print(start2);
				out.print(start);
				query = "select * from orderdetails where sid = '" + ssid + "'";
				rs2 = stm2.executeQuery(query);
				while (rs2.next()) {
					int qty = rs2.getInt("qty");
					String s;
					s = "<tr><td>" + rs2.getString("oid") + "</td><td>" + rs2.getString("oname") + "</td><td>"
							+ String.valueOf(qty) + "</td><td>" + String.valueOf(rs2.getInt("totprice") / qty)
							+ "</td></tr>";
					out.print(s);
				}
				out.print("<tr><th></th><td></td><th>Total Amount Paid</th><td>" + tot + "/-</td></tr></table><br>");
				rs2.close();
			}
			rs.close();

			out.print("</form><div class='container' style='max-width:70%;'><button class='btn btn-dark' onclick='window.print()'>Print Orders</button>");
			out.print(
					"<br><br><button class='btn btn-dark' onclick='history.back()'>Go Back</button></body>");
		} catch (Exception e) {
			System.out.println("There was some error in/n" + e.getLocalizedMessage());
		}
	}
}
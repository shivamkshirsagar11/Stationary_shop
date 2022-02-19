
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet(urlPatterns = {"/cart"})
public class cart extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest request,HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(300);
		res.setContentType("text/html");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			out.print("<html><head><title>Customer Home</title><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'></head>"); 
			out.print("<nav class='navbar navbar-dark bg-dark'><div class='container-fluid'><a class='navbar-brand' href='#'>Stationary Shop</a><div class='navbar-brand navbar-right'>Cart Items</div></div></nav>");
			 
			String url = "jdbc:mysql://localhost:3306/stationary";
			Connection conn = DriverManager.getConnection(url,"root","2002");
			Statement stm = conn.createStatement();
			String s1 = "<form class='container' action='bill'><table class='table table-striped'><tr><thead class='thead-dark'><th>Order ID</th><th>Item Name</th><th>Quantity</th><th>Price</th><th>Remove</th></thead></tr>",s2;
			out.print(s1);
			ArrayList<prods> prodsInCart = new ArrayList<>();
			String q = "select * from book";
			ResultSet rs = stm.executeQuery(q);
			while(rs.next()){
				String i = request.getParameter(rs.getString("id"));
				if (!i.equals("")){
				int items = Integer.parseInt(i);
					if(items != 0){
						prodsInCart.add(new prods(rs.getString("id"),rs.getString("name"),items,rs.getDouble("price")));
						s2 = "<tr><td>"+rs.getString("id")+"</td><td>"+rs.getString("name")+"</td><td>"+items+"</td><td>"+rs.getDouble("price")+"</td><td><input type='number' name='"+rs.getString("id")+"'></td></tr>";
						out.print(s2);
					}
				}
			}

			q = "select * from pen";
			rs = stm.executeQuery(q);
			while(rs.next()){
				String i = request.getParameter(rs.getString("id"));
				if (!i.equals("")){
				int items = Integer.parseInt(i);
					if(items != 0){
						prodsInCart.add(new prods(rs.getString("id"),rs.getString("name"),items,rs.getDouble("price")));
						s2 = "<tr><td>"+rs.getString("id")+"</td><td>"+rs.getString("name")+"</td><td>"+items+"</td><td>"+rs.getDouble("price")+"</td><td><input type='number' name='"+rs.getString("id")+"'></td></tr>";
						out.print(s2);
					}
				}
			}

			q = "select * from desk";
			rs = stm.executeQuery(q);
			while(rs.next()){
				String i = request.getParameter(rs.getString("id"));
				if (!i.equals("")){
				int items = Integer.parseInt(i);
					if(items != 0){
						prodsInCart.add(new prods(rs.getString("id"),rs.getString("name"),items,rs.getDouble("price")));
						s2 = "<tr><td>"+rs.getString("id")+"</td><td>"+rs.getString("name")+"</td><td>"+items+"</td><td>"+rs.getDouble("price")+"</td><td><input type='number' name='"+rs.getString("id")+"'></td></tr>";
						out.print(s2);
					}
				}
			}

			q = "select * from calcu";
			rs = stm.executeQuery(q);
			while(rs.next()){
				String i = request.getParameter(rs.getString("id"));
				if (!i.equals("")){
				int items = Integer.parseInt(i);
					if(items != 0){
						prodsInCart.add(new prods(rs.getString("id"),rs.getString("name"),items,rs.getDouble("price")));
						s2 = "<tr><td>"+rs.getString("id")+"</td><td>"+rs.getString("name")+"</td><td>"+items+"</td><td>"+rs.getDouble("price")+"</td><td><input type='number' name='"+rs.getString("id")+"'></td></tr>";
						out.print(s2);
					}
				}
			}
			out.print("</table><br><button class='btn btn-success' type='submit'>BILLING</button></form>");
			session.setAttribute("allOrd",prodsInCart);
		}
		catch(Exception e) {
			System.out.println("There was some error in/n"+e.getLocalizedMessage());
		}
	}
}

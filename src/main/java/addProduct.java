
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/add"})
public class addProduct extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String product = (String) session.getAttribute("product");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/stationary";
			Connection conn = DriverManager.getConnection(url, "root", "2002");
			Statement stm = conn.createStatement();

			if (product.equals("Book")) {
				String id = (String) session.getAttribute("pid");
				String name = (String) session.getAttribute("pname");
				String des = (String) session.getAttribute("pdes");
				String author = (String) request.getParameter("author");
				String	nop = (String)request.getParameter("pages");
				String	price = (String) request.getParameter("price");
				String	stock = (String) request.getParameter("stock");
				String query = "insert into book values('" + id + "', '" + name + "', '" + des + "', '" + author + "', '"+ price + "', '" + nop + "', '" + stock + "')";
				stm.executeUpdate(query);
				
			}

			if (product.equals("Pen")) {
				String id = (String) session.getAttribute("pid");
				String name = (String) session.getAttribute("pname");
				String des = (String) session.getAttribute("pdes");
				String compname = (String) request.getParameter("compname");
				String color = (String) request.getParameter("color");
				String price = (String) request.getParameter("price");
				String stock = (String) request.getParameter("stock");
				
				String query = "insert into pen values('" + id + "', '" + name + "', '" + des + "', '" + color + "', '"+ compname + "', '" + price + "', '" + stock + "')";
				stm.executeUpdate(query);
			}

			if (product.equals("Desk")) {
				String id = (String) session.getAttribute("pid");
				String name = (String) session.getAttribute("pname");
				String des = (String) session.getAttribute("pdes");
				String compname = (String) request.getParameter("compname");
				String material = (String) request.getParameter("material");
				String price = (String) request.getParameter("price");
				String stock = (String) request.getParameter("stock");
				
				String query = "insert into desk values('" + id + "', '" + name + "', '" + des + "', '" + material + "', '" + compname + "', '"+ price + "', '" + stock + "')";
				stm.executeUpdate(query);
			}

			if (product.equals("Calculator")) {
				String id = (String) session.getAttribute("pid");
				String name = (String) session.getAttribute("pname");
				String des = (String) session.getAttribute("pdes");
				String compname = (String) request.getParameter("compname");
				String type = (String) request.getParameter("type");
				String price = (String) request.getParameter("price");
				String stock = (String) request.getParameter("stock");
				
				String query = "insert into calcu values('" + id + "', '" + name + "', '" + des + "', '" + type + "', '"+ compname + "', '" + price + "', '" + stock + "')";
				stm.executeUpdate(query);
			}
			
			response.sendRedirect("login.jsp");
		} catch (Exception e) {
			out.print(e.getLocalizedMessage());
		}
	}
	
}

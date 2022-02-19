
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/check"})
public class checkproduct extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		int duplicate = 0;
		String product = (String) request.getParameter("product");
		String id = (String) request.getParameter("pId");
		String name = (String) request.getParameter("pName");
		String des = (String) request.getParameter("des");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/stationary";
			Connection conn = DriverManager.getConnection(url, "root", "2002");
			Statement stm = conn.createStatement();
			String query = "select * from book where id = '" + id + "'";
			ResultSet rs = stm.executeQuery(query);
			if (rs.next())
				duplicate++;

			query = "select * from pen where id = '" + id + "'";
			rs = stm.executeQuery(query);
			if (rs.next())
				duplicate++;

			query = "select * from desk where id = '" + id + "'";
			rs = stm.executeQuery(query);
			if (rs.next())
				duplicate++;

			query = "select * from calcu where id = '" + id + "'";
			rs = stm.executeQuery(query);
			if (rs.next())
				duplicate++;
		}

		catch (Exception e) {
			out.print(e.getLocalizedMessage());
		}

		if (duplicate == 0) {
			session.setAttribute("pid", id);
			session.setAttribute("pname", name);
			session.setAttribute("pdes", des);
			session.setAttribute("product", product);

			if (product.equals("Book")) {
				response.sendRedirect("book.jsp");
			}

			if (product.equals("Pen")) {
				response.sendRedirect("pen.jsp");
			}

			if (product.equals("Desk")) {
				response.sendRedirect("desk.jsp");
			}

			if (product.equals("Calculator")) {
				response.sendRedirect("calc.jsp");
			}
		}
		
		else {
			
			request.setAttribute("error","Product Already Exist!!!" );
			RequestDispatcher rd = request.getRequestDispatcher("addproduct.jsp");
			rd.include(request, response);
		}
	}
}


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession; 
@WebServlet(urlPatterns = {"/commit"})
public class commit extends HttpServlet{
	private static final long serialVersionUID = -830271168337258325L;
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(300);
		try {
			ArrayList<complainStore> solve = new ArrayList<>();
			Class.forName("com.mysql.cj.jdbc.Driver");
			  Date currentDate = new Date();
			  SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MMM/yyyy");
			  String dateOnly = dateFormat.format(currentDate);
		String url = "jdbc:mysql://localhost:3306/stationary";
		Connection conn = DriverManager.getConnection(url,"root","2002");
		Statement stm = conn.createStatement();
		String q = "select * from complaint where token not in(select token from solved)";
		ResultSet rs = stm.executeQuery(q);
		while(rs.next()) {
			String answer = (String)request.getParameter(rs.getString("token"));
			if(!answer.equals("")) {
				solve.add(new complainStore(rs.getString("token"),answer));
			}
		}
		
		for(complainStore s:solve) {
			q = "insert into solved(token,sdate,solmsg) values ('"+s.getToken()+"', '"+dateOnly+"', '"+s.getAnswer()+"')";
			stm.executeUpdate(q);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");	
		rd.include(request, response);
	}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

}

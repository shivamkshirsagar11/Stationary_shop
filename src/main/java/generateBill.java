
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import java.util.Date;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet(urlPatterns = {"/bill"})
public class generateBill extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	public void service(HttpServletRequest request,HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(300);
		res.setContentType("text/html");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			out.print("<html><head><title>[INVOICE]</title><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'></head>"); 
			out.print("<nav class='navbar navbar-dark bg-dark'><div class='container-fluid'><a class='navbar-brand'>Stationary Shop &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;[INVOICE]</a><div class='navbar-brand navbar-center'>Thank you!!</div></div></nav>");
			String url = "jdbc:mysql://localhost:3306/stationary";
			String start="<form class='container'><table class='table table-striped'><thead class='thead-dark'><tr><th>Order ID</th><th>Item Name</th><th>Quantity</th><th>Price(per item)</th></tr></thead>",s2,name=null;
			Connection conn = DriverManager.getConnection(url,"root","2002");
			Statement stm = conn.createStatement();
			Date dNow = new Date();
			String date = dNow.toString();
			updateDatabase data = new updateDatabase();
			String q1 = "select * from sidgetter";
			ResultSet rs2 = stm.executeQuery(q1);
			String sid = "ORD_ID_";
			if(rs2.next()) sid += rs2.getString("sid");
			q1 ="UPDATE sidgetter set sid = sid + 1 where sid = sid";
			stm.executeUpdate(q1);
//			out.print(sid);
			String m = (String)session.getAttribute("mob");
			String q = "select * from users where mobile ='"+m+"'",address="";int idc=-1;
			ResultSet rs = stm.executeQuery(q);
			if(rs.next()){
				idc = rs.getInt("id");
				name = rs.getString("name");
				address = rs.getString("address");
			}
			String start2 = "<div class='container' style='margin-top:4.2%;'><table border='2px solid brown' class='table table-light'><thead class='thead-dark'><tr><th>Name</th><td>"+name+"</td></tr></thead><thead class='thead-dark'><tr><th>Contact No</th><td>"+m+"</td></tr></thead><thead class='thead-dark'><tr><th>Ordering date</th><td>"+date+"</td></tr></thead><tr><th>Shipped to </th><td>"+address+"</td></tr></thead></table>";
			out.print(start2);out.print(start);
			ArrayList<prods> prodsInCart = new ArrayList<>();
			double t=0.0;
			prodsInCart = (ArrayList<prods>)session.getAttribute("allOrd");
			for(prods p:prodsInCart){
				String i = request.getParameter(p.id);
				if (!i.equals("")){
					int items = Integer.parseInt(i);
						p.reduceItems(items);
						p.calculateTotal();
				}
				else{
					p.calculateTotal();
				}
				if(p.items != 0){
				s2 = "<tr><td>"+p.id+"</td><td>"+p.name+"</td><td>"+p.items+"</td><td>"+p.price+"</td></tr>";
				out.print(s2);
				t += p.tot;
				boolean updated = data.update("book", p.id, p.items);
				if (!updated) updated = data.update("pen", p.id, p.items);
				if (!updated) updated = data.update("desk", p.id, p.items);
				if (!updated) updated = data.update("calcu", p.id, p.items);
				}
				
				else {
					prodsInCart.remove(p);
				}
			}
			if(prodsInCart.size() != 0) {
				for(prods p:prodsInCart){
					if(p.items == 0) prodsInCart.remove(p);
				}
			}
			

			if(prodsInCart.size() != 0) {
				out.print("<tr><th></th><td></td><th>Total Amount To Be Paid</th><td>"+t+"/-</td></tr><tr><th></th><td></td><th>ORDERID</th><td>"+sid+"</td></tr>");
			q = "insert into orderhistory values('"+idc+"', '"+sid+"', '"+t+"', '"+dNow+"')";
			stm.executeUpdate(q);
			for(prods p: prodsInCart){
				if(p.items != 0){
				q = "insert into orderdetails(oid,oname,qty,id,sid,totprice) values('"+p.id+"', '"+p.name+"', '"+p.items+"', '"+idc+"', '"+sid+"', '"+p.tot+"')";
				stm.executeUpdate(q);
				}
			}
			}
			else {
				out.print(prodsInCart.size());
			}
			
			out.print("</table></form><button class='btn btn-success'onclick=\"window.print()\">Print bill</button>");
			out.print("<h4><a class='btn btn-danger'href=\"login.jsp\">Logout</a></h4></div>");
			
		}
		catch(Exception e) {
			System.out.println("There was some error in/n"+e.getLocalizedMessage());
		}
	}
}

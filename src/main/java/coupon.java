
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/coupons"})
public class coupon extends HttpServlet{
	private static final long serialVersionUID = -830271168337258325L;
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(300);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			out.print("<html><head><title>Solved complaints</title><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>"
					+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
					+ "<style>"
					+ ".tooltip {"
					+ "  position: relative;"
					+ "  display: inline-block;"
					+ "}"
					+ ".tooltip .tooltiptext {"
					+ "  visibility: hidden;"
					+ "  width: 140px;"
					+ "  background-color: #555;"
					+ "  color: #fff;"
					+ "  text-align: center;"
					+ "  border-radius: 6px;"
					+ "  padding: 5px;"
					+ "  position: absolute;"
					+ "  z-index: 1;"
					+ "  bottom: 150%;"
					+ "  left: 50%;"
					+ "  margin-left: -75px;"
					+ "  opacity: 0;"
					+ "  transition: opacity 0.3s;"
					+ "}"
					+ ".tooltip .tooltiptext::after {"
					+ "  content: \"\";"
					+ "  position: absolute;"
					+ "  top: 100%;"
					+ "  left: 50%;"
					+ "  margin-left: -5px;"
					+ "  border-width: 5px;"
					+ "  border-style: solid;"
					+ "  border-color: #555 transparent transparent transparent;"
					+ "}"
					+ ".tooltip:hover .tooltiptext {"
					+ "  visibility: visible;"
					+ "  opacity: 1;"
					+ "}"
					+ "</style>"
					+ "</head>"); 
			
			out.print("<body><nav class='navbar navbar-dark bg-dark'><div class='container-fluid'><a class='navbar-brand' href='#'>Stationary Shop</a><a class='navbar-brand navbar-right' href='login.jsp'>Log out</a></div></nav><br><br>");
		out.print("<p>Click on the button to copy the text from the text field. Try to paste the text (e.g. ctrl+v) afterwards in a different window, to see the effect.</p>"
				+ "\r\n"
				+ "<input type=\"text\" value=\"Hello World\" id=\"myInput\">"
				+ "<div class=\"tooltip\">"
				+ "<button onclick=\"myFunction()\" onmouseout=\"outFunc()\">"
				+ "  <span class=\"tooltiptext\" id=\"myTooltip\">Copy to clipboard</span>"
				+ "  Copy text"
				+ "  </button>"
				+ "</div>");
		String home = "<script>"
				+ "function myFunction() {"
				+ "  var copyText = document.getElementById(\"myInput\");"
				+ "  copyText.select();"
				+ "  copyText.setSelectionRange(0, 99999);"
				+ "  navigator.clipboard.writeText(copyText.value);"
				+ "  var tooltip = document.getElementById(\"myTooltip\");"
				+ "  tooltip.innerHTML = \"Copied: \" + copyText.value;"
				+ "}"
				+ "function outFunc() {"
				+ "  var tooltip = document.getElementById(\"myTooltip\");"
				+ "  tooltip.innerHTML = \"Copy to clipboard\";\r\n"
				+ "}"
				+ "</script></body></html>";
		out.print(home);
	}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

}

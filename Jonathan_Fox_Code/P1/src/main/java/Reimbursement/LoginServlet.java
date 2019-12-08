package Reimbursement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Reimbursement.html;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		response.getWriter().printf("%s%s", "<!DOCTYPE html>\n",
				new html("", "", new head("", ""),
						new body("", "", new title("", "EMPLOYEE LOGIN"),
								new div("", "div1", new form("", "form1", new p("", "child1"), new p("", "child2")),
										new form("style=\"background-color:red\"", "red form")),
								new hr("", ""),
								new div("", "div2", new p("", "blahblahblah"), new button("type=\"submit\"", "BUTTON")),
								new table("border=10", "", new tr("", "row", new td("", "col1"), new td("", "col2")))))
										.write());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package Reimbursement;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeController {

	public static void homepage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		DAO dao = (DAO) session.getAttribute("dao");
		User u = (User) session.getAttribute("user");
		String s = "<!DOCTYPE html>\n";
		TreeMap <Integer, Ticket> tmap;
		html[] statusInputs = new html[4];
		html[] tickets;
		
		statusInputs[0] = new input("type = \"radio\" name = \"ttype\" value = \"0\"","LODGING");
		statusInputs[1] = new input("type = \"radio\" name = \"ttype\" value = \"1\"","TRAVEL");
		statusInputs[2] = new input("type = \"radio\" name = \"ttype\" value = \"2\"","FOOD");
		statusInputs[3] = new input("type = \"radio\" name = \"ttype\" value = \"3\"","OTHER");
		
		
		if(u == null || dao == null) {
			System.out.printf("LOGIN FIRST\n");
			response.sendRedirect("./login.html");
			return;
		}

		tmap = dao.getTickets(u);
		
		if (tmap != null && tmap.size() != 0) {
			tickets = new html[tmap.size()];
			int j = 0;
			
			for (Integer i = tmap.firstKey(); i != null; i = tmap.higherKey(i)) {
				Ticket t = tmap.get(i);

				tickets[j++] = new tr(String.format("class=\"%s\"", statusColour(t.getStatus())), "", new td("", String.format("%d", i)), new td("", t.getEmail()),
						new td("", String.format("%f", t.getAmount())), new td("", t.getDesc()),
						new td("", typeString(t.getType())), new td("", t.getTime().toString()));
			}
		} else tickets = new html[0];
		
		s = s + String.format("%s\n%s\n", new head("", "", new style("",
				".yellow {background-color:yellow;} .red {background-color:red;} .green {background-color:green} .purple {background-color:purple} ")).write(),
				new body("", "", new title("", String.format("User: %s", u.getEmail())),
						new h1("text-align=\"center\"", String.format("YOU ARE %s %s", u.getName()[0], u.getName()[1]),
								new div("", (u.isAdvisor()) ? "ADVISOR" : "EMPLOYEE")),
						new form("method = \"POST\" action = \"RegisterTicket.fhtagn\"", "REGISTER TICKET",
								new div("", "", statusInputs),
								new input("class = \"textsubmit\" type=\"number\" name = \"price\" placeholder=\"How much did you spend in dollars?\"", ""),
								new input("class = \"textsubmit\" type=\"text\" name = \"Description\" placeholder=\"description\"", ""),
								new button("type=\"submit\"", "<i>SUBMIT!</i>")),
						new br("",""),
						new table("border=1", "", tickets)).write());

		
		response.setContentType("text/html");
		try {
			response.getWriter().printf("%s\n", s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String typeString(byte t) {
		switch (t) {
		case 0: return "LODGING";
		case 1: return "TRAVEL";
		case 2: return "FOOD";
		default: return "OTHER";
		}
	}
	
	private static String statusColour(int status) {
		switch(status) {
		case 0: return "yellow";
		case 1: return "green";
		case -1: return "red";
		default: return "purple";
		}
	}
}

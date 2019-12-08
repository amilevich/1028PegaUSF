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
			response.sendRedirect(Rhylehian.incant(Rhylehian.WELCOME));
			return;
		}

		tmap = dao.getTickets(u);

		if (tmap != null && tmap.size() != 0) tickets = new html[tmap.size() + 1];
		else tickets = new html[1];
		
		int j = 1;

		tickets[0] = new tr("class=\"purple\"", "", new td("", "ID"), new td("", "STATUS"), new td("", "EMAIL"),
				new td("", "AMOUNT"), new td("", "DESCRIPTION"), new td("", "TYPE"), new td("", "TIMESTAMP"));

		
		for (Integer i = (tickets.length==1)?null:tmap.lastKey(); i != null; i = tmap.lowerKey(i)) {
			Ticket t = tmap.get(i);

			tickets[j++] = new tr(String.format("class=\"%s\"", statusColour(t.getStatus())), "",
					new td("", "", (u.isAdvisor()&&t.getStatus()==0) ? new form(String.format("method=\"POST\" action=\"%s\"", Rhylehian.incant(Rhylehian.SET_STATUS)), "",
									new div("", String.format("%d", i)),
									new select("name=\"mod\"", "", new option("value=-1", "DENY"),
											new option("value=1", "APPROVE")),
									new button(String.format("type=\"submit\" name=\"id\" value=\"%d\"", i), "<i>SUBMIT!</i>"))
							: new div("", String.format("%d", i))),
					new td("", statusString(t.getStatus())), new td("", t.getEmail()),
					new td("", String.format("$%.2f", t.getAmount())), new td("", t.getDesc()),
					new td("", typeString(t.getType())), new td("", t.getTime().toString()));
		}

		s = s + String.format("%s\n%s\n", new head("", "", new style("",
				".yellow {background-color:#ffff66;} .red {background-color:red;} .green {background-color:#99ff66} .purple {background-color:#cc33ff} *{font-size: 26px; font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;}"))
						.write(),
				new body("", "", new title("", String.format("User: %s", u.getEmail())),
						new h1("text-align=\"center\"", String.format("YOU ARE %s %s", u.getName()[0], u.getName()[1]),
								new div("", (u.isAdvisor()) ? "ADVISOR" : "EMPLOYEE")),
						new form(String.format("method = \"POST\" action = \"%s\"", Rhylehian.incant(Rhylehian.REGISTER_TICKET)), "REGISTER TICKET",
								new div("", "", statusInputs),
								new input("class = \"textsubmit\" type=\"number\" name=\"price\" step=.01 placeholder=\"How much did you spend in dollars?\"", ""),
								new input("class = \"textsubmit\" type=\"text\" name = \"Description\" placeholder=\"description\"", ""),
								new button("type=\"submit\"", "<i>SUBMIT!</i>")),
						new form(String.format("method = \"POST\" action=\"%s\"", Rhylehian.incant(Rhylehian.WELCOME)),"",
							new button("type='submit'","LOGOUT")),
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
	
	private static String statusString(int status) {
		switch(status) {
		case 0: return "PENDING";
		case 1: return "APPROVED";
		case -1: return "DENIED";
		default: return "ELDRITCH";
		}
	}
}

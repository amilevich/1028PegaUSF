package HTML;


public class JunkDriver {

	public static void main(String[] args) {
		html[] children = new html[2];
		children[0] = new form("name=\"child1\"");
		children[1] = new form("name=\"child2\"");
		System.out.printf("%s%s", "<!DOCTYPE html>\n",new html("", new head(""),
				new body("", new title("value=\"EMPLOYEE LOGIN\""),
						new div("", new form("", children), new form("style=\"color:javablood\"")),
						new div("", new p("value=blahblahblah"), new button("type=\"submit\" value=\"SUBMIT!\"")))
								).write());
	}

}

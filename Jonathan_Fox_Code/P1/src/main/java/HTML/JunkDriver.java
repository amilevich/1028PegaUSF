package HTML;


public class JunkDriver {

	public static void main(String[] args) {
		HTMLament[] children = new HTMLament[2];
		children[0] = new form("name=\"child1\"");
		children[1] = new form("name=\"child2\"");
		System.out.printf("%s",
				new body("", new title("value=\"EMPLOYEE LOGIN\""),
						new div("", new form("", children), new form("style=\"color:javablood\"")),
						new div("", new p("value=blahblahblah"), new button("type=\"submit\" value=\"SUBMIT!\"")))
								.write());
	}

}

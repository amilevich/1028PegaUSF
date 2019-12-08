package HTML;

public class html {
	protected String tag;
	protected String attributes;
	protected html[] children;
	
	public html(String a, html ...c){
		attributes = a;
		children = c;
		tag = "html";
	}
	
	protected html(String t, String a, html ...c) {
		attributes = a;
		children = c;
		tag = t;
	}
	
	public String write() {
		String s = String.format("<%s %s>", tag, attributes);
		for(int i = 0; i < children.length; i++) s += children[i].write();
		return String.format("%s</%s>\n", s, tag);
	}
	
}

class body extends html{body(String a, html ...c){super("body",a,c);}}
class form extends html{form(String a, html ...c){super("form",a,c);}}
class input extends html{input(String a, html ...c){super("input",a,c);}}
class button extends html{button(String a, html ...c){super("button",a,c);}}
class table extends html{table(String a, html ...c){super("table",a,c);}}
class head extends html{head(String a, html ...c){super("head",a,c);}}
class script extends html{script(String a, html ...c){super("script",a,c);}}
class div extends html{div(String a, html ...c){super("div",a,c);}}
class p extends html{p(String a, html ...c){super("p",a,c);}}
class title extends html{title(String a, html ...c){super("title",a,c);}}

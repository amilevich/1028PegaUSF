package HTML;

public abstract class HTMLament {
	protected String tag;
	protected String attributes;
	protected HTMLament[] children;
	
	HTMLament(String t, String a, HTMLament ...c) {
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

class body extends HTMLament{body(String a, HTMLament ...c){super("body",a,c);}}
class form extends HTMLament{form(String a, HTMLament ...c){super("form",a,c);}}
class input extends HTMLament{input(String a, HTMLament ...c){super("input",a,c);}}
class button extends HTMLament{button(String a, HTMLament ...c){super("button",a,c);}}
class table extends HTMLament{table(String a, HTMLament ...c){super("table",a,c);}}
class head extends HTMLament{head(String a, HTMLament ...c){super("head",a,c);}}
class script extends HTMLament{script(String a, HTMLament ...c){super("script",a,c);}}
class div extends HTMLament{div(String a, HTMLament ...c){super("div",a,c);}}
class p extends HTMLament{p(String a, HTMLament ...c){super("p",a,c);}}
class title extends HTMLament{title(String a, HTMLament ...c){super("title",a,c);}}
package Reimbursement;

public class html {
	protected String tag;
	protected String attributes;
	protected String innertext;
	protected html[] children;
	
	public html(String a, String i, html ...c){
		attributes = a;
		children = c;
		innertext = i;
		tag = "html";
	}
	
	protected html(String t, String a, String i, html ...c) {
		attributes = a;
		children = c;
		innertext = i;
		tag = t;
	}
	
	public String write() {
		String s = String.format("<%s %s>%s", tag, attributes, innertext);
		for(int i = 0; i < children.length; i++) s += (children[i]==null)?"NULL":children[i].write();
		return String.format("%s</%s>\n", s, tag);
	}
	
}

class body extends html{body(String a, String i, html ...c){super("body",a,i,c);}}
class form extends html{form(String a, String i, html ...c){super("form",a,i,c);}}
class input extends html{input(String a, String i, html ...c){super("input",a,i,c);}}
class button extends html{button(String a, String i, html ...c){super("button",a,i,c);}}
class table extends html{table(String a, String i, html ...c){super("table",a,i,c);}}
class head extends html{head(String a, String i, html ...c){super("head",a,i,c);}}
class script extends html{script(String a, String i, html ...c){super("script",a,i,c);}}
class div extends html{div(String a, String i, html ...c){super("div",a,i,c);}}
class p extends html{p(String a, String i, html ...c){super("p",a,i,c);}}
class title extends html{title(String a, String i, html ...c){super("title",a,i,c);}}
class h1 extends html{h1(String a, String i, html ...c){super("h1",a,i,c);}}
class h2 extends html{h2(String a, String i, html ...c){super("h2",a,i,c);}}
class h3 extends html{h3(String a, String i, html ...c){super("h3",a,i,c);}}
class h4 extends html{h4(String a, String i, html ...c){super("h4",a,i,c);}}
class thead extends html{thead(String a, String i, html ...c){super("thead",a,i,c);}}
class tr extends html{tr(String a, String i, html ...c){super("tr",a,i,c);}}
class td extends html{td(String a, String i, html ...c){super("td",a,i,c);}}
class th extends html{th(String a, String i, html ...c){super("th",a,i,c);}}
class hr extends html{hr(String a, String i, html ...c){super("hr",a,i,c);}}
class select extends html{select(String a, String i, html ...c){super("select",a,i,c);}}
class option extends html{option(String a, String i, html ...c){super("option",a,i,c);}}
class textarea extends html{textarea(String a, String i, html ...c){super("textarea",a,i,c);}}
class br extends html{br(String a, String i, html ...c){super("br",a,i,c);}}
class style extends html{style(String a, String i, html ...c){super("style",a,i,c);}}



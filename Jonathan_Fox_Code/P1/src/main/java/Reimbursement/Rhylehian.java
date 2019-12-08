package Reimbursement;

import java.util.Random;

public class Rhylehian {	
	public static final int WELCOME = 10;
	public static final int LOGIN = WELCOME+1;
	public static final int REGISTER_TICKET = LOGIN+1;
	public static final int REGISTRATION = REGISTER_TICKET+1;
	public static final int REGISTER_USER = REGISTRATION+1;
	public static final int SET_STATUS = REGISTER_USER+1;
	public static final int HOME = SET_STATUS+1;
	
	private static final String words[] = { "ah", "'ai", "athg", "'bthnk", "bug", "ch'", "chtenff", "ebumna", "ee",
			"ehye", "ep", "'fhalma", "fhtagn", "fm'latgh", "geb", "gnaiih", "gof'nn", "goka", "gotha", "grah'n",
			"hafh'drn", "hai", "hlirgh", "hrii", "hupadgh", "ilyaa", "k'yarnak", "kn'a", "li'hee", "lloig", "lw'nafh",
			"mnahn'", "n'gha", "n'ghft", "nglui", "nilgh'ri", "nog", "llll", "nw", "ooboshu", "orr'e", "phlegeth",
			"r'luh", "ron", "s'uhn", "sgn'wahl", "shagg", "shogg", "shtunggli", "shugg", "sll'ha", "stell'bsna",
			"syha'h", "tharanak", "throd", "uaaah", "uh'e", "uln", "vulgtlagln", "vulgtm", "wgah'n", "y'hah", "ya",
			"zhro" };
	private static final String prefixes[] = {"c","f'","h'","mg","ng","na","nafl","nnn","ph'","y"};
	private static final String suffixes[] = {"agl","nyth","og","or","oth","yar"};
	
	private static String word() {
		Random r = new Random();
				
		return (((r.nextInt() % 100) < 30) ? prefixes[(r.nextInt()&0x7fffffff) % prefixes.length] : "")
				+ words[(r.nextInt()&0x7fffffff) % words.length]
				+ (((r.nextInt() % 100) < 15) ? suffixes[(r.nextInt()&0x7fffffff) % suffixes.length] : "");
	}
	
	public static String incant(int num) {
		String s = word();
		
		for(int i = 1; i < num; i++) s = String.format("%s_%s", s, word());
		
		return s + ".fhtagn";
	}
	
	public static int interpret (String spell) { return spell.split("_").length; }
	
	public static void main(String[] args) {
		System.out.printf("%s\n", incant(15));
	}
}

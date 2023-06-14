package lab13execise6;


/*
 * @author muhammad izzat
 * this class to translate text from client to target language
 */
public class Translate {

	public static String translate(String word,String targetLanguage) {
		
		if(targetLanguage.equals("Arabic")) {
			
			return "صباح الخير";
		}
		else{
			
			return "The language is not available";
		}
		
	}
}
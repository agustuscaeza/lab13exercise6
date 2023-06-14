package lab13exercise6;



public class Translate {

	public static String Translator(int translateTo) {
		// TODO Auto-generated method stub
		if (translateTo == 1)
		{
		   String translatedWord =  "Ada apa?, " + "? ما أخبارك , " + "뭐야 ";
		   //return EnglishWord;
		   
		   /*String BahasaMalaysia = "Terima Kasih";
		   //return BahasaMalaysia;
		   
		   String Arabic = " شكرا لك";
		   //return Arabic;
		   
		   String Hangul = "감사합니다 ";
		   return  Hangul;*/
		   return translatedWord;
		} 
		/*if (translateTo == 2)
		{
		   String BahasaMalaysia = "Terima Kasih";
		   return BahasaMalaysia;
		}
		if (translateTo == 3)
		{
		   String Arabic = " شكرا لك";
		   return Arabic;
		}
		if (translateTo == 4)
		{
		   String Hangul = "감사합니다 ";
		   return Hangul;
		}*/
		else
		{
			return "The language is not available";
		}
	}
}

import JSHOP2.*;
import java.util.*;


public class CodeComple {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws TokenStreamException 
	 * @throws RecognitionException 
	 */
	public static void main(String[] args) 
	{
		 if (args.length==2&& args[0].equals("-r")) 
		 {
			 String[] s={"-r"+args[1].toString(),"E:/程序/Java/jshop2/src/JSHOP2/bin/problem"};
			 InternalDomain.Comples(s);
		 }
		 else if(args[0].equals("-ra"))
		 {
			 String[] s={"-ra","E:/程序/Java/jshop2/src/JSHOP2/bin/problem"};
			 InternalDomain.Comples(s);
		 }
		 else if(!args[0].contains("-r"))
		 {
			 String[] s1={"E:/程序/Java/jshop2/src/JSHOP2/bin/"+args[0]};
			 InternalDomain.Comples(s1);
		 }
		 else
		 {
			 String[] s={"-r","E:/程序/Java/jshop2/src/JSHOP2/bin/problem"};
			 InternalDomain.Comples(s);
		 }
	}
	
	
}

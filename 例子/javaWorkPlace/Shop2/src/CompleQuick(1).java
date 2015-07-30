import JSHOP2.InternalDomain;
import JSHOP2.*;
import java.util.*;

public class CompleQuick 
{
	public static void main(String[] args) 
	{
		args[0]="s";		 
		comple(args);
		args[0]="-r";
		comple(args);
	}
	
	static void comple(String[] args)
	{
		if (args.length==2&& args[0].equals("-r")) 
		 {
			 String[] s={"-r"+args[1].toString(),"E:/程序/Java/jshop2/src/JSHOP2/src/problem"};
			 InternalDomain.Comples(s);
		 }
		 else if(args[0].equals("-ra"))
		 {
			 String[] s={"-ra","E:/程序/Java/jshop2/src/JSHOP2/src/problem"};
			 InternalDomain.Comples(s);
		 }
		 else if(!args[0].contains("-r"))
		 {
			 String[] s1={"E:/程序/Java/jshop2/src/JSHOP2/src/"+"Flood_Evacuate"};
			 InternalDomain.Comples(s1);
		 }
		 else
		 {
			 String[] s={"-r","E:/程序/Java/jshop2/src/JSHOP2/src/problem"};
			 InternalDomain.Comples(s);
		 }		
	}
	
}

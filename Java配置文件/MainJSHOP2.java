import JSHOP2.*;

import java.io.File;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;

public class MainJSHOP2 
{
	public static void main(String[] args) throws ClassNotFoundException
	{
		//problem.getPlans();
		//WriteXMLtoDisk("E:/程序/Java/jshop2/src/JSHOP2/doc/jshopresult.xml");		
		
		String domain="logistics";
		
		/*delclass(domain);*/
		
		args=new String[1];
		args[0]="s";		 
		comple(args,domain);
		args[0]="-r";
		comple(args,domain);
		
	/*	Object obj;
		try {
			Class clazz=Class.forName("problem");
			obj = clazz.newInstance();
			Method method = clazz.getMethod("getPlans", new Class[0]);
	 		method.invoke(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		new JSHOP2GUI();*/
	}

	private static void comple(String[] args,String domain)
	{
		String runpath="E:/防洪应急项目/javaWorkPlace/Shop2/src/";
		if (args.length==2&& args[0].equals("-r")) 
		 {
			 String[] s={"-r"+args[1].toString(),runpath+ "problem"};
			 InternalDomain.Comples(s);
		 }
		 else if(args[0].equals("-ra"))
		 {
			 String[] s={"-ra",runpath+"Eproblem"};
			 InternalDomain.Comples(s);
		 }
		 else if(!args[0].contains("-r"))
		 {
			 String[] s1={runpath+domain};
			 InternalDomain.Comples(s1);
		 }
		 else
		 {
			 String[] s={"-r",runpath+"/problem"};
			 InternalDomain.Comples(s);
		 }		
	}
}

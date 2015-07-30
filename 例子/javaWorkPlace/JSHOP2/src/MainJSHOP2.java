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
		
		String domain="Flood_Evacuate";
		
		delclass(domain);
		
		args=new String[1];
		args[0]="s";		 
		comple(args,domain);
		args[0]="-r";
		comple(args,domain);
		
		Object obj;
		try {
			Class clazz=Class.forName("problem");
			obj = clazz.newInstance();
			Method method = clazz.getMethod("getPlans", new Class[0]);
	 		method.invoke(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		new JSHOP2GUI();
	}

	private static void comple(String[] args,String domain)
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
			 String[] s1={"E:/程序/Java/jshop2/src/JSHOP2/src/"+domain};
			 InternalDomain.Comples(s1);
		 }
		 else
		 {
			 String[] s={"-r","E:/程序/Java/jshop2/src/JSHOP2/src/problem"};
			 InternalDomain.Comples(s);
		 }		
	}
	
	private static void delclass(String domainname)
	{
		File f = null;
		File mydir=new File("E://程序//Java//jshop2//src//JSHOP2//bin");
		String[] ftps=mydir.list();		
		for (String name :ftps) {
			f = new File(name);
			if(f.isFile()){
				if(name.startsWith("Precondition")||name.startsWith("Operator")
						||name.startsWith("Method")||name.equals("problem.java")
						||name.startsWith("Axiom")||name.equals(domainname+".java")
						||name.equals("problem.class")||name.equals(domainname+".class"))
				{
					if(f.exists())
						f.delete();
				}
			}
		}
	}
	
	//private static void WriteXMLtoDisk(String filename) 
	//{
		//try
		//{
		//	WriteXML myxml=new WriteXML(filename);
		//	LinkedList<Plan> plans= JSHOP2.getPlans();
         //   int plans_size=plans.size();
           // String[] plans_result=new String[plans_size];
            //for(int i=0;i<plans_size;i++)
            //{
            	//plans_result[i]=plans.get(i).toString();
            //}
            
			//myxml.toWrite(plans_size,plans_result);
			//myxml.toSave();
			//System.out.print("Your writing is successful.");
		//}
		//catch(ParserConfigurationException exp)
		//{
		//	exp.printStackTrace();
		//	System.out.print("Your writing is failed.");
		//}		
	//} 
}

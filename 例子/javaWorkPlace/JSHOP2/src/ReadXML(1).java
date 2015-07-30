import java.io.*; 
import java.util.Vector; 
import javax.xml.parsers.*; 
import org.w3c.dom.*; 

public class ReadXML 
{
	static Document document; 
	private boolean validating; 
	
	public ReadXML() 
	{ 
		;
	} 
	
	public Vector toRead(String filename) 
	{ 
		Vector title=new Vector(); 
		Vector content=new Vector(); 
		String myStr=new String(); 
		try 
		{ 
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
			factory.setValidating(validating); 
			DocumentBuilder builder = factory.newDocumentBuilder(); 
			document = builder.parse(new File(filename)); 
			document.getDocumentElement().normalize(); 
			Node node = document.getFirstChild(); 
			NodeList list = node.getChildNodes(); 
			for (int i = 0; i < list.getLength(); i++) 
			{ 
				Node nodeitm = list.item(i); 
				if (nodeitm.getNodeName().equals("Title"))
				{ 
					myStr=nodeitm.getFirstChild().getNodeValue(); 
					title.addElement(myStr);//getFirstChild() 
				} 
				if (nodeitm.getNodeName().equals("Content"))
				{ 
					myStr=nodeitm.getFirstChild().getNodeValue(); 
					content.addElement(myStr); 
				} 
			} 
		} 
		catch (Exception exp) 
		{ 
			exp.printStackTrace(); 
			return null; 
		} 
		Vector all=new Vector(); 
		all.add(title); 
		all.add(content); 
		return all; 
	} 
	
	public static void main(String[] args) 
	{ 
		Vector A; 
		ReadXML my = new ReadXML(); 
		A = my.toRead("E:/³ÌÐò/Java/jshop2/src/JSHOP2/doc/1.xml"); 
		for (int i = 0; i < A.size(); i++)
		{ 
			System.out.println(A.elementAt(i)); 
		} 
	} 
} 


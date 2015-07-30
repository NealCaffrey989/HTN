import org.w3c.dom.*; 
import javax.xml.parsers.*; 
import javax.xml.transform.*; 
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult; 
import java.io.*;

public class WriteXML 
{
	private Document document;
	private String filename;
	
	public WriteXML(String name) throws ParserConfigurationException
	{
		filename=name;
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		document=builder.newDocument();
	}
	
	public void toWrite(int size,String[] mycontent)
	{
		Element root=document.createElement("WorkShop");
		document.appendChild(root);
		Element title=document.createElement("Size");
		title.appendChild(document.createTextNode(size+""));
		root.appendChild(title);
		for(int i=0;i<size;i++)
		{
			Element content=document.createElement("Content"+i);
			content.appendChild(document.createTextNode(mycontent[i]));
			root.appendChild(content);
		}
	}
	
	public void toSave()
	{
		try
		{
			TransformerFactory tf=TransformerFactory.newInstance();
			Transformer transformer=tf.newTransformer();
			DOMSource source=new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.ENCODING,"GB2312");
			transformer.setOutputProperty(OutputKeys.INDENT,"yes");
			PrintWriter pw=new PrintWriter(new FileOutputStream(filename));
			StreamResult result=new StreamResult(pw);
			transformer.transform(source,result);
		}
		catch(TransformerException mye)
		{
			mye.printStackTrace();
		}
		catch(IOException exp)
		{
			exp.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		try
		{
			WriteXML myxml=new WriteXML("E:/程序/Java/jshop2/src/JSHOP2/doc/1.xml");
			String[] s={"中文内容","中文"};
			myxml.toWrite(2,s);
			myxml.toSave();
			System.out.print("Your writing is successful.");
		}
		catch(ParserConfigurationException exp)
		{
			exp.printStackTrace();
			System.out.print("Your writing is failed.");
		}
	}
} 

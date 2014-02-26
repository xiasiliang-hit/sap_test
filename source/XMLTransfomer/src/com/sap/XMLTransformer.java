/* This command line tool is for formatting an XML file into certain html page for tracking 
 *		error message, as required by SAP AG
 * Author: Siliang
 * Time: 2014-02-26
 * Remarks: 
 */


package com.sap;

import java.io.*;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class XMLTransformer
{

	public XMLTransformer()
	{}

	private void transform()
	{

		Source xmlInput = new StreamSource(new File(temp));
		Source xslInput = new StreamSource(new File(xsl));

		try
		{
			Result xmlOutput = new StreamResult(new File(outStr));

			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer(xslInput);
			transformer.transform(xmlInput, xmlOutput);

			System.out.println(outStr + " has been generated successfully！");
		}
		catch (TransformerException e)
		{
			new File(outStr).delete();
			System.out.println("EeceptionCode:1, XML file not well formated");
			

		}
		catch (Exception e)
		{
			new File(outStr).delete();
			System.out.println("EeceptionCode:2, Unknown exception");
			
		}
		finally
		{
			new File(temp).delete();
			terminate();
			
		}
	}

	//replace "\r\n" with blank, generate a temp.xml
	private void preprocess(String xml)
	{
		BufferedReader br = null;

		try
		{
			br = new BufferedReader(new FileReader(xml));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null)
			{
				sb.append(line);
				// sb.append(System.lineSeparator());
				line = br.readLine();
			}
			br.close();

			String str = sb.toString();
			String reStr = str.replace("\\r\\n", " ");
			
			// System.out.println(reStr);
			PrintWriter writer = new PrintWriter(temp, "UTF-8");
			writer.write(reStr);

			writer.close();

			System.out.println("\\r\\n has been replaced");
		}
		catch (Exception e)
		{
			dealNoFileException();
		}
		finally
		{}
	}

	//deal with no file exception
	static private void dealNoFileException()
	{
		System.out.println("ExceptionCode:0, XML file not found");
		System.out
				.println("Please run applicaiton with parameter [your xml file name with path]\n"
						+ "eg: /data/sample.xml or ./tmp/sample.xml");
		terminate();
	}

	//program enterance
	static public void main(String[] args)
	{
		if (DEBUG_MODE)
		{
			xml = "style/2.xml"; //set the path without parameter in debug mode
		}
		else
		{
			try
			{
				xml = args[0];
			} catch (java.lang.ArrayIndexOutOfBoundsException e)
			{
				dealNoFileException();
			}
		}

		XMLTransformer t = new XMLTransformer();
		t.preprocess(xml);
		t.transform();
	}
	
	//terminate the program gracefully without printing exception stack  
	static private void terminate()
	{
		System.out.println("Program will terminate now...");
		System.exit(0);
	}

	static private String xml = "style/2.xml";
	private String xsl = "style/sap_style.xsl";
	private String temp = "temp.xml";
	private String outStr = "outxml.html";

	public static final boolean DEBUG_MODE = false;
}
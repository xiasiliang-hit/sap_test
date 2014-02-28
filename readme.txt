--introduction--
		This command line tool sap.jar is for formatting an XML file
		into certain html page for tracking error message, as required by SAP AG
		Author: Siliang
		Time: 2014-02-26
		Remarks:

--contribution--
		./sap.jar:
		java package providing command line
		interface for formatting the xml file with provided
		xml stylesheet. it has two interesting features:
				
		it replaces the \r\n newline generated in
		Windows with blank so that the message in
		the xml file can be better readable without
		noise characters 
				
		it also checks the foramt of XML file before
		formatting, reports error if the XML file is not
		well formatted

		./style/sap_style.xsl:
		xml stylesheet for formatting xml files into readable html pages
--system requirement--
		Java Running Evironment 1.6 is required
--installation--
		No installation is need
--usage--
		please run the jar package in Linux shell using command line as bellow:

		$ java -cp [path to sap.jar]/sap.jar com.sap.XMLTransformer [your xml file name with path] 

		eg:
		assume current directory is sap_test, then type following statement in shell to perform 
		a transformation for the sample.xml in sap_test/test/
 
		$ java -cp sap.jar com.sap.XMLTransformer ./test/sample.xml

		if the xml file is well formatted, then the
		outxml.html is generated in the directory where the command runs
		
		then you can type following statement to check the generate html page in Firefox
		$ Firefox outxml.html

--exceptions--
		Two exceptions are defined, here is the exception code for reference:
		0: xml file is not found, please check your xml file again
		1: xml document is not formatted, please input a formatted xml file		

--known bugs--
		no bugs have been reported

--contact--
		if you have any problems with this tool, please contact:
		xiaisliang.str@gmail.com

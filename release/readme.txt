--introduction--
		This command line tool is for formatting an XML file into certain html page for tracking error message, as required by SAP AG
		Author: Siliang
		Time: 2014-02-26
		Remarks:

--contribution--
		./sap.jar:
		java package which provide command line
		interface for formmatiing the xml file with provided
		xml stylesheet
		it has two interesting features
				
		it replaces the \r\n newline generated in
		Windows with blank so that the message in
		the xml file can be better readable without
		noise characters 
				
		it also checks the foramt of XML file before
		formatting, reprots error if the XML file is not
		well formatted

		./sap_style.xsl:
		xml stylesheet for formmating xml files into readable html with structure tables
		
--installation--
		git clone https://xiasiliang-hit/sap_test
		cd ./sap_test

--usage--
		please run the jar package in Linux shell or Windows cmd window using command
		line as bellow:

		$java -cp sap.jar com.sap.XMLTransformer [your xml file name with path] 

		eg:
		under *inux with shell
		$java -cp sap.jar com.sap.XMLTransformer ~/path/sample.xml

		under windows
		$java -cp sap.jar com.sap.XMLTransformer  C://path/sample.xml

		if the xml file is well formatted, then the
		outxml.html is generated as the human readable representation 
				
--known bugs--
		no bugs have been reported

--contact--
		if you encount any bug or have other issues with
		this tool, please contact:
		xiaisliang.str@gmail.com 

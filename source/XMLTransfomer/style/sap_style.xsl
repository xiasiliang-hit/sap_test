<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:spr="http://www.sap.com/spr">
	<xsl:template match="/">
		<html>

			<head>
				<style type="text/css">
					.caption {font-size: 20px;}
					table, th, td
					{
					border: 1px solid #CCC;
					}
				</style>
			</head>
			
			<body>
				<table>
					<h1 class="caption">Structured Attributes
					</h1>
					<xsl:for-each select="//Error">

					</xsl:for-each>
					<tr>
						<td rowspan="8">
							BackendProcessingFailedException
						</td>
					</tr>

					<xsl:for-each select="//Error">
						<tr>
							<td>IsFatalException</td>
							<td>
								<xsl:value-of select=".//IsFatalException" />
							</td>
						</tr>

						<tr>
							<td>TransactionID</td>
							<td>
								<xsl:value-of select="TransactionID" />
							</td>
						</tr>

						<tr>
							<td>SessionState</td>
							<td>
								<xsl:value-of select=".//SessionState" />
							</td>
						</tr>

						<tr>
							<td>Message</td>
							<td>
								<xsl:value-of select="MessageText" />
							</td>
						</tr>

						<tr>
							<td>Data</td>
							<td>
								<xsl:value-of select=".//Data" />
							</td>
						</tr>

						<tr>
							<td>InnerException</td>
							<td>
								<xsl:value-of select=".//InnerException" />
							</td>
						</tr>

						<tr>
							<td>StackTrace</td>
							<td>
								<xsl:value-of select=".//StackTrace" />
							</td>
						</tr>
					</xsl:for-each>
				</table>

				<table>
					<h1 class="caption">Sub-Check Results
					</h1>
					<tr>
						<th>Status</th>
						<th>Label</th>
						<th>Summary</th>
					</tr>

					<xsl:for-each select="//Exception">
						<tr>
							<td>Info</td>
							<td>
								Level <xsl:value-of select="@Level" />: 
								
								Type <xsl:value-of select="@Type" />
							</td>
							<td>
								<xsl:value-of select="Message" />
							</td>
						</tr>
					</xsl:for-each>
					
				</table>
			</body>
			
		</html>
	</xsl:template>
</xsl:stylesheet>


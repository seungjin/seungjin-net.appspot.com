<?xml version="1.0" encoding="utf-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" version="1.0" doctype-public="-//W3C//DTD XHTML 1.1//EN" doctype-system="http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd" indent="yes" encoding="utf-8" />
<xsl:template match="/">
    <xsl:apply-templates />
</xsl:template>

<xsl:template match="seungjin">



<html>
<head>
<title>SEUNG-JIN KIM</title>
<META name="ROBOTS" content="NOINDEX"/>
<!-- Copyright (C) 2005 seungjin.net -->
	<style type="text/css">

		body {
			color: #666666;
			font-family: Seoul, Georgia, Times New Roman, Times, serif ;
			font-size: 12px;
			margin-top:2px;
			margin-bottom:2px;
			margin-left:30px;
			margin-right:2px
			a:link    { color: #666666; text-decoration:none }
			a:active  { color: #666666; text-decoration:none }
			a:visited { color: #666666; text-decoration:none }
			a:hover   { color: #CCCCCC; text-decoration:none }
			}

	</style>
</head>

<body bgcolor='white'>

<xsl:for-each select="content"><br/>


+<xsl:value-of select="date"/> [<xsl:value-of select="category"/>]<br/>
<xsl:value-of select="comment"/><xsl:text></xsl:text>
<xsl:if test="ref!=''"><xsl:text></xsl:text><sup><font style='size:9px;'><a><xsl:attribute name="href"><xsl:value-of select="ref"/></xsl:attribute><xsl:text>more</xsl:text></a></font></sup></xsl:if><br/>
</xsl:for-each>

</body>

</html>

</xsl:template></xsl:stylesheet>

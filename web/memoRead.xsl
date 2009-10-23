<?xml version="1.0" ?>
<xsl:stylesheet version="1.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >

<!-- / forward slash is used to denote a patern that matches the root node of the XML document -->
<xsl:template match ="/" >
    <html>
      <head>
        <title> -- </title>
        <META name="ROBOTS" content="NOINDEX"/>
            <style type="text/css">

		body {
			color: #666666;
			font-family: Seoul, Georgia, Times New Roman, Times, serif ;
			font-size: 12px;
			margin-top:2px;
			margin-bottom:2px;
			margin-left:5px;
			margin-right:5px
			a:link    { color: #666666; text-decoration:none }
			a:active  { color: #666666; text-decoration:none }
			a:visited { color: #666666; text-decoration:none }
			a:hover   { color: #CCCCCC; text-decoration:none }
		}

                pre {
                    white-space: pre-wrap;       /* css-3 */
                    white-space: -moz-pre-wrap;  /* Mozilla, since 1999 */
                    white-space: -pre-wrap;      /* Opera 4-6 */
                    white-space: -o-pre-wrap;    /* Opera 7 */
                    word-wrap: break-word;       /* Internet Explorer 5.5+ */
                }


            </style>
      </head>
      <body>
        <xsl:apply-templates />
      </body>
    </html>
</xsl:template>

<xsl:template match="memos" >
    <table width="100%" border="1" >
        <tr bgcolor = "#cccccc" >
            <td>Date/Time</td>
            <td>Memo</td>
        </tr>
<xsl:for-each select="memo" >
        <tr>
            <td> <xsl:value-of select="date" /> </td>
            <td><pre> <xsl:value-of select="memo" /> </pre></td>
        </tr>
</xsl:for-each>
     </table>
</xsl:template >
</xsl:stylesheet >
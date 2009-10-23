<?xml version="1.0" ?>
<xsl:stylesheet version="1.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >

<!-- / forward slash is used to denote a patern that matches the root node of the XML document -->
<xsl:template match ="/" >
    <html>
      <head>
        <title> -- </title>
        <META name="ROBOTS" content="NOINDEX"/>
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
            <td> <xsl:value-of select="memo" /> </td>
        </tr>
</xsl:for-each>
     </table>
</xsl:template >
</xsl:stylesheet >
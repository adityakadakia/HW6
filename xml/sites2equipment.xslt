<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
			</head>
			<body>
				<ol>
					<xsl:for-each select="siteDatabase/site/tower/equipment">
						<li>
							Equipment:
							<xsl:value-of select="@id" />
						</li>
						<ul>
							<li>
								Site/Tower: Site
								<xsl:value-of select="../../@id" />
								/
								<xsl:value-of select="../@name" />
							</li>
						</ul>
					</xsl:for-each>
				</ol>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
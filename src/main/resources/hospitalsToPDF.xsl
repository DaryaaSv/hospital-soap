<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">

    <xsl:template match="/">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="simpleA4"
                                       page-height="29.7cm" page-width="21.0cm" margin-top="2cm"
                                       margin-bottom="2cm" margin-left="2.5cm" margin-right="2.5cm">
                    <fo:region-body />
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="simpleA4">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="16pt" font-weight="bold">
                        <xsl:value-of select="/hospital/hospitalName" />
                    </fo:block>
                    <fo:block font-size="14pt" font-weight="bold">
                        <xsl:value-of select="/hospital/type" />
                    </fo:block>
                    <fo:block font-size="12pt" margin-top="1cm">
                        Address: <xsl:value-of select="/hospital/address" />
                    </fo:block>
                    <fo:block font-size="12pt">
                        Phone number: <xsl:value-of select="/hospital/phoneNumber" />
                    </fo:block>
                    <fo:block font-size="14pt" font-weight="bold" margin-top="2cm">
                        Doctors:
                    </fo:block>
                    <fo:table margin-top="0.5cm" margin-bottom="0.5cm">
                        <fo:table-column column-width="auto" />
                        <fo:table-column column-width="auto" />
                        <fo:table-column column-width="auto" />
                        <fo:table-column column-width="auto" />
                        <fo:table-column column-width="auto" />
                        <fo:table-header>
                            <fo:table-row>
                                <fo:table-cell border="solid 1px black" padding="5pt">
                                    <fo:block font-weight="bold">ID</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 1px black" padding="5pt">
                                    <fo:block font-weight="bold">Name</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 1px black" padding="5pt">
                                    <fo:block font-weight="bold">Specialty</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 1px black" padding="5pt">
                                    <fo:block font-weight="bold">Phone</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 1px black" padding="5pt">
                                    <fo:block font-weight="bold">Salary</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>
                        <fo:table-body>
                            <xsl:apply-templates select="/hospital/doctors/doctor" />
                        </fo:table-body>
                    </fo:table>
                    <fo:block font-size="14pt" font-weight="bold" margin-top="2cm">
                        Equipment:
                    </fo:block>
                    <fo:table margin-top="0.5cm" margin-bottom="0.5cm">
                        <fo:table-column column-width="auto" />
                        <fo:table-column column-width="auto" />
                        <fo:table-column column-width="auto" />
                        <fo:table-column column-width="auto" />
                        <fo:table-column column-width="auto" />
                        <fo:table-header>
                            <fo:table-row>
                                <fo:table-cell border="solid 1px black" padding="5pt">
                                    <fo:block font-weight="bold">ID</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 1px black" padding="5pt">
                                    <fo:block font-weight="bold">Name</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 1px black" padding="5pt">
                                    <fo:block font-weight="bold">Model number</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 1px black" padding="5pt">
                                    <fo:block font-weight="bold">Manufacturer</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 1px black" padding="5pt">
                                    <fo:block font-weight="bold">Location</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>
                        <fo:table-body>
                            <xsl:apply-templates select="/hospital/equipments/equipment" />
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

    <xsl:template match="/hospital/doctors/doctor">
        <fo:table-row>
            <fo:table-cell border="solid 1px black" padding="5pt">
                <fo:block><xsl:value-of select="id" /></fo:block>
            </fo:table-cell>
            <fo:table-cell border="solid 1px black" padding="5pt">
                <fo:block><xsl:value-of select="concat(firstName, ' ', surname)" /></fo:block>
            </fo:table-cell>
            <fo:table-cell border="solid 1px black" padding="5pt">
                <fo:block><xsl:value-of select="specialty" /></fo:block>
            </fo:table-cell>
            <fo:table-cell border="solid 1px black" padding="5pt">
                <fo:block><xsl:value-of select="phoneNumber" /></fo:block>
            </fo:table-cell>
            <fo:table-cell border="solid 1px black" padding="5pt">
                <fo:block><xsl:value-of select="salary" /></fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>

    <xsl:template match="/hospital/equipments/equipment">
        <fo:table-row>
            <fo:table-cell border="solid 1px black" padding="5pt">
                <fo:block><xsl:value-of select="id"/></fo:block>
            </fo:table-cell>
            <fo:table-cell border="solid 1px black" padding="5pt">
                <fo:block><xsl:value-of select="name"/></fo:block>
            </fo:table-cell>
            <fo:table-cell border="solid 1px black" padding="5pt">
                <fo:block><xsl:value-of select="modelNumber"/></fo:block>
            </fo:table-cell>
            <fo:table-cell border="solid 1px black" padding="5pt">
                <fo:block><xsl:value-of select="manufacturer"/></fo:block>
            </fo:table-cell>
            <fo:table-cell border="solid 1px black" padding="5pt">
                <fo:block><xsl:value-of select="location"/></fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>
        </xsl:stylesheet>
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:svg="http://www.w3.org/2000/svg"
                exclude-result-prefixes="svg">

    <xsl:template match="/">
        <html>
            <head>
                <title><xsl:value-of select="/hospital/hospitalName"/></title>
            </head>
            <body>
                <div>
                <center>

                    <h1><xsl:value-of select="/hospital/hospitalName"/></h1>
                    <div style="float: left; width: 50%;">
                        <h2>Hospital Information</h2>
                        <table border="1">
                            <tr>
                                <th bgcolor="#d4e4ed">ID</th>
                                <td><xsl:value-of select="/hospital/id"/></td>
                            </tr>
                            <tr>
                                <th bgcolor="#d4e4ed">Type</th>
                                <td><xsl:value-of select="/hospital/type"/></td>
                            </tr>
                            <tr>
                                <th bgcolor="#d4e4ed">Address</th>
                                <td><xsl:value-of select="/hospital/address"/></td>
                            </tr>
                            <tr>
                                <th bgcolor="#d4e4ed">Phone Number</th>
                                <td><xsl:value-of select="/hospital/phoneNumber"/></td>
                            </tr>
                        </table>
                    </div>


                    <div style="float: right; width: 50%;">
                        <img src="src/main/resources/hospital-svgrepo-com.svg"/>
                    </div>
                </center>
        </div>


                <div style="text-align: center; width: 100%; display: flex; justify-content: center;">
                <table border="1" >
                    <tr bgcolor="#8db4ad">
                        <td colspan="7" style="text-align: center;"><h1><strong>Doctors:</strong></h1></td>
                    </tr>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Surname</th>
                        <th>Phone Number</th>
                        <th>Specialty</th>
                        <th>Salary</th>
                        <th>Appointments</th>
                    </tr>
                    <xsl:for-each select="/hospital/doctors/doctor">
                        <tr bgcolor="#cddddc">
                            <td><xsl:value-of select="id"/></td>
                            <td><xsl:value-of select="firstName"/></td>
                            <td><xsl:value-of select="surname"/></td>
                            <td><xsl:value-of select="phoneNumber"/></td>
                            <td><xsl:value-of select="specialty"/></td>
                            <td><xsl:value-of select="salary"/></td>
                            <td>
                                <ul>
                                    <xsl:for-each select="appointments/appointment">
                                        <li>
                                            <strong>Appointment ID: </strong> <xsl:value-of select="id"/> |
                                            <strong>Date: </strong> <xsl:value-of select="date"/> |
                                            <strong>Type: </strong> <xsl:value-of select="type"/> |
                                            <strong>Result: </strong> <xsl:value-of select="result"/>
                                            <br/><br/>
                                            <strong>Patient: </strong>
                                            <ul>
                                                <li>
                                                    <strong>ID: </strong> <xsl:value-of select="patient/id"/>
                                                </li>
                                                <li>
                                                    <strong>Name: </strong> <xsl:value-of select="patient/firstName"/> <xsl:value-of select="patient/surname"/>
                                                </li>
                                                <li>
                                                    <strong>Age: </strong> <xsl:value-of select="patient/age"/>
                                                </li>
                                                <li>
                                                    <strong>Phone Number: </strong> <xsl:value-of select="patient/phoneNumber"/>
                                                </li>
                                                <li>
                                                    <strong>Email: </strong> <xsl:value-of select="patient/email"/>
                                                </li>
                                                <li>
                                                    <strong>Hospital Room: </strong>
                                                    <ul>
                                                        <li>
                                                            <strong>ID: </strong> <xsl:value-of select="patient/hospitalRoom/id"/>
                                                        </li>
                                                        <li>
                                                            <strong>Type: </strong> <xsl:value-of select="patient/hospitalRoom/type"/>
                                                        </li>
                                                        <li>
                                                            <strong>Capacity: </strong> <xsl:value-of select="patient/hospitalRoom/capacity"/>
                                                        </li>
                                                        <li>
                                                            <strong>Floor: </strong> <xsl:value-of select="patient/hospitalRoom/floor"/>
                                                        </li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </li>
                                    </xsl:for-each>
                                </ul>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
                    </div>

            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>







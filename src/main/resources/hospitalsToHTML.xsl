<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:svg="http://www.w3.org/2000/svg"
                exclude-result-prefixes="svg">

    <xsl:template match="/">
        <html>
            <head>
                <title><xsl:value-of select="/hospital/hospitalName"/></title>
                <style>
                    .pdf-button {
                    font-family: Arial, sans-serif; /* Change to your desired font */
                    font-size: 20px; /* Adjust the size as needed */
                    color: white; /* Change the text color */
                    background-color: #8db4ad; /* Change the button color */
                    border: none;
                    padding: 15px 32px;
                    text-align: center;
                    text-decoration: none;
                    display: inline-block;
                    margin: 0 auto;
                    display: block;
                    }
                </style>
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
                        <svg fill="#194569" version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                             viewBox="0 0 229.957 229.957" xml:space="preserve"
                             width="200" height="200">
                        <g>
                            <g>
                                <g>
                                    <path d="M104.706,129.12h24.242v-16.162h16.162V88.715h-16.162V72.554h-24.242v16.162H88.544v24.242h16.162V129.12z
                                         M96.625,104.877v-8.081h16.162V80.635h8.081v16.162h16.161v8.08h-16.162v16.162h-8.081v-16.162H96.625z"/>
                                    <rect x="23.897" y="137.2" width="28.283" height="8.081"/>
                                    <rect x="23.897" y="153.362" width="28.283" height="8.081"/>
                                    <rect x="23.897" y="169.523" width="28.283" height="8.081"/>
                                    <rect x="177.433" y="137.2" width="28.283" height="8.081"/>
                                    <rect x="177.433" y="153.362" width="28.283" height="8.081"/>
                                    <rect x="177.433" y="169.523" width="28.283" height="8.081"/>
                                    <path d="M221.877,197.807L221.877,197.807v-76.768h-52.525V32.15h20.202v-8.081h-20.202H60.261H40.059v8.081h20.202v88.889H7.736
                                        v76.768H0v8.081h7.736h52.525h8.081h24.242h44.444h24.242h8.081h52.525h8.081v-8.081H221.877z M60.261,197.806H15.817v-68.687
                                        h44.444V197.806z M128.948,197.806h-28.283v-32.323h28.283V197.806z M161.271,121.039v76.768h-24.242v-0.001v-40.404H92.584
                                        v40.404H68.342v-76.767V32.15h92.929V121.039z M213.796,197.806h-44.444v-68.687h44.444V197.806z"/>
                                </g>
                            </g>
                        </g>
                        </svg>
                    </div>
                </center>
        </div>


                <div style="width: 100%; display: flex; justify-content: center;">
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
                <br></br>
                <div style="text-align: center;">
                    <button onclick="location.href='http://localhost:1060/convertToPDF'" type="button" class="pdf-button">Convert to PDF</button>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>







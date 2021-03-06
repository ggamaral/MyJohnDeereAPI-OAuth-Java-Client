# MyJohnDeereAPI-OAuth-Java-Client

## System Requirments
Download Java JDK 1.7 or higher, set the JAVA_HOME variable, adjust memory settings, and download and install Apache Maven.

#### Set the JAVA_HOME Variable:
<ol>
  <li>Right-click the <b>My Computer</b> icon on your desktop and select <b>Properties</b>.</li>
  <li>Click the <b>Advanced</b> tab.</li>
  <li>Click the <b>Environment Variables</b> button.</li>
  <li>Under System Variables, click <b>New</b>.</li>
  <li>Enter the variable name as JAVA_HOME.</li>
  <li>Enter the variable value as the installation path for the Java Development Kit.
    <ul class="doc">
      <li>
        If your Java installation directory has a space in its path name, you should use the shortened path name 
        (e.g. C:\Progra~1\Java\jdk1.7.0_25\jre) in the environment variable instead.
      </li>
      <li>Note for Windows users on 64-bit systems:
        <ul class="doc">
          <li>Progra~1 = 'Program Files'</li>
          <li>Progra~2 = 'Program Files(x86)' </li>
        </ul>
      </li>
    </ul>
  </li>
  <li>Click <b>OK</b> and then click <b>Apply Changes</b>.</li>
  <li>
    Close any command windows that were open before you made these changes and open a new command window.
    There is no way to reload environment variables from an active command prompt.
    If the changes do not take effect after reopening the command window, restart Windows.
  </li>
  <li>Run the command. You will see the following on the screen:</li>
</ol>

> java version "1.7.0_67" <br>
> Java(TM) SE Runtime Environment (build 1.7.0_67-b01)<br>
> Java HotSpot(TM) 64-Bit Server VM (build 24.65-b04, mixed mode)



#### Adjust memory settings to increase available Java memory or a fix a "Perm Gen Out of Memory" issue:
<ol>
  <li>Right-click the <b>My Computer</b> icon on your desktop and select <b>Properties</b>.</li>
  <li>Click the <b>Advanced</b> tab.</li>
  <li>Click the <b>Environment Variables</b> button.</li>
  <li>Under System Variables, click <b>New</b>.</li>
  <li>Enter the variable name JAVA_OPTS</li>
  <li>Enter the variable value as <b>-Xmx1024m -XX:MaxPermSize=512m</b></li>
  <li>Click <b>OK</b> and then click <b>Apply Changes</b>.</li>
</ol>

#### Download & Install Apache Maven
<ol>
  <li>Download and Install at least version 3.2 of Maven.</li>
  <li>
    Unzip the distribution archive (i.e. apache-maven-3.0.5-bin.zip) to the directory you wish to install Maven 3.0.5.
    These instructions assume you chose C:\maven\.
  </li>
  <li>Right-click the <b>My Computer</b> icon on your desktop and select <b>Properties</b>.</li>
  <li>Click <b>Advanced System Settings</b>, and then click on <b>Environment Variables</b>.</li>
  <li>Add the following new system variables:</li>
</ol>

<table class="myTable" width="100%" border="0" cellspacing="1" cellpadding="0">
  <tbody>
    <tr class="sectionTitle">
      <td>Name</td>
      <td>Value</td>
    </tr>
    <tr>
      <td>M2_HOME</td>
      <td>&lt;path to maven root dir; eg c:\maven\&gt;</td>
    </tr>
    <tr>
      <td>M2</td>
      <td>%M2_HOME%\bin</td>
    </tr>
    <tr>
      <td>MAVEN_OPTS</td>
      <td>-Xms512m -Xmx1024m -XX:PermSize=256m -XX:MaxPermSize=512m -Xss10m</td>
    </tr>
  </tbody>
</table>

Edit the <b>path</b> environmental variable and add the M2 var to it: <b>...;%M2%;</b>.
Then open a terminal and run <b>mvn --version</b> to verify the installation.

> Apache Maven 3.0.5 (r01de14724cdef164cd33c7c8c2fe155faf9602da;<br>
> Maven home: C:\maven\apache-maven-3.0.5<br>
> Java version: 1.7.0_67, vendor: Oracle Corporation<br>
> Java home: C:\Program Files\Java\jdk1.7.0_67\jre<br>
> Default locale: en_US, platform encoding: Cp1252<br>
> OS name: "windows 7", version: "6.1", arch: "amd64", family: "windows"

#### Set up and run the sample app:
<ol>
  <li>Copy the App ID and Shared secret of your App from developer.deere.com to CLIENT variable in                  ApiCredentials.java.
  </li>
  <li>Run the command <b>mvn clean compile test install package</b> to clean, compile, test, install and           package the code.
  </li>
  <li>
    Run the command <b>mvn exec:java -Dexec.mainClass="com.deere.democlient.GetOAuthToken"</b>
  </li>
  <li>The system will then show this message:</li>
</ol>

> Please provide the verifier from https://my.deere.com/consentToUseOfData?oauth_token={the request token generated by the given App Id and Secret in the Get Oauth Token code}

Copy the URL to a browser and login to MyJohnDeere using your MyJohnDeere username and password.
The browser will then display the <b>Verifier Code</b>

Copy the verifier code just below the system message in the command prompt and hit "Enter". This will generate the oAuth token and secret, as shown below:

> Token: {a token}<br>Token Secret: {a token secret}
        	
Copy this token and secret and pass it as a constructor argument to 
<b>OAuthToken TOKEN = new OAuthToken("a token ", " a token secret ");</b> in the ApiCredentials class.
Then run the command to build Maven again:

> mvn package<br>

You can run the partnerships class using the below command:

>mvn exec:java -Dexec.mainClass="com.deere.democlient.apis.Partnerships"  

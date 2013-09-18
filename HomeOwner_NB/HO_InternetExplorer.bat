@echo ON
CD %CD%



"S:\Zakir\jre7\bin\java" -cp .\bin;.\lib\* org.testng.TestNG .\bin\TestNG_IE.xml >output.txt












timeout 15
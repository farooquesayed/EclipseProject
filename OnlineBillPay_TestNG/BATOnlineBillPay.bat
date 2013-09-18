@echo ON
CD %CD%

REM java -cp .\bin;C:\Zakir\Selenium\selenium-server-standalone-2.32.0.jar org.testng.TestNG TestNG1.xml

java -cp .\bin;.\lib\* org.testng.TestNG TestNG1.xml
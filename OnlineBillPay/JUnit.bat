@echo OFF
SET ERRLOG=JUerrorLog.txt
SET RESLOG=JUresultLog.txt

REM Deleting old log file
del %RESLOG%
del %ERRLOG%

@echo ON
ECHO Running Chrome browser Test >>%RESLOG%

REM java -cp "C:\Zakir\Eclipse Projects\OnlineBillPay\bin";c:\Zakir\Selenium\junit-4.11.jar;c:\Zakir\Selenium\hamcrest-core-1.3.jar;C:\Zakir\Selenium\selenium-server-standalone-2.32.0.jar;C:\Zakir\Selenium\poi-3.9-20121203.jar org.junit.runner.JUnitCore Chrome >>%RESLOG% 2>%ERRLOG%


ECHO Running Firefox browser Test >>%RESLOG%

REM java -cp "C:\Zakir\Eclipse Projects\OnlineBillPay\bin";c:\Zakir\Selenium\junit-4.11.jar;c:\Zakir\Selenium\hamcrest-core-1.3.jar;C:\Zakir\Selenium\selenium-server-standalone-2.32.0.jar;C:\Zakir\Selenium\poi-3.9-20121203.jar org.junit.runner.JUnitCore FireFox >>%RESLOG% 2>%ERRLOG%


ECHO Running Internet Explorer browser Test >>%RESLOG%

java -cp "C:\Zakir\Eclipse Projects\OnlineBillPay\bin";c:\Zakir\Selenium\junit-4.11.jar;c:\Zakir\Selenium\hamcrest-core-1.3.jar;C:\Zakir\Selenium\selenium-server-standalone-2.32.0.jar;C:\Zakir\Selenium\poi-3.9-20121203.jar org.junit.runner.JUnitCore InternetExplorer >>%RESLOG% 2>%ERRLOG%


@echo OFF
call :CheckEmpty %ERRLOG%

:CheckEmpty
if %~z1 == 0 del %ERRLOG%


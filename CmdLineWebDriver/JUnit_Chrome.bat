@echo OFF
SET ERRLOG=JUerrorLog.txt
SET RESLOG=JUresultLog.txt

REM Deleting old log file
del %RESLOG%
del %ERRLOG%

@echo ON
ECHO Running Chrome browser Test >>%RESLOG%

java -cp "C:\Zakir\Eclipse Projects\CmdLineWebDriver\bin";c:\Zakir\Selenium\junit-4.11.jar;c:\Zakir\Selenium\hamcrest-core-1.3.jar;C:\Zakir\Selenium\selenium-server-standalone-2.32.0.jar org.junit.runner.JUnitCore org.zakir._Chrome -DbaseURL="https://qa-pay.cnico.com"

REM >>%RESLOG% 2>%ERRLOG%


@echo OFF
call :CheckEmpty %ERRLOG%

:CheckEmpty
if %~z1 == 0 del %ERRLOG%


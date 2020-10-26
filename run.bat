REM DESCRIPTION: BATCH FILE TO RUN FOCUS CORP GUI
REM AUTHOR: Nigel T. Crowther
REM DATE: 18-Oct-2020

REM INTRUCTIONS: Change PATH to the JAVA path on your local machine.
REM Set the LIB_PATH to the lib folder where you extracted the tool.
REM run focusUI.bat.

set PATH=C:\Program Files\Java\jdk-15.0.1;%PATH%
set FOCUSJAR=.\focusui.jar
set LOG4JJJAR=.\lib\log4j-1.2.8.jar

java -cp %FOCUSJAR%;%LOG4JJJAR% tester.SwingJavaClient

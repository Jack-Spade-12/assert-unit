@echo off
setlocal enabledelayedexpansion

:: Base paths
set JAVA_FILES_PATH=D:\Shortcuts\Init\Projects\assert-unit\src\com\sc\project\assertunit\
set CLASS_PATH=bin

:: Dependencies
set DEPENDENCY_PATH=lib

:: Java files
set FILE[0]=AssertUnit.java

:: Create script for javac
set JAVAC_SCRIPT=javac -classpath %DEPENDENCY_PATH%\* -d %CLASS_PATH%
set "FILE_COUNT=0"

:loop
if defined FILE[%FILE_COUNT%] (
	call set JAVAC_SCRIPT=%JAVAC_SCRIPT% %JAVA_FILES_PATH%%%FILE[%FILE_COUNT%]%%
	set /a "FILE_COUNT+=1"
	goto :loop
)

:: Execute created javac script
%JAVAC_SCRIPT%
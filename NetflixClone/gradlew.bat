@ECHO OFF
SET DIR=%~dp0
SET WRAPPER_JAR=%DIR%\gradle\wrapper\gradle-wrapper.jar

IF DEFINED JAVA_HOME (
  SET "JAVA_EXE=%JAVA_HOME%\bin\java.exe"
) ELSE (
  SET "JAVA_EXE=java.exe"
)

"%JAVA_EXE%" -classpath "%WRAPPER_JAR%" org.gradle.wrapper.GradleWrapperMain %*
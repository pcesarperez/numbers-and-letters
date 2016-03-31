@echo off

rem ============================================================================
rem build.bat
rem
rem Construcción del desplegable de `numbers-and-letters`.
rem ============================================================================


echo Building `numbers-and-letters`...
call mvn clean package --quiet --batch-mode --fail-fast --activate-profiles DES
call mvn clean package --quiet --batch-mode --fail-fast --activate-profiles PRE
call mvn clean package --quiet --batch-mode --fail-fast --activate-profiles PRO
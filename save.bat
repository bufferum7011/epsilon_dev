color 3
@REM FOR /F "delims=" %i IN ('date /t') DO set %todays_date=%i

call mvn clean -f "d:\_jsource\epsilon\pom.xml"
call mvn compile -f "d:\_jsource\epsilon\pom.xml"

git add .
git add .
@REM git commit -m %todays_date%
@REM git push

timeout 1

exit
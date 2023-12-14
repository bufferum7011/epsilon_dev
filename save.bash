color 3
FOR /F "delims=" %i IN ('date /t') DO set todays_date=%i

mvn clean -f "d:\_jsource\epsilon\pom.xml"
mvn compile -f "d:\_jsource\epsilon\pom.xml"

git add .
git add .
git commit -m %todays_date%
git push

timeout 5
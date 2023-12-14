color 3
timeout 5
mvn clean -f "d:\_jsource\epsilon\pom.xml"
timeout 5
mvn compile -f "d:\_jsource\epsilon\pom.xml"

SET todays_date = data /T

git add .
git add .
git commit -m todays_date
git push
timeout 5
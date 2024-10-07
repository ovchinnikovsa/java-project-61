JAR_FILE := build/install/app/bin/app-1.0-SNAPSHOT.jar

build:
	gradle build

run-dist: build
	java -jar $(JAR_FILE)

run: build
	java -jar $(JAR_FILE)

crun: clean run-dist

clean:
	gradle clean
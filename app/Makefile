.DEFAULT_GOAL := build-run

run:
	./gradlew run

run-dist:
	./build/install/app/bin/app

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

lint:
	./gradlew checkstyleMain

build-run: build run

.PHONY: build
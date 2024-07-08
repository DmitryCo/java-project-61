.DEFAULT_GOAL := build-run

run-dist:
	./build/install/app/bin/app

clean:
	make -C app clean

build:
	make -C app clean build

run:
	make -C app run

install:
	make -C app clean install

lint:
	make -C app checkstyleMain

build-run: build run

.PHONY: build
# AOTB 2013 Clojure tutorial

## This is a tutorial that goes with Jim's AOTB 2013 talk

Here you will find the code samples that Jim was doing. To run them, install the pre-requisites and then type

  lein ring server

To see the server in action or,

  lein run -m clojure-intro.command-line "Some name"

To see the command line program running. You have to type the ```-m``` part because we have the default main class to be set up to be the server.
  
  lein uberjar
  java -cp ./target/aotb-2013-0.1.0-SNAPSHOT-standalone.jar clojure_intro/command_line "Some name"

Or

  lein uberjar
  java -jar ./target/aotb-2013-0.1.0-SNAPSHOT-standalone.jar

To start the server this way.

## Pre-Requisites

- Java / JDK
- Leiningen 
- git 

## To follow along

Find somewhere to put the code (e.g. ~/tmp)

  lein new aotb-2013

  git init

## Itinery

- Some very basics
- OO decomposed
- Talking to Java
- Something more useful - an API!
- What else is there to see?
  - core.logic
  - overtone
  - incanter
  - datomic
  - 

## Useful links

http://en.wikibooks.org/wiki/Clojure_Programming/Examples/Cookbook
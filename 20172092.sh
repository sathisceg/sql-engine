#!/bin/bash


echo $1
javac ExecuteQuery.java 

java ExecuteQuery "$1"


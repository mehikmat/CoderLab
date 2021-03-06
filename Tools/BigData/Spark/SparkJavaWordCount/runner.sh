#!/bin/sh
#Remove output directory if already exists
$HADOOP_HOME/bin/hadoop fs -rm -r output/output.txt

#Create input directory
$HADOOP_HOME/bin/hadoop fs -mkdir -p input

#Put input data file
$HADOOP_HOME/bin/hadoop fs -put ./data/input.txt input/

#build jar
mvn clean package

#Run Job
$SPARK_HOME/bin/spark-submit target/SparkWordCount-1.0.jar


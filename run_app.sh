#!/bin/bash

# Define variables for paths
JAVA_HOME="/usr/lib/jvm/jdk-22-oracle-x64"
IDEA_AGENT="/home/mhachami/Downloads/ideaIC-2024.2.0.2/idea-IC-242.20224.419/lib/idea_rt.jar"
IDEA_BIN="/home/mhachami/ideaIC-2024.2.0.2/idea-IC-242.20224.419/bin"
PROJECT_DIR="/home/mhachami/Desktop/projects/A2_brief/BookTrack"
SRC_DIR="$PROJECT_DIR"
CLASS_DIR="$PROJECT_DIR/out/production/BookTrack"
JAR_DIR="$PROJECT_DIR/jar"
JAR_NAME="BookTrack.jar"
MANIFEST_FILE="$PROJECT_DIR/MANIFEST.MF"
MYSQL_CONNECTOR="/usr/share/java/mysql-connector-java-9.0.0.jar"
MAIN_CLASS="Main"

# Define the Java compiler and runtime
JAVA="$JAVA_HOME/bin/java"
JAVAC="$JAVA_HOME/bin/javac"

# Java runtime options
JAVA_OPTS="-javaagent:$IDEA_AGENT=45221:$IDEA_BIN \
           -Dfile.encoding=UTF-8 \
           -Dsun.stdout.encoding=UTF-8 \
           -Dsun.stderr.encoding=UTF-8"

# Compilation options
COMPILE_OPTS="-d $CLASS_DIR -classpath $MYSQL_CONNECTOR"

# Create the necessary directories if they don't exist
mkdir -p $CLASS_DIR $JAR_DIR

# Compile all Java files in the project
echo "Compiling Java files..."
$JAVAC $COMPILE_OPTS $(find $SRC_DIR -name "*.java")

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "Compilation successful."
else
    echo "Compilation failed."
    exit 1
fi

# Create the manifest file
echo "Creating MANIFEST.MF..."
echo "Manifest-Version: 1.0" > $MANIFEST_FILE
echo "Main-Class: $MAIN_CLASS" >> $MANIFEST_FILE

# Package compiled classes into a JAR
echo "Creating JAR file..."
jar cfm $JAR_DIR/$JAR_NAME $MANIFEST_FILE -C $CLASS_DIR .

# Check if JAR creation was successful
if [ $? -eq 0 ]; then
    echo "JAR file created successfully: $JAR_NAME"
else
    echo "Failed to create JAR file."
    exit 1
fi

# Run the JAR file
echo "Running JAR file..."
$JAVA $JAVA_OPTS -classpath "$JAR_DIR/$JAR_NAME:$MYSQL_CONNECTOR" -jar $JAR_DIR/$JAR_NAME

# Check if the JAR file ran successfully
if [ $? -eq 0 ]; then
    echo "JAR file ran successfully."
else
    echo "Failed to run JAR file."
    exit 1
fi

# Clean up generated files
echo "Cleaning up generated class files..."
rm -rf "$CLASS_DIR"

echo "Cleanup completed."

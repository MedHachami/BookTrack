#!/bin/bash

# Define variables for paths
JAVA_HOME="/usr/lib/jvm/jdk-22-oracle-x64"
IDEA_AGENT="/home/mhachami/Downloads/ideaIC-2024.2.0.2/idea-IC-242.20224.419/lib/idea_rt.jar"
IDEA_BIN="/home/mhachami/ideaIC-2024.2.0.2/idea-IC-242.20224.419/bin"
PROJECT_DIR="/home/mhachami/Desktop/projects/A2_brief/BookTrack"
SRC_DIR="$PROJECT_DIR"
CLASS_DIR="$PROJECT_DIR/out/production/BookTrack"
MAIN_CLASS="Main" # Update this if your class is in a package

# Define the Java compiler and runtime
JAVA="$JAVA_HOME/bin/java"
JAVAC="$JAVA_HOME/bin/javac"

# Java runtime options
JAVA_OPTS="-javaagent:$IDEA_AGENT=45221:$IDEA_BIN \
           -Dfile.encoding=UTF-8 \
           -Dsun.stdout.encoding=UTF-8 \
           -Dsun.stderr.encoding=UTF-8"

# Compilation options
COMPILE_OPTS="-d $CLASS_DIR" # Direct output to the class directory

# Compile Java files
echo "Compiling Java files..."
$JAVAC $COMPILE_OPTS $SRC_DIR/*.java

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "Compilation successful."
else
    echo "Compilation failed."
    exit 1
fi

# Run the Java application
echo "Running Java application..."
$JAVA $JAVA_OPTS -classpath $CLASS_DIR $MAIN_CLASS

# Check if the application ran successfully
if [ $? -eq 0 ]; then
    echo "Application run successfully."
else
    echo "Application failed to run."
    exit 1
fi

# Clean up generated files
echo "Cleaning up generated files..."
rm -rf "$CLASS_DIR/Main.class"

echo "Cleanup completed."
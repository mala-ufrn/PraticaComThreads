#!/bin/sh 

echo ">>>inicio da interacao" 2048 c2   
x=20 
while [ $x -gt 0 ]; do 
    echo ">>> execucao:" $x
    java -jar pratica_threads.jar 2048 c2 
    x=$(($x-1)) 
done 
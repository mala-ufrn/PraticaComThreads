#!/bin/sh 
array=( s c1 c2 c3 )  
limit=( 4 8 16 32 64 128 256 512 1024 ) 
 
for i in "${array[@]}" 
 
do 
    for j in "${limit[@]}" 
    do 
    echo ">>>inicio da interacao" $j $i     
        x=20 
        while [ $x -gt 0 ]; do 
        java -jar pratica_threads.jar $j $i 
        x=$(($x-1)) 
        done 
     
    done 
     
done
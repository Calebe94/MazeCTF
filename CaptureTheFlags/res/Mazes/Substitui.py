# -*- coding: utf-8 -*-
import sys
import os
args = sys.argv
if(len(args)>1):
    file_name = args[1]
arquivo = open(os.getcwd()+"/"+file_name+".txt","r")
my_maze = arquivo.read()
arquivo.close()
new_string = my_maze.replace(" ",",")
arquivo = open(os.getcwd()+"/"+file_name+".txt","w")
arquivo.write(new_string)
arquivo.close()
    

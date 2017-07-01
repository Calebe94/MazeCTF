from random import shuffle, randrange
import os
import sys

def make_maze(w, h):
    w-=22
    h-=12
    vis = [[0] * w + [1] for _ in range(h)] + [[1] * (w + 1)]
    ver = [["2 0 "] * w + ['2'] for _ in range(h)] + [[]]
    hor = [["2 2 "] * w + ['2'] for _ in range(h + 1)]
 
    def walk(x, y):
        vis[y][x] = 1
 
        d = [(x - 1, y), (x, y + 1), (x + 1, y), (x, y - 1)]
        shuffle(d)
        for (xx, yy) in d:
            if vis[yy][xx]: continue
            if xx == x: hor[max(y, yy)][x] = "2 0 "
            if yy == y: ver[y][max(x, xx)] = "0 0 "
            walk(xx, yy)
 
    walk(randrange(w), randrange(h))
 
    s = ""
    for (a, b) in zip(hor, ver):
        s += ''.join(a + ['\n'] + b + ['\n'])
    return s
 
if __name__ == '__main__':
    rows = int()
    columns = int()
    file_name = str()
    
    args = sys.argv
    if(len(args)>1):
        columns = int(args[1])
        rows    = int(args[2])
        file_name = str(args[3])
        
    arquivo = open(os.getcwd()+"/"+file_name+".txt","w")
    
    my_maze = str(columns)+" "+str(rows)+"\n"+make_maze(int(columns),int(rows))
    arquivo.write(my_maze)
    arquivo.close()
    #print(make_maze())

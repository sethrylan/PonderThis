#! /usr/bin/python

__author__="gaineys"
__date__ ="$Sep 4, 2012 12:30:14 PM$"

if __name__ == "__main__":
    i = 1
    while True:
        for x in range(1,10):
            if i % x != x - 1:
                i = i + 1
                break
        print i

            

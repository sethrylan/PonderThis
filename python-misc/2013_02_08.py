#! /usr/bin/python

# return a number composed of digits 0-9 (non-repeating?) that is divisible by number 2-18

__author__="gaineys"
__date__ ="$Feb 8, 2013 8:35:41 AM$"

import itertools

if __name__ == "__main__":
    for c in itertools.permutations(range(10), 10):
        num = int(''.join(map(str,c)))
        if all(num % d ==0 for d in range(2,19)):
            print num

#! /usr/bin/python
'''Given the list of numbers 123456789, inserts the minimum number of mathematical operators to produce an expression which evaluates to 100'''

__author__="gaineys"
__date__ ="$Jul 17, 2012 10:35:04 AM$"

from itertools import product, ifilter, chain

ops = ['-', '+', '*', '%', '']

def expressions(numlist):
    for oplist in product(ops, repeat=len(numlist) - 1):
        yield ''.join(chain.from_iterable(zip(numlist, oplist))) + numlist[-1]

print min(ifilter(lambda x: eval(x)==100, expressions([str(i) for i in range(1,10)])), key=len)

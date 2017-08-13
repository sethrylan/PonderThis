#! /usr/bin/python
''' Print the sum of a series of random numbers where each number is round to one significant digit and the true sum.'''
import random
__author__="gaineys"
__date__ ="$Aug 30, 2012 2:20:13 PM$"


from itertools import product, ifilter, chain


def log_rounding(mu, sigma):
    nums = [random.lognormvariate(mu, sigma) for x in range(20)]
    nums_rounded = [round(x, -(len(str(round(x)))-3)) for x in nums]
    return sum(nums), sum(nums_rounded)

def difference(x,y):
    return x-y

if __name__ == "__main__":
    mu,sigma = 6.0, 2.0
    differences_from_rounding = [difference(*log_rounding(mu, sigma)) for x in range(100)]
    print differences_from_rounding
    print sum(differences_from_rounding)



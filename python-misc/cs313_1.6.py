#! /usr/bin/python

from itertools import *

def validity_check(cover, graph):
    for combination in combinations(range(len(graph)), cover):
        print

def vertex_cover_naive(input_graph):
    n = len(input_graph)
    minimum_vertex_cover = n
    # loops through all strings of 0s and 1s of length n
    for assignment in product([0,1], repeat=n):
        # Your code should go here.
        # Based on the assignment (a list of 0s and 1s)
        # - Check the assignment is valid
        # - Calculate the size of assignment
        # - Update the minimum_vertex_cover variable if appropriate
        for cover in range(minimum_vertex_cover):
            if validity_check(n, input_graph) == True:
                minimum_vertex_cover = cover
    # End of your code
    return minimum_vertex_cover

def test():
    graph = [[0, 1, 1, 1, 1],
            [1, 0, 0, 0, 1],
            [1, 0, 0, 1, 1],
            [1, 0, 1, 0, 1],
            [1, 1, 1, 1, 0]]
    assert vertex_cover_naive(graph)==3

if __name__ == "__main__":
    test()

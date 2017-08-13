#! /usr/bin/python

# To change this template, choose Tools | Templates
# and open the template in the editor.

__author__="gaineys"
__date__ ="$Jan 4, 2013 4:05:05 PM$"


# Write a function inverse_graph which takes as its input the
# adjacency matrix of a graph and returns the adjacency matrix
# of the inverse graph.


def inverse_graph(graph):
    inverse = [[[ ] for x in xrange(len(graph))] for x in xrange(len(graph))]
    for i in range(len(graph)):
        for j in range(len(graph)):
            if (i == j or graph[i][j] == 1):
                inverse[i][j] = 0
            else:
                inverse[i][j] = 1
    return inverse

def test():
    g1 = [[0, 1, 1, 0],
          [1, 0, 0, 1],
          [1, 0, 0, 1],
          [0, 1, 1, 0]]
    assert inverse_graph(g1) == [[0, 0, 0, 1],
                                 [0, 0, 1, 0],
                                 [0, 1, 0, 0],
                                 [1, 0, 0, 0]]
    g2 = [[0, 1, 1, 1],
          [1, 0, 1, 1],
          [1, 1, 0, 1],
          [1, 1, 1, 0]]
    assert inverse_graph(g2) == [[0, 0, 0, 0],
                                 [0, 0, 0, 0],
                                 [0, 0, 0, 0],
                                 [0, 0, 0, 0]]

# If you've not seen testing like this before, all you need to do is
# to call test(). If the tests pass, you'll get no output. If they don't
# you'll get an assertion error. Don't forget to remove the call to the
# test before submitting your code.

if __name__ == "__main__":
    test()

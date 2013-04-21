#! /usr/bin/python
'''
One can replace the letters in the expression I/M = B/A+C/K with different digits from 1 to 6 to form a valid equation. For example: 5/6 = 2/4+1/3.
Substituting back letters to digits, using the same solution ACK.IBM is 413.526.
The problem: Replace the letters with different digits such that D/O+N/T = P/E+R/I+S/H
and send us PONDER.THIS translated back to a number.
'''

__author__="gaineys"
__date__ ="$Apr 20, 2013 9:01:31 PM$"


from itertools import permutations
import __future__


def future_eval(expr):
    try:
        return eval(compile(expr, '<string>', 'eval', __future__.division.compiler_flag))
    except ZeroDivisionError:
        return -1

for (D,O,N,T,P,E,R,I,S,H) in permutations(range(0,10)):
    DONT = future_eval("{}/{}+{}/{}".format(D,O,N,T))
    PERISH = future_eval("{}/{}+{}/{}+{}/{}".format(P,E,R,I,S,H))
    if DONT == PERISH and abs(int(DONT) - DONT)<.0000001:
        print "{}/{}+{}/{}".format(D,O,N,T) + " = " + str(DONT) + " == " + "{}/{}+{}/{}+{}/{}".format(P,E,R,I,S,H) + " = " + str(PERISH)
        print "{}{}{}{}{}{}.{}{}{}{}".format(P,O,N,D,E,R,T,H,I,S)


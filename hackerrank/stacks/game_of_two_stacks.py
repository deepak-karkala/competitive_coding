#!/bin/python3

"""
Alexa has two stacks of non-negative integers, stack  and stack  where index  denotes
the top of the stack. Alexa challenges Nick to play the following game:
In each move, Nick can remove one integer from the top of either stack  or stack .
Nick keeps a running sum of the integers he removes from the two stacks.
Nick is disqualified from the game if, at any point, his running sum becomes greater
than some integer  given at the beginning of the game.
Nick's final score is the total number of integers he has removed from the two stacks.
Given , , and  for  games, find the maximum possible score Nick can achieve
(i.e., the maximum number of integers he can remove without being disqualified) during
each game and print it on a new line.
"""

import os
import sys


#
# Complete the twoStacks function below (if only top of stack is visible).
#
def twoStacks(x, a, b):
    # Initialise stacks (reverse lists)
    a = list(reversed(a))
    b = list(reversed(b))
    removed_elem_sum = 0
    num_elem_removed = 0

    while ((len(a) > 0) or (len(b) > 0)) and (removed_elem_sum <= x):
        if (len(b) == 0) or ((len(a) > 0) and (a[-1] <= b[-1])):
            removed_elem_sum += a[-1]
            a.pop()
        elif (len(a) == 0) or ((len(b) > 0) and (b[-1] <= a[-1])):
            removed_elem_sum += b[-1]
            b.pop()

        if removed_elem_sum <= x:
            num_elem_removed += 1

    return num_elem_removed


if __name__ == '__main__':
    g = int(input())

    for g_itr in range(g):
        nmx = input().split()
        n = int(nmx[0])
        m = int(nmx[1])
        x = int(nmx[2])
        a = list(map(int, input().rstrip().split()))
        b = list(map(int, input().rstrip().split()))

        result = twoStacks(x, a, b)
        print(result)
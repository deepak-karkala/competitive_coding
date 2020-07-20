#!/bin/python3
"""
You have three stacks of cylinders where each cylinder has the same diameter,
but they may vary in height. You can change the height of a stack by removing
and discarding its topmost cylinder any number of times.
Find the maximum possible height of the stacks such that all of the stacks are
exactly the same height. This means you must remove zero or more cylinders from
the top of zero or more of the three stacks until they're all the same height,
then print the height. The removals must be performed in such a way as to
maximize the height.
"""

import os
import sys


def equalStacks_alternative(h1, h2, h3):
    """
    Maximum height of equal stack
    """
    # Reverse list to initialise stacks with cylinders
    h1 = list(reversed(h1))
    h2 = list(reversed(h2))
    h3 = list(reversed(h3))

    # Set lengths of stacks
    s1h = sum(h1)
    s2h = sum(h2)
    s3h = sum(h3)
    stack_heights = [s1h, s2h, s3h]

    # If stacks are already of equal height, return that height
    if (s1h == s2h) and (s2h == s3h):
        return s1h

    # Continue removing cylinders until stacks are empty or
    # stacks are of unequal height
    while (((s1h > 0) and (s2h > 0) and (s3h > 0)) and
            ((s1h != s2h) or (s2h != s3h) or (s1h != s3h))):

        # Determine stack with max and min height
        vals = [s1h, s2h, s3h]
        tallest_stack_indx = vals.index(max(vals))
        tallest_stack_height = stack_heights[tallest_stack_indx]
        shortest_stack_indx = vals.index(min(vals))
        shortest_stack_height = stack_heights[shortest_stack_indx]

        # Remove cylinders from tallest stack until empty or
        # height of tallest stack is less than height of
        # shortest stack
        while (tallest_stack_height > 0) and (tallest_stack_height > shortest_stack_height):
            if tallest_stack_indx == 0:
                cylinder_height = h1[-1]
                h1.pop()
            elif tallest_stack_indx == 1:
                cylinder_height = h2[-1]
                h2.pop()
            elif tallest_stack_indx == 2:
                cylinder_height = h3[-1]
                h3.pop()
            tallest_stack_height -= cylinder_height

        # Update lengths of stacks
        s1h = sum(h1)
        s2h = sum(h2)
        s3h = sum(h3)
        stack_heights = [s1h, s2h, s3h]

        # If stacks are of equal height, return this height
        if (s1h == s2h) and (s2h == s3h):
            return s1h

    # Return 0 if stacks cannot be made of equal height
    return 0


def equalStacks(h1, h2, h3):
    running_sum = running_sum_stack(list(reversed(h1)))
    running_sum &= running_sum_stack(list(reversed(h2)))
    running_sum &= running_sum_stack(list(reversed(h3)))
    if len(running_sum) > 0:
        return max(running_sum)
    else:
        return 0


def running_sum_stack(h):
    stack_sum = set()
    csum = 0
    for i in h:
        csum += i
        stack_sum.add(csum)
    return stack_sum


if __name__ == '__main__':
    n1N2N3 = input().split()
    n1 = int(n1N2N3[0])
    n2 = int(n1N2N3[1])
    n3 = int(n1N2N3[2])

    h1 = list(map(int, input().rstrip().split()))
    h2 = list(map(int, input().rstrip().split()))
    h3 = list(map(int, input().rstrip().split()))

    result = equalStacks(h1, h2, h3)
    print(result)

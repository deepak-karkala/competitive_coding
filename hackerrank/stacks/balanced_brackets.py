"""
Complete the function isBalanced. It must return a string: YES
if the sequence is balanced or NO if it is not.
isBalanced has the following parameter(s):
s: a string of brackets
"""


def is_balanced(s):
    """
    Checks if brackets are balanced using stack
    :param s: string containing brackets
    :return: true if brackets are balanced, false if not
    """

    stack = []
    matching_brackets = {"{": "}", "[": "]", "(": ")"}
    for current_bracket in s:
        if current_bracket in matching_brackets:
            stack.append(current_bracket)
        else:
            if len(stack) == 0:
                return False
            else:
                top_of_stack = stack.pop()
                if current_bracket != matching_brackets[top_of_stack]:
                    return False

    if len(stack) == 0:
        return True
    else:
        return False


if __name__ == "__main__":
    n = int(input())
    if n > 1000:
        n = 1000
    while n > 0:
        n -= 1
        s = input()
        if is_balanced(s):
            print("YES")
        else:
            print("NO")
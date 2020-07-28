"""
Given a string containing just the characters
'(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
"""


class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) == 0:
            return True
        matching_brackets = {"(": ")", "[": "]", "{": "}"}
        opening_brackets = ["(", "[", "{"]
        stack = []
        for b in s:
            if b in opening_brackets:
                stack.append(b)
            else:
                if len(stack) == 0:
                    return False
                expected_bracket = matching_brackets[stack.pop()]
                if b != expected_bracket:
                    return False

        return True if len(stack) == 0 else False



if __name__ == "__main__":
    sol = Solution()
    print(sol.isValid(")"))

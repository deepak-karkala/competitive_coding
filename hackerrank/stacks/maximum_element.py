"""
You have an empty sequence, and you will be given  queries.
Each query is one of these three types:
1 x  -Push the element x into the stack.
2    -Delete the element present at the top of the stack.
3    -Print the maximum element in the stack.
"""


class Stack:

    def __init__(self):
        self.stack = []

    def size(self):
        return len(self.stack)

    def is_empty(self):
        return self.size() == 0

    def push(self, item):
        self.stack.append(item)

    def pop(self):
        if self.is_empty():
            raise IndexError("Stack empty")
        self.stack.pop()


if __name__ == "__main__":
    N = input()
    i = int(N)
    # Stack to store elements
    stack = Stack()
    # Stack to keep track of max element
    # Top of max_stack will have max of all elements in stack
    max_stack = Stack()
    while i > 0:
        inp = input()
        query_type = int(inp.split(" ")[0])
        if query_type == 1:
            elem_to_push = int(inp.split(" ")[1])
            stack.push(elem_to_push)
            if max_stack.size() == 0 or max_stack.stack[-1] < elem_to_push:
                max_stack.push(elem_to_push)
            else:
                max_stack.push(max_stack.stack[-1])
        elif query_type == 2:
            stack.pop()
            max_stack.pop()
        elif query_type == 3:
            print(max_stack.stack[-1])
        i -= 1



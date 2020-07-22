"""
A queue is an abstract data type that maintains the order in which
elements were added to it, allowing the oldest elements to be removed
from the front and new elements to be added to the rear.
This is called a First-In-First-Out (FIFO) data structure because
the first element added to the queue (i.e., the one that has been
waiting the longest) is always the first one to be removed.

A basic queue has the following operations:

Enqueue: add a new element to the end of the queue.
Dequeue: remove the element from the front of the queue and return it.
In this challenge, you must first implement a queue using two stacks.
Then process  queries, where each query is one of the following  types:

1 x: Enqueue element  into the end of the queue.
2: Dequeue the element at the front of the queue.
3: Print the element at the front of the queue.
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

    def peek(self):
        if self.is_empty():
            raise IndexError("Stack empty")
        return self.stack[-1]


if __name__ == '__main__':
    q = int(input())
    pushStack = Stack()
    popStack = Stack()
    while q > 0:
        inp = input()
        type = int(inp.split(" ")[0])
        if type == 1:
            elem = int(inp.split(" ")[1])
            pushStack.push(elem)
        elif type == 2:
            if popStack.is_empty():
                for i in range(pushStack.size()):
                    popStack.push(pushStack.pop())
            popStack.pop()
        elif type == 3:
            if popStack.is_empty():
                for i in range(pushStack.size()):
                    popStack.push(pushStack.pop())
            print(popStack.peek())
        q -= 1

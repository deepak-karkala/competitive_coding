/*
150. Evaluate Reverse Polish Notation
Solved
Medium
Topics
Companies
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.
*/

class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String[] operators = new String[] {"+", "-", "*", "/"};

        for(String token: tokens) {
            if (Arrays.asList(operators).contains(token)) {
                int operandRight = stack.pop();
                int operandLeft = stack.pop();
                int result = getResult(operandLeft, operandRight, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public int getResult(int left, int right, String operator) {
        if (operator.equals("+")) return left + right;
        else if (operator.equals("-")) return left - right;
        else if (operator.equals("*")) return left * right;
        else return left / right;
    }
}
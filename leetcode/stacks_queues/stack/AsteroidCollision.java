/*
735. Asteroid Collision
Solved
Medium
Topics
Companies
Hint
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
*/

class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        // Scenarios: ++, --, -+, +-
        // Only +- will lead to collision
        for(int ast: asteroids) {

            
            //  Keep pushing to stack as long asteroid[i] > 0 (may be preceeded by long list of -ves)
            if (ast > 0) stack.push(ast);
            else {
                //  When we get -ve, keep popping until stack top is smaller than abs(-ve)
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -ast)
                    stack.pop();

                // Handle edge scenarios:
                //  After popping, if stack empty, 
                //  or if -ve is received with stack top already -ve,
                //  then push -ve to stack
                if (stack.isEmpty() || stack.peek() < 0) stack.push(ast);
                //  If abs(-ve) == stack top, then pop from stack
                if (stack.peek() == -ast) stack.pop();
            }
        }

        //int[] asteroidsPostCollision = new int[stack.size()];
        //for(int i = stack.size()-1; i >= 0; i--) asteroidsPostCollision[i] = stack.pop();
        //return asteroidsPostCollision;
        return stack.stream().mapToInt(i->i).toArray();
    }
}
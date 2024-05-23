/*
71. Simplify Path
Solved
Medium
Topics
Companies
Given an absolute path for a Unix-style file system, which begins with a slash '/', transform this path into its simplified canonical path.

In Unix-style file system context, a single period '.' signifies the current directory, a double period ".." denotes moving up one directory level, and multiple slashes such as "//" are interpreted as a single slash. In this problem, treat sequences of periods not covered by the previous rules (like "...") as valid names for files or directories.

The simplified canonical path should adhere to the following rules:

It must start with a single slash '/'.
Directories within the path should be separated by only one slash '/'.
It should not end with a slash '/', unless it's the root directory.
It should exclude any single or double periods used to denote current or parent directories.
Return the new path.
*/


class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();

        for(String s: path.split("/")) {
            if (s.equals("..") && !stack.isEmpty()) stack.poll();
            else if (s.equals("..") || s.equals("") || s.equals(".")) continue;
            else stack.push(s);
        }

        //return stack.isEmpty() ? "/" : "/" + String.join("/", stack);

        StringBuilder sb = new StringBuilder();
        if(stack.size() == 0) return "/";
        while(stack.size() != 0) sb.append("/").append(stack.pollLast());
        return sb.toString();
    }
}
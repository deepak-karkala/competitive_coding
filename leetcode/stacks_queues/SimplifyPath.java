/*
71. Simplify Path
Medium
3.2K
641
Given a string path, which is an absolute path (starting with a slash '/')
to a file or directory in a Unix-style file system, convert it to the
simplified canonical path.
*/
import java.util.*;

public class SimplifyPath {

	public static String simplifyPath(String s) {
		//Deque<String> stack = new LinkedList<String>();
		Stack<String> stack = new Stack<String>();
		Set<String> set = new HashSet<String>(Arrays.asList(".","..",""));

		for(String dir: s.split("/")) {
			if ((dir.equals("..")) && (!stack.isEmpty())) {
				stack.pop();
			} else if (!set.contains(dir)) {
				stack.push(dir);
			}
		}

		// Return from stack
		return stack.isEmpty() ? "/" : "/"+String.join("/", stack);

		// Return from queue
		/*
		String res="/";
		for(String dir: stack) res = "/" + dir + res;
		return res.isEmpty() ? "/" : res;
		*/

		/*
		At the end, form a string out of stack elements. Multiple approaches
			Directly use stack — String.join(“/“, stack)
			Stack to array list — String.join(“/“, list)
			Stack to String[] — Iterate and concatenate
			Stack to StringBuilder() - Iterate and concatenate
		*/

		/*
		String res="";
		for(String dir: stack) res = "/" + dir + res;
		return res;
		*/

		//List list = new ArrayList<String>(stack);
		//return "/"+String.join("/", list);

		/*
		StringBuilder sb = new StringBuilder();
		for(String dir: stack) {
			sb.append("/");
			sb.append(dir);
		}
		return sb.length()==0 ? "/" : sb.toString();
		*/

		//return stack.isEmpty() ? "/" : "/"+String.join("/", stack);
	}

	public static void main(String[] args) {
		String s = "/a/./b/../../c/";
		System.out.println(simplifyPath(s));
	}
}
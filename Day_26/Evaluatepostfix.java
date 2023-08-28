import java.util.Stack;

class Evaluatepostfix
{
	// Function to evaluate a given postfix expression
	public static int evalPostfix(String exp)
	{
		// base case
		if (exp == null || exp.length() == 0) {
			System.exit(-1);
		}

		// create an empty stack
		Stack<Integer> stack = new Stack<>();

		// traverse the given expression
		for (char c: exp.toCharArray())
		{
			// if the current character is an operand, push it into the stack
			if (Character.isDigit(c)) {
				stack.push(c - '0');
			}
			// if the current character is an operator
			else {
				// remove the top two elements from the stack
				int x = stack.pop();
				int y = stack.pop();

				// evaluate the expression 'x op y', and push the
				// result back to the stack
				if (c == '+') {
					stack.push(y + x);
				}
				else if (c == '-') {
					stack.push(y - x);
				}
				else if (c == '*') {
					stack.push(y * x);
				}
				else if (c == '/') {
					stack.push(y / x);
				}
			}
		}

		// At this point, the stack is left with only one element, i.e.,
		// expression result
		return stack.pop();
	}

	public static void main(String[] args)
	{
		String exp = "138*+";
		System.out.println(evalPostfix(exp));
	}
}
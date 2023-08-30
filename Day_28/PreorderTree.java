import java.util.Stack;

// Data structure to store a binary tree node
class Node
{
	int data;
	Node left, right;

	// Function to create a new binary tree node having a given key
	public Node(int key)
	{
		data = key;
		left = right = null;
	}
}

class PreorderTree
{
	// Iterative function to perform preorder traversal on the tree
	public static void preorderIterative(Node root)
	{
		// return if the tree is empty
		if (root == null) {
			return;
		}

		// create an empty stack and push the root node
		Stack<Node> stack = new Stack<>();
		stack.push(root);

		// loop till stack is empty
		while (!stack.empty())
		{
			// pop a node from the stack and print it
			Node curr = stack.pop();

			System.out.print(curr.data + " ");

			// push the right child of the popped node into the stack
			if (curr.right != null) {
				stack.push(curr.right);
			}

			// push the left child of the popped node into the stack
			if (curr.left != null) {
				stack.push(curr.left);
			}

			// the right child must be pushed first so that the left child
			// is processed first (LIFO order)
		}
	}

	public static void main(String[] args)
	{
		/* Construct the following tree
				   1
				 /   \
				/     \
			   2       3
			  /      /   \
			 /      /     \
			4      5       6
				  / \
				 /   \
				7     8
		*/

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);

		preorderIterative(root);
	}
}
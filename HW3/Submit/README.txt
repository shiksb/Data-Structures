Problem1.java

This class creates an Expression tree using a hardcoded postfix expression.
Then it tests out the methods of the ExpressionTree object

To run this program perform:

> javac Problem1.java
> java Problem1

ExpressionTree.java

This class defines an expression tree using a postfix expression.
First, the constructor scans the postfix expression. If the next character is a number, it creates a node from the number and pushes it to the stack. If the next character is a symbol, it pops the last two subtrees and merges them by creating a root node from the symbol. 

Finally, the last element of the stack will give the entire tree, or root. The method eval traverses through the tree using postorder traversal and evaluates the tree's value. 

The postfix expression can be generated using postorder traversal. The infix notation can be generated using the inorder traversal. The prefix expression can be generated using preorder traversal.

Problem 2.java

This file takes a command line argument for the file name. Then, it scans every word of that file and creates an AvlTree where every node contains the word itself, and a linked list of line numbers that the word appears in. Then, it displays all the words and their line numbers.

To run this program by reading the file "fileName.txt" perform:

> javac Problem2.java
> java Problem2 fileName.txt

AvlTree.java

This file contains the methods of an Avl tree. Methods that I added were indexWord, which inserts a node with the word if the tree doesn't contain the word. Then, it finds the node object for that word. Finally, it appends the line number of that word to the list of line numbers for the node object.

The getLineForWord method returns the list of line numbers for a given word. If the tree doesn't contain the word, it returns an empty list. 

The helper method findNode recursively traverses through the tree and returns the node containing the word. The indexWord method simply prints all the words. 


 


SymbolBalance

In this program, the main logic is as follows. If the last symbol was an
open symbol, and the next symbol is an unmatching close symbol, then that
is a program. The next symbol must be a matching close symbol, in which
case the pair of symbols is popped, or another open symbol, in which case
the symbol is pushed. My next symbol method takes care of the comment and
string situation by creating two logic variables that keep track of whether
we are inside a comment or string.

TwoStackQueue
In this program we simply push the data to S1 when the enqueue method is
called, and pop from S2 when the dequeue method is called. Before dequeuing
 however, we first push everything in S1 to S2 using the moveToRight
 method, which keeps pushing to S2 what is popped in S1 till S1 is empty.

 To run the programs, for SymbolBalance put the following code on terminal:

     javac SymbolBalance.java
     java SymbolBalance Test.java


Replace Test.java with another file to test that.

To run TwoStackQueueTester, use the following code:

     javac TwoStackQueueTester.java
     java TwoStackQueueTester

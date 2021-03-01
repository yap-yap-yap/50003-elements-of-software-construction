# Black Box Test Suite
The only use case for this program is calling the ``Russian.multiply(int m, int n)`` static method. The input fields are to be integers for the test to pass. The possible input cases are positive integers, negative integers, zeroes, and the combinations within (thus ``3^2 = 9`` test cases). A negative ``n`` with a non-zero ``m`` would not produce the correct output, since the loop only runs when n > 0.

The test cases are:
```
valid:
{2, 3},
{0, 3},
{2, 0},
{0, 0},
{-2, 0},
{0, -3},
{2, -3}

invalid:
{-2, 3},
{-2, -3}
```

# White Box Test Suite: Full Branch Coverage
There needs to be cases to cover the branches when ``n%2 = 1`` and ``n%2 != 1``, and ``n > 0`` and ``n <= 0``. However, by the nature of the program, the value of n changes throughout its execution, covering all these branches in order to compute the correct result. The most obvious way to cover every branch is to use an even positive ``n`` to cover ``n%2 != 1`` intially, and then cover ``n%2 = 1`` when it eventually reaches 1 after diviiding by 2 over and over. the ``n <= 0`` case is naturally covered when the code exits the loop.

The test case is:
```
{3, 6}
```

# Fault-based Testing


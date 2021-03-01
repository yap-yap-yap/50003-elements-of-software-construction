There are 2 statements that the method will always pass through (the ones concerning ``x``), and each of these statements lead to 3 branches. Thus there must be at least 3 use cases to achieve full branch coverage. However, Q7's statement coverage test cases show that you cannot enter both branches where the statements involving ``x`` are false (``x`` cannot be less than 5 and more than or equal to 1000 at the same time), and to achieve full path coverage with 3 test cases, at least one of the test cases must have both statements involving ``x`` be false (since there are 4 branches when both are false vs 2 branches when both are true). Therefore 4 test cases is the minimum for full branch coverage.

The test cases are:
```
{2, -20},
{2, 17},
{1010, -20},
{1010, 17}
```
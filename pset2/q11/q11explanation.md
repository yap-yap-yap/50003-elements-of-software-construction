A set of values that cover ``x > 5`` , ``x > 1000`` and ``y < 1`` will cause only ``threshold = threshold - 1`` and ``threshold = threshold + 1`` to occur every loop. The value of ``threshold`` will thus never change between loops and the method will be stuck in the loop forever.

The test case is:
```
{1010, -20}
```
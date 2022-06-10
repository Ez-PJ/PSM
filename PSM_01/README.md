# Taylor Series

In mathematics, a Taylor series is a representation of a function as an infinite sum of terms that are calculated from the values of the function derivatives at a single point.

The Taylor series of a real or complex-valued function $$f(x)$$ that is infinitely differentiable at a real or complex number a is the power series.

$$f(a) + \frac{f^\prime(a)}{1!}(x-a)+\frac{f^{\prime\prime}(a)}{2!}(x-a)^2+..$$

which can be written in the more compact sigma notation as:

$$\sum_{n=0}^{\infty} \frac{f^n*a}{n!}(x-a)^n$$

In the case that $$a=0$$, the series is also called a Maclaurin series:

$$sin(x) = \sum_{n=0}^{\infty} \frac{(-1)^n}{(2n+1)!}x^{2n+1} = x - \frac{x^3}{3!} + \frac{x^5}{5!} - ..$$

Write a program to compute $$sin(x)$$ for given value of $$x$$
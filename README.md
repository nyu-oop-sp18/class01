# Class 1

## Install toolchain

I will provide support and instructions for OSX and Linux (Ubuntu). 
If you have a system running Windows, you are on your own. However,
you can install a Ubuntu virtual machine using VirtualBox and follow
the instructions for Ubuntu. VirtualBox is free. Instructions can be found [here]( http://www.psychocats.net/ubuntu/virtualbox).

** Make sure to give your system plenty of disk space, at least 30 GB, if possible. Don't worry VirtualBox will only actually use what it needs.

Once you've followed the above instructions, start the VM. Open the Devices menu option and click 'Insert guest additions CD image.' You will be prompted to run some software from that image. Follow the instructions and install the guest additions. This will give you better screen resolution.

### Homebrew [OSX only] 
 
Homebrew is a package manager for OSX, which makes installing development software much easier. We will use it to install Sbt and AStyle. You will find it useful in the future for install of other things as well.

* [OSX] Install using the instructions [here](http://brew.sh/)

### XCode [OSX only]

XCode is a development environment for Macs. We will not be using it, but installing it installs a number of useful Unix command line tools. 

* [OSX] Install the most recent version of XCode from [here](https://developer.apple.com/xcode/downloads/)

### Git

* [Ubuntu] Git is pre-installed on Ubuntu.
* [OSX] From terminal: ```brew install git```
* You can test the install of git on your system by running the command `git` from terminal. You should see usage information.
* Finally run the following commands from terminal:<br>
   ```git config --global user.email "your@email.com"```<br>
   ```git config --global user.name "Your Name"```<br>
   (The email should be the same email you used to register your github account)


### Sbt

Sbt is an open source build tool for Scala projects, similar to Maven or Ant. More information can be found [here](https://en.wikipedia.org/wiki/SBT_%28software%29). (You will need this to do the homeworks and projects)

* [OSX]  From terminal: ```brew install sbt```
* [Ubuntu] From terminal:<br>
   ```echo "deb https://dl.bintray.com/sbt/debian/" | sudo tee -a /etc/apt/sources.list.d/sbt.list```<br>
   ```sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 642AC823```<br>
   ```sudo apt-get update```<br>
   ```sudo apt-get install sbt```  
* Confirm success by running the command from terminal: 
    ```sbt    ```
    (Sbt should start. Use `Ctrl+c` to quit or type `exit`.)

** More detailed instructions can be found [here](http://www.scala-sbt.org/release/tutorial/Installing-sbt-on-Linux.html).

### IntelliJ Idea

We will be using
the [IntelliJ Idea Java IDE](https://www.jetbrains.com/idea/). It is
what we will use in class. And I will be demonstrating development
techniques with this IDE that will make your life easier. 

* Sign up for [free student licenses](https://www.jetbrains.com/shop/eform/students) (Reminder: use your NYU email)
* In the meantime, download the [Ultimate Edition Free 30-day trial](https://www.jetbrains.com/idea/download/) of Intellij.
* [Ubuntu] Untar the downloaded archive by clicking it and then using the "Extract" menu item. Extract to location of your choice. Open that location and follow the instructions inside the "Install-Linux-tar.txt" file.
* [OSX] Open the disk image and use the installer.
* When prompted, select "Evaluate for 30 days". Install the license when you get them in an email from Jetbrains.
* During the "Customize" phase on the "*Featured* plugins screen",
  select and install the 'Scala' plugin. It should be in the top left
  corner of this screen. This is necessary to get sbt integration and
  Scala support in Intellij.
* For reference, here is a link to the [Intellij documentation](https://www.jetbrains.com/idea/help/basic-concepts.html).

There are many many free plugins available for Intellij. You should feel free to install anything that sounds useful to you. You can explore what is available from the "Preferences" menu in Intellij.


### Importing a Scala Sbt Project into Intellij

To import the Scala sbt project for Class 1 into Intellij, do the following:

* Open Intellij and click the "Import Project" menu item
  (Alternatively, press Ctrl+Shift+a [Ubuntu] or Command+Shift+a [OSX]
  and type 'import project'. Then select the command 'Import Project'
  from the drop down menu).
  
* Navigate to your cloned repository and select the "class01"
  directory and click "Import".
  
* Click the radio button "Import project from external model".

* Highlight sbt. Click Next.

* Check "Use sbt shell for build and import", and under "Download:
  check "Library sources" and "sbt sources". Do not hit "Finish" yet.
  
* The dropdown for the Project SDK will mostly likely be empty. We
  need to configure a JVM.
  
  * Click "New" and then "JDK". 
  * Most likely IntelliJ will guess correctly where your JDK is. If not..
  * [Ubuntu] it is ```/usr/lib/jvm/java-8-openjdk-amd64```
  * [OSX] Where your JVM is depends on what version of OSX you are
    using. On newer versions of OSX you can use this command to find
    the location of the JDK ```/usr/libexec/java_home -v 1.8```).
  * Select the JDK folder.
    
* Under "JVM Options" below "Global sbt settings", remove the text in
  the field labeled "VM parameters". Click "Finish".

* It may take IntelliJ a few minutes to initialize the project. Future
  project imports will be faster.

* If you are prompted with a message like "Unregistered VCS root
  detected", simply click "Add root".

* Open the worksheet `src/main/scala/Demo.sc` and type in some Scala
  expressions (see below). Alternatively, start the Scala REPL by
  typing `console` in the sbt shell. If the sbt shell is not already
  open, you can open it by pressing Crtl+Shift+s [Ubuntu] or
  Command+Shift+s [OSX].

* Post on Piazza if you need help, most likely others have had the
  same problem and may have figured it out.


## Scala Crash Course

In the following, we assume that you have started the Scala
REPL. Though, (almost) all of these steps can also be done in a Scala
worksheet.

### Expressions, Values, and Types

After you type an expression in the REPL, such as `3 + 4`,
and hit enter:

```scala
scala> 3 + 4
```

The interpreter will print:

```scala
res0: Int = 7
```

This line includes:

* an automatically generated name `res0`, which refers
  to the value resulting from evaluating the expression,
* a colon `:`, followed by the type `Int` of the expression,
* an equals sign `=`,
* the value `7` resulting from evaluating the expression.

The type `Int` names the class `Int` in the
package `scala`. Packages in Scala partition the global
name space and provide mechanisms for information hiding, similar to
Java packages. Values of class `Int` correspond to values of
Java's primitive type `int` (Scala makes no difference
between primitive and object types). More generally, all of Java's
primitive types have corresponding classes in the `scala` package.

We can reuse the automatically generated name `res0` to
refer to the computed value in subsequent expressions (this only works
in the REPL but not in a worksheet):

```scala
scala> res0 * res0
res1: Int = 9 
```

Java's ternary conditional operator `? :` has an equivalent in Scala,
which looks as follows:
```scala
scala> if (res1 > 10) res0 - 5 else res0 + 5
res2: Int = -2
```

In addition to the `? :` operator, Java also has if-then-else
statements. Scala, on the other hand, is a functional language and
makes no difference between expressions and statements: every
programming construct is an expression that evaluates to some
value. In particular, we can use if-then-else expressions where we
would normally use if-then-else statements in Java.
```scala
scala> if (res1 > 2) println("Large!") 
       else println("Not so large!")
res3: Unit = ()
```
In this case, the if-then-else expression evaluates to the value
`()`, which is of type `Unit`. This type indicates
that the sole purpose of evaluating the expression is the side effect
of the evaluation (here, printing a message on standard output). In
other words, in Scala, statements are expressions of type
`Unit`. Thus, the type `Unit` is similar to the
type void in Java (which however, has no values). The value
`()` is the only value of type `Unit`. 

### Names

We can use the `val` keyword to give a user-defined name to
a value, so that we can subsequently refer to it in other expressions:
```scala
scala> val x = 3
x: Int = 3
scala> x * x
res0: Int = 9
```
Note that Scala automatically infers that `x` has type
`Int`. Sometimes, automated type inference fails, in which
case you have to provide the type yourself. This can be done by
annotating the declared name with its type:
```scala
scala> val x: Int = 3
x: Int = 3 
```
A `val` is similar to a `final` variable in
Java. That is, you cannot reassign it another value:
```scala
scala> x = 5
<console>>:8: error: reassignment to val
       x = 5
         ^
```
Scala also has an equivalent to standard Java variables, which can be
reassigned. These are declared with the `var` keyword
```scala
scala> var y = 5
y: Int = 5
scala> y = 3
y: Int = 3
```
The type of a variable is the type inferred from its initialization
expression. It is fixed throughout the lifetime of the
variable. Attempting to reassign it to a value of incompatible type results in a type error:
```scala
scala> y = "Hello"
<console>:8: error: type mismatch;
 found   : String("Hello")
 required: Int
       y = "Hello"
           ^
```
However, for the time being we will pretend that variables do not
exist. Repeat after me: `val`s are gooood! `var`s
are baaaad! 

### Functions

Here is how you write functions in Scala:

```scala
scala> def max(x: Int, y: Int): Int = {
         if (x > y) x
         else y
       }
max: (x: Int, y: Int)Int
```

Function definitions start with `def`, followed by the
function's name, in this case `max`. After the name comes a
comma separated list of parameters enclosed by parenthesis, here
`x` and `y`. Note that the types of parameters
must be provided explicitly since the Scala compiler does not infer
parameter types. The type annotation after the parameter list gives
the result type of the function. The result type is followed by the
equality symbol, indicating that the function returns a value, and the
body of the function which computes that value. The expression in the
body that defines the result value is enclosed in curly braces.

If the defined function is not recursive, as is the case for
`max`, the result type can be omitted because it is
automatically inferred by the compiler. However, it is often helpful
to provide the result type anyway to document the signature of the
function. Moreover, if the function body only consists of a single
expression or statement, the curly braces can be omitted. Thus, we
could alternatively write the function max like this:

```scala
scala> def max(x: Int, y: Int) = if (x > y) x else y
max: (x: Int, y: Int)Int
```

Once you have defined a function, you can call it using its name:
```scala
scala> max(6, 3)
res3: Int = 3
```

Naturally, you can use values and functions that are defined outside of a function's body in the function's body:
```scala
scala> val pi = 3.14159
pi: Double = 3.14159

scala> def circ(r: Double) = 2 * pi * r
circ: (r: Double)Double
```

You can also nest value and function definitions:
```scala
scala> def area(r: Double) = {
         val pi = 3.14159
         def square(x: Double) = x * x
         pi * square(r)
       }
area:(r: Double)Double
```

Recursive functions can be written as expected. For example, the
following function `fac` computes the factorial numbers:
```scala
scala> def fac(n: Int): Int = if (n <= 0) 1 else n*fac(n-1)
fac: (n: Int)Int

scala> fac(5)
res4: Int = 120
```

### Scopes

Scala's scoping rules are almost identical to Java's:

```scala
val a = 5
// only a in scope
{
  val b = 4
  // b and a in scope

  def f(x: Int) = {
    // f, x, b, and a in scope
    a * x + b 
  }
  // f, b, and a in scope
}
// only a in scope
```
There is one difference to Java, though. Scala allows you to redefine names in nested scopes, thereby shadowing definitions in outer scopes.
```scala
val a = 3
{
  val a = 4 // shadows outer definition of a
  a + a     // yields 8
}
```
However, as in Java, you cannot redefine a name in the same scope:
```scala
  val a = 3
  val a = 4 // does not compile
```

### Tuples

Scala provides ways to create new compound data types without
requiring you to define simplistic data-heavy classes. One of the most
useful of these constructs are *tuples*. A tuple combines a fixed
number of items together so that they can be passed around as a
whole. The individual items can have different types. For example,
here is a tuple holding an `Int` and a `String`:
```scala
scala> val p = (1, "banana")
p: (Int, String) = (1, "banana")
```

and here is a tuple holding three items: two `String`s and
the console:
```scala
scala> val q = ("apple", "pear", Console)
q: (String, String, Console.type) = (apple, pear, scala.Console$@47fbb6b9)
```
To access the items of a tuple, you can use method `_1` to
access the first item, method `_2` to access the second,
and so on:

```scala
scala> p._1
res5: Int = 1

scala> p._2
res6: String = banana
```

Additionally, you can assign each element of the tuple to its own
`val`:

```scala
scala> val (fst, snd) = p
fst: Int = 1
snd: String = banana
```

Be aware that tuples are not automatically decomposed when you pass
them to functions:

```scala
def f(x: Int, s: String) = x

f(p._1, p._2) // works
f(p) // does not compile

def g(p: (Int, String)) = p._1

g(p) // works
g((1, "banana")) // works
g(1, "banana") // works
```

### Recursion

We will often use recursion rather than loops to express unbounded
computations. In the following, we study how recursive functions are
evaluated. We will further see that there is a close connection
between certain recursive functions and loops in imperative programs.

#### Evaluating Recursive Functions

Consider the following function which computes the sum of the integer
values in the interval given by the parameters `a` and
`b`.

```scala
def sum(a: Int, b: Int): Int = {
  if (a < b) a + sum(a + 1, b) else 0
}
```

How are calls to such functions evaluated? In general, we can think of
the evaluation of a Scala expression as a process that rewrites
expressions into simpler expressions. This rewriting process
terminates when we obtain an expression that cannot be further
simplified, e.g., an integer number. Expressions that cannot be
simplified further are called `values`. Concretely, if we have a
function call such as `sum(1 + 1, 0 + 2)`, we proceed as follows to
compute a value using rewriting:

* First, we rewrite the call expression by rewriting the arguments
  of the call until they are reduced to values. In our example,
  this step yields the simplified call expression `sum(2, 2)`.

* Next, we replace the entire call expression by the body of the
  function. At the same time, we replace the formal parameters
  occurring in the function body by the actual arguments of the
  call. In our example, this step yields the expression
  
  ```scala
  if (2 < 2) 2 + sum(2 + 1, 2) else 0
  ```
  
* Finally, we continue rewriting the function body recursively in
  the same manner until we obtain a value that cannot be simplified
  further. In our example, we finally obtain the value `0`.

Here is how we compute the value of `sum(1, 4)` using rewriting:

```scala
sum(1, 4) 
-> if (1 < 4) 1 + sum(1 + 1, 4) else 0
-> if (true) 1 + sum(1 + 1, 4) else 0
-> 1 + sum(1 + 1, 4)
-> 1 + sum(2, 4)
-> 1 + (if (2 < 4) 2 + sum(2 + 1, 4) else 0)
-> 1 + (if (true) 2 + sum(2 + 1, 4) else 0)
-> 1 + (2 + sum(2 + 1, 4))
-> 1 + (2 + sum(3, 4))
-> 1 + (2 + (if (3 < 4) 3 + sum(3 + 1, 4) else 0))
-> 1 + (2 + (if (true) 3 + sum(3 + 1, 4) else 0))
-> 1 + (2 + (3 + sum(3 + 1, 4)))
-> 1 + (2 + (3 + sum(4, 4)))
-> 1 + (2 + (3 + (if (4 < 4) 4 + sum(4 + 1, 4) else 0)))
-> 1 + (2 + (3 + (if (false) 4 + sum(4 + 1, 4) else 0)))
-> 1 + (2 + (3 + 0))
-> 1 + (2 + 3)
-> 1 + 5
-> 6 
```

#### Termination

Does the rewriting process always terminate? Consider the following
recursive function:

```scala
def loop(x: Int): Int = loop(x)
```
If we evaluate, e.g., the call `loop(0)`, we obtain an infinite
rewriting sequence:

```scala
loop(0) -> loop(0) -> loop(0) -> ...
```

In order to guarantee termination of a recursive function, we have to
make sure that each recursive call makes progress according to some
progress measure. For example, in the recursive call to the function
`sum` in our example above, the difference `b - a`
between the arguments decreases with every recursive call. This means
that `b - a` will eventually reach 0 or become negative. At
this point, we take the `else` branch in the body of
`sum` and the recursion stops. For our non-terminating
function `loop`, it is impossible to find such a progress measure.

#### Tail Recursion

If we apply the function `sum` to larger intervals we
observe the following:

```scala
scala> sum(1, 10000)
java.lang.StackOverflowError
...
```

The problem is that a call to a function requires the Scala runtime
environment to allocate stack space that stores the arguments of the
call and any intermediate results obtained during the evaluation of
the function body in memory. For the function `sum`, the
intermediate results of the evaluation must be kept on the stack until
the final recursive call returns. We can see this nicely in the
rewriting steps for the call `sum(1, 4)`. The length of the
expression that we still need to simplify grows with each recursive
call:

```scala
sum(1, 4) 
-> ...
-> 1 + sum(2, 4)
-> ...
-> 1 + (2 + sum(2 + 1, 4))
-> ...
-> 1 + (2 + (3 + sum(2 + 1, 4)))
-> ...
-> 6 
```

Only when the final call to `sum` has returned, can we simplify
the entire expression to a value.

The stack space that is needed for evaluating a call `sum(a, b)` grows
linearly with the recursion depth, which is given by the size of the
interval `b - a`. Since the Scala runtime environment only
reserves a relatively small amount of memory for the call stack, a
call to `sum` for large interval sizes runs out of stack
space. This is signaled by a `StackOverflowError` exception.

Can we implement the function `sum` so that it only
requires constant space? To this end, consider the following
*imperative* implementation of `sum`, which uses a
`while` loop and mutable variables to perform the summation:

```scala
def sumImp(a: Int, b: Int): Int = {
  var acc = 0
  var i = a
  while (i < b) {
    acc = i + acc
    i = i + 1
  }
  acc
}
```

This implementation requires only constant space, since it involves
only a single function call. Moreover, the execution of a single loop
iteration for the summation does not allocate memory that persists
across iterations. The intermediate results are stored in the
variables `i` and `acc`, which are reused in each
iteration. Unfortunately, this implementation uses mutable
variables, which makes it more difficult to reason about the
correctness of the code. However, we can turn the imperative
`while` loop into a recursive function by hoisting the loop
counter `i` and accumulator `acc` to function
parameters:

```scala
def loop(acc: Int, i: Int, b: Int): Int = {
  if (i < b) loop(i + acc, i + 1, b) else acc
}

def sumTail(a: Int, b: Int): Int = {
  loop(0, a, b)
}
```

Note how the function `loop` closely mimics the
`while` loop in the imperative implementation without
relying on mutable variables. We simply pass the new values that we
obtain for the loop counter `i` and the accumulator
`acc` to the recursive call.

The function `loop` has an important property: the recursive
call to `loop` in the `then` branch of the conditional
expression is the final computation that is performed before the
function returns. That is, in the recursive case, the function
directly returns the result of the recursive call. We refer to
functions in which all recursive calls are of this form as
*tail-recursive* functions. Contrast the new implementation of
`sum` with our original implementation, which added
`a` to the result of the recursive call and was therefore
not tail-recursive. The tail-recursive implementation has an
interesting effect on our rewriting-based evaluation strategy:

```scala
sumTail(1, 4) 
-> loop(0, 1, 4)
-> if (1 < 4) loop(1 + 0, 1 + 1, 4) else 0
-> if (true) loop(1 + 0, 1 + 1, 4) else 0
-> loop(1, 2, 4)
-> if (2 < 4) loop(2 + 1, 2 + 1, 4) else 1
-> if (true) loop(2 + 1, 2 + 1, 4) else 1
-> loop(3, 3, 4)
-> if (3 < 4) loop(3 + 3, 3 + 1, 4) else 3
-> if (true) loop(3 + 3, 3 + 1, 4) else 3
-> loop(6, 3, 4)
-> if (4 < 4) loop(4 + 6, 4 + 1, 4) else 6
-> if (false) loop(4 + 6, 4 + 1, 4) else 6
-> 6
```

Observe that the size of the expressions that we obtain throughout the
evaluation does not grow with the recursion depth. This is because the
tail-recursive call to `loop` is the final computation that is performed
in the body of `loop`, before the function returns.

To simplify our implementation, we can move the declaration of the
function `loop` inside the body of the function
`sumTail`:

```scala
def sumTail(a: Int, b: Int): Int = {
  def loop(acc: Int, i: Int): Int = {
    if (i < b) loop(i + acc, i + 1) else acc
  }
  loop(0, a)
}
```

Note that in this version, we have dropped the third parameter
`b` of the first version of the function `loop`
since it is just passed to the recursive call without change. The
occurrence of `b` in the body of the new nested version of
`loop` now always refers to the parameter `b` of the
outer function `sumTail`.

For tail-recursive functions, the stack space that is allocated for
the current call can be reused by the recursive call. In particular,
the memory that is needed to store the arguments of the current call
can be reused to store the arguments of the recursive call. By reusing
the current stack space, we effectively turn the recursive function
back into an imperative loop. This optimization is referred to as
*tail call elimination*. Most compilers for functional languages,
including the Scala compiler, automatically eliminate tail
calls. Thus, tail-recursive functions are guaranteed to execute in
constant stack space. We can test this feature by rerunning the
tail-recursive version of `sum` for large interval sizes:

```scala
scala> sumTail(1, 10000)
res0: Int = 49995000
```

This time the function terminates normally without throwing an exception.

With tail call elimination we get the best of both worlds: we obtain
the efficiency of an imperative implementation and the simplicity of a
functional implementation. When you want to write a tail-recursive
function, it is often useful to first write the function using a
`while` loop and then transform the loop into a
tail-recursive function, as we have done above. Once you get more used
to functional programming, you will find writing tail-recursive
functions as natural as writing loops.

If you are in doubt whether a recursive function that you wrote is
tail-recursive, you can add the `@tailrec` annotation to the
declaration of the function:

```scala
import scala.annotation.tailrec
...
def sumTail(a: Int, b: Int): Int = {
  @tailrec def loop(acc: Int, i: Int): Int = {
    if (i < b) loop(i + acc, i + 1) else acc
  }
  loop(0, a)
}
```

If the compiler fails to apply tail call elimination to a
`@tailrec` annotated function, then it will issue a warning:

```scala
@tailrec def sum(a: Int, b: Int): Int = {
  if (a < b) a + sum(a + 1, b) else 0
}

error: could not optimize @tailrec annotated method sum: 
it contains a recursive call not in tail position
       if (a < b) a + sum(a + 1, b) else 0
                    ^
```

You may wonder whether non-tail-recursive functions should be avoided
at all costs. This depends on the function. Often, tail-recursive
functions are harder to understand than their non-tail-recursive (The
same is true for loops in imperative programs.). If you know that the
recursion depth of your function will be small in practice, you may
want to write the function without tail-recursion. If you are in
doubt, you should value the clarity of your code higher than its
efficiency. When you observe that your code is inefficient, you can
still optimize it later.

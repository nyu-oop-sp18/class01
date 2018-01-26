import scala.annotation.tailrec

1 + 3

val x = 1 + 3

var y = 4

{
  val x = y + y

  x
}

def max(x: Int, y: Int): Int =
  if (x >= y) x else y

max(3, 4)

def fac(x: Int): Int =
  if (x <= 1) 1 else x * fac(x - 1)

def sum(a: Int, b: Int): Int =
  if (a < b) a + sum(a + 1, b) else 0

sum(1, 4)

// the following fails with a stack overflow
//sum(1, 100000)

def sumLoop(a: Int, b: Int): Int = {
  var i = a
  var acc = 0

  while (i < b) {
    acc = i + acc
    i = i + 1
  }

  acc
}

sumLoop(1, 100000)

def sumTail(a: Int, b: Int): Int = {

  @tailrec def loop(acc: Int, i: Int): Int = {
    if (i < b) loop(i + acc, i + 1) else acc
  }

  loop(a, 0)
}

sumTail(1, 100000)

val p = (5, "banana")

object Greeter extends App {
  if (args.length > 0) {
    println(s"Hello ${args(0)}!")
  } else {
    println("Hello World!")
  }

  // to demonstrate unit testing
  def max(x: Int, y: Int): Int =
    if (x >= y) x else y

}

import org.scalatest.FlatSpec
import Greeter._

class GreeterTest extends FlatSpec {

  "max" should "return maximu of the two arguments" in {
    assert(max(3, 4) === 3)
  }

}

import org.scalatest.FlatSpec
import Greeter._

class GreeterTest extends FlatSpec {

  "max" should "return maximum of the two arguments" in {
    assert(max(3, 4) === 3)
  }

}

import collection.mutable.Stack
import org.scalatest._
import flatspec._
import matchers._

class ExampleSpec extends AnyFlatSpec with should.Matchers {

  "A Cell" should "change it state to alive" in {
    var state = 1;
    var neighbors = 2
    Gol.Gol.setNewState(state, neighbors ) should be (1)
  }

  "A Cell" should "change it state to dead" in {
    var state = 1;
    var neighbors = 2
    Gol.Gol.setNewState(state, neighbors ) should be (1)
  }

  "A live cell" should "Die if it has fewer than 2 neighbors due to underpopulation" in {
    var state = 1
    var neighbors = 1
    Gol.Gol.setNewState(state, neighbors) should be (0)
  }

  "A live cell" should "Die if it has more than 3 neighbors due to overpopulation" in {
    var state = 1
    var neighbors = 4
    Gol.Gol.setNewState(state, neighbors) should be (0)
  }

  "A live cell" should "Stay alive if it has exactly 2 neighbors" in {
    var state = 1
    var neighbors = 2
    Gol.Gol.setNewState(state, neighbors) should be (1)
  }

  "A live cell" should "Stay alive if it has exactly 3 neighbors" in {
    var state = 1
    var neighbors = 3
    Gol.Gol.setNewState(state, neighbors) should be (1)
  }

  "A dead cell" should "Stay become alive if it has exactly 3 neighbors" in {
    var state = 0
    var neighbors = 3
    Gol.Gol.setNewState(state, neighbors) should be (1)
  }

}


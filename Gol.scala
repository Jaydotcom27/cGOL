package Gol

object Gol extends App {
  val rows: Int = 10
  val cols: Int = 10
  var r = scala.util.Random
  var arr = Array.ofDim[Int](cols, rows)
  for (i <- 0 to cols - 1){
    for (j <- 0 to rows - 1){
      if( i == 0 || i == cols - 1 || j == 0 || j == rows -1){
        arr(i)(j) == 0
      } else {
        arr(i)(j) = r.nextInt(2)
      }
    }
  }
  for (j <- 0 to 5){
    setUp()
  }

  def setUp(): Unit = {
    arr foreach { row => row foreach print; println }
    println("--------------------------------")
    var next = Array.ofDim[Int](cols, rows)
    for (i <- 0 to cols - 1){
      for (j <- 0 to rows - 1){
        var state = arr(i)(j)
        if( i == 0 || i == cols - 1 || j == 0 || j == rows -1){
          next(i)(j) == state
        } else {
          var neighbors = countNeighbors(arr, i, j)
          next(i)(j) = setNewState(state, neighbors)
        }
      }
    }
    arr = next
  }

  def setNewState(state: Int, neighbors: Int): Int = {
    if (state == 1 && neighbors < 2){
      return 0
    } else if (state == 1 && neighbors > 3) {
      return 0
    } else if (state == 1 && (neighbors == 2 || neighbors == 3))  {
      return 1
    } else if (state == 0 && neighbors == 3) {
      return 1
    } else {
      return state
    }
  }

  def countNeighbors(grid: Array[Array[Int]], x: Int, y: Int): Int ={
    var sum = 0
    for (i <- 0 to 2 - 1){
      for (j <- 0 to 2 - 1){
        sum += grid(x + i)(y + j)
      }
    }
    sum -= grid(x)(y)
    return sum
  }

}

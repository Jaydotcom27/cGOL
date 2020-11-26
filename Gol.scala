package Gol

object Gol extends App {
  def setNewState(state: Int, neighbors: Int): Int = {
    if (state == 1 && neighbors < 2){
      return 0
    } else if (state == 1 && neighbors > 3) {
      return 0
    } else if (state == 1 && neighbors == 2)  {
      return 1
    } else  {
      return 3
    }
  }

}

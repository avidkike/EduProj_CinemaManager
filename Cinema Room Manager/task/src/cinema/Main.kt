package cinema

class Main {

    companion object {
        @JvmStatic fun main(args: Array<String>) {

            var x: Int? = null

            println("Enter the number of rows:")
            val rows = readln().toInt()
            println("Enter the number of seats in each row:")
            val seats = readln().toInt()

            val cinema = Cinema(rows, seats)

            while (x != 0) {
                cinema.showMenu()
                x = cinema.execMenu(point = readln().toInt())
            }
        }
    }
}
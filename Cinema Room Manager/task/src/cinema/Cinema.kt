package cinema

class Cinema (rows: Int, seats: Int) {

    val rows = rows
    val seats = seats
    var occupSeats: MutableList<Seat> = mutableListOf()

    fun showSeats(): Int {

        println("Cinema:")
        for (i in 0..rows) {

            if (i != 0) {
                print("$i ")
            } else {
                print("  ")
            }

            for (j in 1..seats) {
                if (i == 0) {
                    print("$j ")
                } else {
                    if (occupSeats.contains(Seat(i, j))) {
                        print("B ")
                    } else {
                        print("S ")
                    }
                }
            }
            println()
        }
        return 1
    }

    fun buyTicket(): Int {

        var i: Int? = null

        while (i != 0 || (rows * seats) >= (occupSeats.lastIndex - 1)) {
            println("Enter a row number:")
            val row = readln().toInt()
            println("Enter a seat number in that row:")
            val seat = readln().toInt()

            if (row > rows || seat > seats) {
                println("Wrong input!")
                continue
            }

            val price = calcPrice(row)

            println("Ticket price: $$price")

            if (!occupSeats.contains(Seat(row, seat))) {
                occupSeats += listOf(Seat(row, seat))
                break
            } else {
                println("That ticket has already been purchased!")
                continue
            }
        }
        return 2
    }

    fun calcPrice(row: Int): Int {
        if (rows * seats <= 60) {
            return 10
        } else {
            return if (row <= rows / 2) 10 else 8
        }
    }

    fun execMenu(point: Int): Int {
        return when (point) {
            1 -> showSeats()
            2 -> buyTicket()
            3 -> showStatistics()
            else -> 0
        }
    }

    fun showStatistics(): Int {
        var currentIncome = 0
        var totalIncome = 0
        //purchased tickets
        println("Number of purchased tickets: ${occupSeats.size}")

        //percatage of purchased tickets
        println("Percentage: ${"%.2f".format((occupSeats.size).toFloat() / (rows * seats).toFloat() * 100)}%")

        //Current income
        for (i in 0..(occupSeats.size-1)) {
            currentIncome += calcPrice(occupSeats[i].x)
        }
        println("Current income: $$currentIncome")

        //total income
        if (rows * seats <= 60) {
            totalIncome = rows * seats * 10
        } else {
            for (i in 1..rows) {
                if (i <= rows / 2) {
                    totalIncome += seats * 10
                } else {
                    totalIncome += seats * 8
                }
            }
        }
        println("Total income: $$totalIncome")

        return 3
    }

    fun showMenu() {
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")
    }
}
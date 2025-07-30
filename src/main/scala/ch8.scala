package ch8

object Exercises extends App{
    //Ex1._do()

    object Ex1{
        class BankAccount(initialBalance: Double) {
            protected var balance = initialBalance
            def deposit(amount: Double) = { balance += amount; balance }
            def withdraw(amount: Double) = { balance -= amount; balance }
            def getBalance = balance
        }

        class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
            override def deposit(amount: Double): Double = { balance += amount - 1; balance }
            override def withdraw(amount: Double): Double = { balance -= amount + 1; balance }
        }

        def _do() ={
            val chAcc = CheckingAccount(5000.00)
            chAcc.withdraw(1)
            chAcc.deposit(1)
            println(chAcc.getBalance == 4998.00)
        }
    }

    object Ex2{
        import Ex1.BankAccount
        class SavingsAccount(initialBalance: Double, monthlyPercent: Double) extends BankAccount(initialBalance){
            var freeTransactions = 3

            def earnMonthlyInterest = {
                balance *= monthlyPercent + 1
                freeTransactions = 3
            }

            override def deposit(amount: Double): Double = {
                if (freeTransactions > 0) {
                    freeTransactions -= 1
                    super.deposit(amount)
                }
                else {
                    balance -= 1
                    super.deposit(amount)
                }
            }

            override def withdraw(amount: Double): Double = {
                if (freeTransactions > 0) {
                    freeTransactions -= 1
                    super.withdraw(amount)
                }
                else {
                    balance -= 1
                    super.withdraw(amount)
                }
            }            
        }
    }

    object Ex3{
        //hierarchy something-something
    }

    object Ex4{
        abstract class Item{
            def price: Double
            def description: String
        }

        class SimpleItem(val price: Double = 0.0, val description: String = "") extends Item{
            override def toString(): String = s"$description"
        }

        class Bundle(val items: List[Item]) extends Item{
            var price = items.map(_.price).sum
            var description = items.map(_.description).mkString(",")

            def add(other: Item) = {
                price += other.price
                description += other.toString()
            }

            override def toString(): String = s"{$description}"
        }
    }

    object Ex5{
        class Point(val x: Double = 0.0, val y: Double = 0.0)
        
        class LabeledPoint(val label: String = "", x: Double = 0.0, y: Double = 0.0) extends Point(x, y)
    }

    object Ex6{
        import Ex5.Point
        abstract class Shape{
            def centerPoint: Point
        }

        class Rectangle(val point: Point, width: Double, height: Double) extends Shape{
            def centerPoint: Point = Point(point.x + width/2, point.y + height/2)
        }

        class Circle(val centerPoint: Point, val rad: Double) extends Shape{

        }

    }

    object Ex7{
        import java.awt.Rectangle
        class Square(x: Int, y: Int, width: Int) extends Rectangle(x, y, width, width){
            def this(width: Int) = {
                this(0, 0, width)
            }

            def this() = {
                this(0, 0, 0)
            }
        }
    }
    
    object Ex8{

    }

    object Ex9{

    }

    object Ex10{

    }

    object Ex11{
        //bit-shift one int to upper register, combine with bitwise or
    }
}

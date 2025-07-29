import BigInt.probablePrime
import scala.util.Random
import scala.compiletime.ops.string
import scala.annotation.switch
import java.time.LocalDate
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable
import java.util.Scanner
import scala.collection.mutable.LinkedHashSet
import java.util.Calendar
import scala.jdk.CollectionConverters
import java.beans.BeanProperty

//import scala.collection.StringOps

@main def main(): Unit = {
  /*println("Hello world!")
  println(msg)*/
  
  def chapter1(): Unit =
    rounding_error()
    val multiple_strings = "string" * 3
    val big_exp = BigInt(2).pow(1024)  
    val prob_prime = probablePrime(100, Random)
    val random_name = prob_prime.toString(36)
    val first_symbol = random_name(0)
    val last_symbol = random_name(random_name.length()-1)
    println("-"*10)

  def chapter2(): Unit =
    val sign_twenty = signum(20)
    val empty_brackets = {} //Unit
    var y = 0
    val x: Unit = y = 1
    for (i <- Range(10, -1, -1)) println(i)
    countdown(10)
    countdown(-10)
    countdown(0)
    println(mult_Unicode("Hello"))
    println(mult_without_for("Hello"))
    println(mult_recursive("Hello"*))
    println(xValue(10, 2))
    println(xValue(10, 4))
    println(xValue(10, -1))
    println(xValue(5, -2))
    val year = "1998"; val month = "10"; val day = "3" 
    println(date"$year-$month-$day".getDayOfYear())
    println("-"*10)

  def chapter3(): Unit =
    val n = 10
    val a = Range(0, n).toArray
    val a_swapped = (for (i <- Range(0, a.length - a.length%2)) yield if (i % 2 == 0) a(i+1) else a(i-1)).toArray
    val buffer = ArrayBuffer[Int]()
    for (i <- a.indices if a(i) > 0) buffer.append(i) 
    for (i <- a.indices if a(i) < 0) buffer.append(i) 
    for (i <- a.indices if a(i) == 0) buffer.append(i) 
    val new_a = for (i <- buffer) yield a(i)
    val array_of_double : Array[Double] = Array()
    val avrg_double = array_of_double.map(_/2).sum
    val reversesorted_array = a.sortWith(_ > _)
    val sort_buffer = buffer.sortWith(_ > _)
    for (i <- a.distinct) print(i)
    println()
    val neg_indices = for (i <- buffer.indices if buffer(i) < 0) yield i
    for (i <- neg_indices.drop(1)) buffer.remove(i)
    val new_positions = ArrayBuffer[Int](buffer.indices*)
    for (i <- neg_indices.drop(1); j <- Range(i+1, buffer.length)) new_positions(j) -= 1
    for (i <- buffer.indices.drop(neg_indices.applyOrElse(0, _ => neg_indices.length))) buffer(new_positions(i)) = buffer(i) 
    buffer.take(new_positions(buffer.length - 1))
    val timezones = java.util.TimeZone.getAvailableIDs()
    timezones.filter(tz => tz.contains("America")).map(tz => tz.drop(8)).foreach(tz => println(tz))

  def chapter4(): Unit = {
    val prices = mutable.Map("First" -> 450.00, "Second" -> 5000.00, "Third" -> 1500.20)
    val sale_prices = prices.map[String, Double]((k, v) => (k, v*0.9))
    val words = mutable.Map[String, Int]()
    var immutable_words = Map[String, Int]()
    val treemap = new java.util.TreeMap[String, Int]()
    val sorted_words = mutable.SortedMap.from(words)
    val in = new java.util.Scanner(new java.io.File(raw"C:\Users\smesh\scala_book\newfile.txt"))
    while (in.hasNext()) {
      val str = in.next()
      if (words.contains(str)) words(str) = words(str) + 1 
      else words.addOne(str, 1)

      if (immutable_words.contains(str)) immutable_words = immutable_words.updated(str, immutable_words(str) +1) 
      else immutable_words += (str, 1)

      if (treemap.containsKey(str)) treemap.put(str, treemap.get(str) + 1)
      else treemap.put(str, 1)
      
      if (sorted_words.contains(str)) sorted_words(str) = sorted_words(str) + 1 
      else sorted_words.addOne(str, 1)

    }
    
    //for ((k, v) <- sorted_words) println(s"$k - $v times")
    
    val linked_weekdays = LinkedHashSet(
      "Monday" -> Calendar.MONDAY, 
      "Tuesday" -> Calendar.TUESDAY, 
      "Wednesday" -> Calendar.WEDNESDAY, 
      "Thursday" -> Calendar.THURSDAY,
      "Friday" -> Calendar.FRIDAY,
      "Saturday" -> Calendar.SATURDAY,
      "Sunday" -> Calendar.SUNDAY)
    
    //for (day <- linked_weekdays) println(s"${day._1} is a ${day._2} day")
    
    val sys_props = scala.jdk.javaapi.CollectionConverters.asScala(System.getProperties())
    val max_strlen = sys_props.keys.maxBy(_.length()).length()
    for (pr <- sys_props) println(pr._1 + " " * (max_strlen - pr._1.length() + 1) + "|" + pr._2)

    def minmax(a: Array[Int]): (Int, Int) = (a.min, a.max)
    val min_max = minmax(Array(1,2,3,4,5,6,7,8,9))
    
    def lteqgt(values: Array[Int], v: Int) : (Int, Int, Int) = 
      (values.count(_ < v), values.count(_ == v), values.count(_ > v))
    val triplet_v = lteqgt(Array(1,2,3,4,5,6,7,8,9), 4)

    val zipped_hw = "Hello".zip("World")
    //difference between strings
    val aaaaaaaa = 1


  }

  def chapter5(): Unit = {
    class Counter {
      private var value = 0
      def increment() = { if (value != Int.MaxValue) value += 1 } 
      def current = value
    }

    class BankAccount(private var balance: Double = 0.0) {
      def deposit(amount: Int) = balance += amount
      def withdraw(amount: Int) = if (balance - amount >= 0) balance -= amount
    }

    class Time(val hours: Int = 0, val minutes: Int = 0) {
      def before(other: Time) = {
        hours*60 + minutes < other.hours*60 + other.minutes
      }
    }

    class Time2(val hours: Int = 0, val minutes: Int = 0) {
      private val all_minutes = hours*60 + minutes

      def before(other: Time2) = {
        all_minutes < other.all_minutes
      }
    } 

    val timeee = new Time2(10, 10)

    class Student(@BeanProperty var name: String, @BeanProperty var id: Long)
    
    class Person(private var _age: Int){
      def age = if (_age < 0) 0 else _age
      def age_=(newvalue: Int) = {
        if (newvalue > _age) _age = newvalue
      }
    }
  }

  def chapter6(): Unit = {
    object Origin extends java.awt.Point{}
    
    Origin.move(2, 2)

    object PlayingCards extends Enumeration{
      type PlayingCards = Value
      val hearts = Value("\u2665")
      val diamonds = Value("\u2666")
      val spades = Value("\u2660")
      val clubs = Value("\u2663")
    }

    for (c <- PlayingCards.values) println(c)
    def is_red(c: PlayingCards.type) = {
      if (c == PlayingCards.diamonds || c == PlayingCards.hearts)
        true 
      else
        false
    }

    object RGBCube extends Enumeration{
      val r = Value(0xff0000, "red")
      val g = Value(0x00ff00, "green")
      val u = Value(0x0000ff, "blue")
      val rg = Value(0xffff00, "red-green")
      val ru = Value(0xff00ff, "red-blue")
      val gu = Value(0x00ffff, "green-blue")
      val b = Value(0x000000, "black")
      val w = Value(0xffffff, "white")
    }
  }

  chapter6()

}

implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
  def date(args: Any*): LocalDate = {
    //todo: throw if args.length > 3 or args not int or if sc.parts contains not ("-" or "")
    LocalDate.of(args(0).toString.toInt, args(1).toString.toInt, args(2).toString.toInt)
  }
}

def xValue(x: Double, n: Int): Double = {
  var doub_le = 0.0
  n match {
    case a if a > 0 => {if (n % 2 == 0) doub_le = math.pow(xValue(x, n/2), 2) else doub_le = x * xValue(x, n-1)}
    case a if a < 0 => {doub_le = 1 / xValue(x, -n)}
    case a if a == 0 => {doub_le = 1}
  }
  doub_le
}

def mult_recursive(str: Char*) : BigInt = {
  var res: BigInt = 1
  if (str.length > 0) res *= (str.head.intValue * mult_recursive(str.tail*))
  res
}

def mult_without_for(str: String) : BigInt = {
  var res:BigInt = 1
  str.foreach(a => res *= a.intValue)
  res
}

def mult_Unicode(str: String) : BigInt = {
  var res : BigInt = 1
  for (chr <- str) res = res * chr.intValue
  res
}

def countdown(n: Int) = {
  if (n > 0) for (i <- Range(n, -1, -1)) print(i + " ")
  else if (n < 0) for (i <- Range(n, 1, 1)) print(i + " ")
  else print(0)
  println()
}
def signum(a: Int) = {
  if (a < 0) -1 else if (a == 0) 0 else 1
}



def rounding_error(): Unit =
  val three = 3
  val val1 = math.sqrt(three)
  val res = math.pow(val1, 2)
  println(res)

def msg = "I was compiled by Scala 3. :)"
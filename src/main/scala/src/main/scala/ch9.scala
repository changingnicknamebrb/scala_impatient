package ch9

import java.io.File


object Exercises extends App{
    object Ex1{
        import scala.io.Source
        import java.io.PrintWriter
        
        
        val file = new File(raw"C:\Users\smesh\scala_book\src\main\resources\fortesting.txt")
        //println(file.createNewFile())
        //println(file.canWrite())
        //println(file.exists())
        val source = Source.fromFile(file)
        val reverse_string = source.getLines.toArray.reverse.mkString("\n")
        val writer = new PrintWriter(file)
        writer.write(reverse_string)
        source.close(); writer.close()
    }
    
    object Ex2{
        //tab size = 4 on my machine
        //so just read a string and swap \t to 4 spaces
    }

    object Ex3{
        import scala.io.Source
        import scala.collection.mutable.ArrayBuffer
        val file = new File(raw"C:\Users\smesh\scala_book\src\main\resources\fortesting.txt")
        val source = Source.fromFile(file)
        var lines = source.mkString
        val a = lines.split("\\s").filter(_.length >= 12).mkString(" ")
        val b = """\w{12,}""".r.findAllIn(lines).mkString(" ")
        println(a)
        println(b)
        //print(source.mkString.split("\\s").filter(_.length >= 12).mkString(" ")))
    }

    object Ex4{
        import scala.io.Source
        val file = new File(raw"C:\Users\smesh\scala_book\src\main\resources\numbers.txt")
        val source = Source.fromFile(file)
        val numbers = source.getLines().map(_.toDouble).toArray
        //if numbers are multiple in one Line -> """[0-9\.]+""" regex findall from source _.toDouble toArray
        println(numbers.max)
        println(numbers.min)
        println(numbers.sum)
        println(numbers.sum / numbers.length)
    }
    
    object Ex5{
        //"%7d  ".format(number) + 1/number
    }

    object Ex6{
        //     raw"/".+\""
    }

    object Ex7{
        //
        //all but ^\d+?\.\d+$
    }
    
    object Ex8{
        //<img[^>]+src=\"([^"]+) regex for src of img
    }

    object Ex9{

    }
}

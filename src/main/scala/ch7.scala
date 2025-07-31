package ch7

package com{
    package horstmann{
        object TheString{
            val name = "Name"
        }
    }

    package com{
        package horstmann{
            object TheString extends App{
                val name = "Name"
                assert(com.horstmann.TheString.name == ch7.com.horstmann.TheString.name)

            }
        }
    }
}

package com.horstmann.impatient{
    class Names{
        //val name = TheString.name
    }
}

package com{
    package horstmann{
        package impatient{
            class Names2{
                val name = TheString.name
            }
        }
    }
}

package Ex3{
    package random{
        class random{
            val a = BigInt(1664525)
            val b = BigInt(1013904223)
            val n = 32
            var previous = 1
            def nextInt(): Int = {
                previous = ((previous * a + b) % BigInt(2).pow(n)).toInt
                previous
            }

            def nextDouble(): Double = {
                nextInt().toDouble
            }
            
            def setSeed(seed: Int): Unit = {
                previous = seed
            }

        }
    }
}




object Exercises extends App{
    
    object Ex1{
        //done above
    }

    object Ex2{
        def _do() = {
            //what
        }
    }

    object Ex3{
        
    }

    object Ex4{
        //apparently JVM limitations
    }

    object Ex5{
        //visible in com and children of it
    }

    object Ex6{
        import collection.mutable.{HashMap => ScalaHash}
        import java.util.{HashMap => JavaHash}
        
        def JavaToScalaHash() = {
            val jHash = JavaHash[String, Int]()
            jHash.put("a", 2)
            jHash.put("b", 3)
            jHash.put("c", 4)
            jHash.put("a", 5)
            val sHash = ScalaHash[String, Int]()
            val iter = jHash.keySet.iterator
            while (iter.hasNext()) {
                val key = iter.next()
                sHash(key) = jHash.get(key)
            }

            println("done")
        }
    }

    object Ex7{
        def JavaToScalaHash() = {
            import java.util.{HashMap => JavaHash}
            val jHash = JavaHash[String, Int]()
            jHash.put("a", 2)
            jHash.put("b", 3)
            jHash.put("c", 4)
            jHash.put("a", 5)
            import collection.mutable.{HashMap => ScalaHash}
            val sHash = ScalaHash[String, Int]()
            val iter = jHash.keySet.iterator
            while (iter.hasNext()) {
                val key = iter.next()
                sHash(key) = jHash.get(key)
            }

            println("done")
        }
    }

    object Ex8{
        import java._  
        import javax._

        def _do() = {
            //duplicate packages
        }
    }

    object Ex9{
        import java.lang.System._
        val userName = getProperties().getProperty("user.name")

        if (console().readLine() == "password")
            out.println("good boy")
        else
            err.println("bad boy")

    }
    
    //Ex6.JavaToScalaHash()
    
}
/**
  * Created by mudasser on 28/06/16.
  */
class FunctionalScala {

  // Scala offers several ways to define functions that are not present in Java
  /*
       Most common way of defining a function is as a member of some Object. such function is called Method.

       1. Local Functions: defining a function Inside Other Function.
                           like Local varibles, Local func are visible only in their enclosed blocks

            private methods is a replica to hide the helper methods



       2. First Class Functions: (=>) Function Literals or Anonymous Function

                 Function literal :  A function with no name, syntax.

                        For example: (x: Int, y: Int) => x + y.     fun taking 2 parameters and Body of function x+y

                  Func Literals are compiled into Class and Instantiate at runtime as Fun Value (as Objects)

                  Objects can be stored in variables too.

                  scala> var increase = (x: Int) => x + 1
                         increase: (Int) => Int = <function>

                  scala> increase(10)
                         res0: Int = 11

                       Since var (val ) Fun Value can be reassigned.
                  scala> increase = (x: Int) => {  println("We")
                                                    println("are")
                                                    println("here!")
                                                    x + 1
                                                 }



        3. ShortForm of Function Literals:


               3.1   Target Typing:  is a form of Type Inference that takes into account the type that's expected.

                              nums.filter((x:Int) => x > 0 )
                              nums.filter((x) => x > 0)     // No need of :Int in parameters

               3.2   _ is place holder.

                             nums.filter( _ > 0)

                             val f = (_:Int)+(_:Int)  // Some times Compiler need more information for Infering the Type.

               3.3  Repeated Parameters should be at the end of parameter List in a function.

                       def echo( aInt : Int, args: String* ) = for (arg <- args) println(s"$arg $aInt")

                           echo(1, "hello","twin","sample")
                           echo(2, "hello")

                        args: String* --> args: Array[String]

                        val arr = List("help","sample","template")

                         i.e, echo(1,arr: _*)




       4. Partial Functions: is an expression in which you don't supply all of the arguments needed by the function.
                             Instead, you supply SOME (or) NONE of the needed arguments.

              1.Replace an entire parameter list with an underscore '_' and
              2.Need to leave a space between the Function Name and Underscore,

                         Syntax : <funName> _
                         Example: arr.foreach(println _)


      Example:

        def sum(a: Int, b: Int, c: Int) = a + b + c  // function

            sum(1, 2, 3)    // apply to the function of arguments 1,2,3

         val a = sum _   // Partial function Expression : Compiler instantiates a Func value taking 3 parameters

         val b = sum(1, _:Int, 3) // SOME arguments

         a(1,2,3)
         b(6) where b.apply invoke sum(1,2,3)




      5. Closure: is a function whose return value depends on the value of the variables declared outside the function.

              The function value (the object) that's created at runtime from this Function Literal is called a Closure.

                              var more = 10
                              (x:Int) => 1 + more                // function (x:Int) => is closed at runTime with More.
                              val addMore = (x:Int) => 1+ more  // addMore function Value (Object)

      Free Variables (more) and Bound Varaibles (x)

            *) Changes made by a closure to a captured variable are visible outside the closure
            *) Changes made

            val someNumbers = List(-11, -10, -5, 0, 5, 10)

                scala> var sum = 0
                sum: Int = 0

                scala> someNumbers.foreach(sum +=  _)

                scala> sum
                res23: Int = -11


       6.  Recursive Function:  that approximates a value by repeatedly improving a guess until it is good enough

       7. Tail recursive Function: Last statement is Function calling itself.

       8. Currying Function :

       9. Higher Order Function : Function that takes Other Function as parameters or return a Function



   */



}

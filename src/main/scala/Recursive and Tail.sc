//Fibonanci series 1 2 3 5 8
def Fibbo(n : Int) :Int = {
  if(n == 0) 0
  else if(n ==1) 1
  else Fibbo(n-2)+Fibbo(n-1)
}

Fibbo(3)

// a ,b,.....x
def FibboTailRec(x: Int,a:Int = 0, b:Int = 1 ):Int = x match{
  case 0 => a
  case 1 => b
  case _ => FibboTailRec(x-1, b, a+b)
}

val fibb = FibboTailRec(10)



def maxTail(alist : List[Int], accMax: Int): Int = alist match {
  case Nil => accMax
  case x::xs =>
    val newMax = if(x > accMax) x else accMax
    maxTail(xs, newMax)
}

maxTail(List(123,233,111,112,12),0)
List(123,233,111,112,12).max


// Factorial
def factorail(a: Int):Int = a match{
  case 0 => 1
  case _=> a*factorail(a-1)
}

factorail(4)

def factTail(a:Int , acc : Int = 1): Int = a match {

  case 0 => acc
  case _ => factTail(a-1, a * acc)
}

factTail(4,1)
factTail(4)


//Reverse a List Iterative Way.....!!!!
def revList[T](xs: List[T] ): List[T] = xs match {

  case Nil => Nil
  case x :: xs1 => revList(xs1) :+ x
}

def revListTail[T](xs:List[T], acc:List[T]):List[T] = xs match {
  case Nil => acc
  case x::xs1 => revListTail(xs1, x+:acc)
}

val fruit:List[String] = List("apple","orange","kiwi","grape","plump","melon")
revList(fruit)




def sortList(a: List[Int], b: List[Int]) = (a++b).sorted

// Anonymous or Function Literal
val text = (alist:List[String],blist:List[String]) => (alist:::blist).sortWith(_.length < _.length)
text(fruit,List("a","b","c"))


/* In case you do not want to use the preDefined Scala sorted method Bellow is merge Sort with Tail recursion.

(Tail recursion)

In Case if any of the list is null return the other List
Check only the FirstElements of each List and merge the smaller List and repeat.
*/

def sortListMerge(aList : List[Int], bList : List[Int]) : List[Int] = {
  (aList, bList) match{
    case (Nil, Nil) => Nil
    case (Nil, bList) => bList
    case (aList, Nil) => aList
    case (a :: aList1, b :: bList1) =>
      if(a < b) a :: sortListMerge(aList1, bList)
      else b :: sortListMerge( aList, bList1)
  }
}


// To sort a non-empty list x :: xs,
// sort the remainder xs and insert the first element x at the right position in the result.
// Sorting an empty list yields the empty list.
def isort(xs: List[Int]): List[Int] = xs match {
  case List()   => List()
  case x :: xs1 => insert(x, isort(xs1))
}

def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List()  => List(x)
  case y :: ys => if (x <= y) x :: xs
                  else y :: insert(x, ys)
}

isort(List(5,72,89,16,7))

def msort[T](less: (T, T) => Boolean)
            (xs: List[T]): List[T] = {

  def merge(xs: List[T], ys: List[T]): List[T] =
    (xs, ys) match {
      case (Nil, _) => ys
      case (_, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (less(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }

  val n = xs.length / 2
  if (n == 0) xs
  else {
    val (ys, zs) = xs splitAt n
    merge(msort(less)(ys), msort(less)(zs))
  }
}

msort((x: Int, y: Int) => x < y)(List(5, 7, 1, 3))

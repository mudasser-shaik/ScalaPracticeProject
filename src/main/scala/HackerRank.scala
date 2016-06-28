/**
  * Created by mudasser on 18/06/16.
  */
class HackerRank {


  def f(n: Int) = for(i <- 1 to n ) println("Hello World")

  def ArrReplication(num:Int,arr:List[Int]): List[Int] = arr.flatMap(List.fill(num)(_))

  def fiterArray(delim:Int,arr:List[Int]):List[Int] = arr.filter(_< delim)

  def filterOddPositionEle[T](arr: List[T]):List[T] = ((1 until arr.length by 2).toList).map(arr(_))

   def filterOddPosition[T](arr: List[T]): List[T] = arr.zipWithIndex.filter(_._2 % 2 == 1).map(_._1)
  // position in Arrays (ele,0) (ele,1) (ele,2) --> Odd positions

  def SumODD(arr:List[Int]):Int = arr.filter(_%2 !=0).sum

  def funAbs(arr:List[Int]):List[Int] = arr.map(Math.abs(_))

  def revListTail[T](arr: List[T], rev:List[T]): List[T] = arr match{
    case Nil => rev
    case x::xs => revListTail(xs, x::rev) // Taking head and Adding in Empty List --> follow "STACK / FILO"
  }

  def mingle[T](p: List[T], q: List[T]): List[T] = (p,q) match {
    case (Nil, Nil) => Nil
    case (p,Nil) => p
    case (Nil,q) => q
    case (x::xs,y::ys) => x::y::mingle(xs,ys)
  }

  val a = "abcdef"
  val b = "123456789"

  a.zip(b)

  //String-0-permute
  val str = "abcdpqrs"
  def swapEvenIndex = str.toList.grouped(2).map(_.reverse).flatten.mkString("")
//with index 2 : badcqpsr string-> List-> group{(a,b)(c,d)(p,q)(r,s)} -> reverse -> badcqpsr

  val alist = (1 to 15).toList
  val strSwap = alist.map(_.toString).grouped(2).map(_.reverse).flatten.toList
  alist.sliding(2,2).map(_.reverse).flatten.toList


   def compress(s: String, res: String) : String = s match{
       case "" => res
       case _ =>
       val (l,r) = s.span(_ == s.head)
       compress(r, res+(if(l.size == 1) l else l.head+l.size.toString))
   }

  compress("abbcccdddd","")

  def compressRec(s: String): String = s match {
    case "" => ""
    case _ =>
      val (l,r) = s.span(_ == s.head)
      (if(l.size==1) l else l.head+l.size.toString)+compressRec(r)
  }

}

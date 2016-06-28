// List is homogenious like Arrays
val empty = List()

val fruit:List[String] = List("apple","orange","kiwi")

val listOfList = List(
  List(1,2,3),
  List(4,5,6),
  List(7,8,9)
)



"pineapple"::fruit
1::List(2,3,4,5,6)
1 +: List(2,3,4,5) :+ 6
val list = List(1,2,3):::List(4,5,6) //concatination

val List(fruit1,fruit2,c) = fruit


// It's a good idea to organize your data so that most accesses are at the head of a list,
// rather than the last element.
empty.isEmpty
fruit.isEmpty
fruit.head
fruit.tail     //except head, all elements
fruit.reverse.head
fruit.length  //length is a relatively expensive operation. It needs to traverse the whole list to find its end. Replace xs.isEmpty by xs.length == 0.
fruit.last
fruit.init    // except last, all elements
fruit.reverse // reverse creates a new list rather than changing the one it operates on. Since lists are immutable,

fruit.take(2)
fruit.drop(2)
fruit.splitAt(3) // (xs take n, xs drop n)
fruit(2)        // fruit apply n equals (xs drop n).head

val fruitIndices = fruit.indices

fruitIndices.zip(fruit).toList
val fruitZip = fruit.zipWithIndex

fruitZip.unzip

fruit.toString()
fruit mkString ("List(", ", ", ")") //mkstring(pre,sep,post)
val fruitStr = fruit.mkString(",")  // Array to String
fruitStr.split(",")  // String to Array[String]

//Spliting the sequence into SubSets
// GroupBy, Sliding, Grouped returns multiple Sets.
//Partition,Span,SplitAt, unZip returns Tuple2

val x = List(15, 10, 5, 8, 20, 12)
val group = x.groupBy(_>12)    // takes Function and return Map(true and False)
group(true)
group(false)

"abcdef".grouped(2).toList   // return Iterator List

"abcdef".sliding(2,2).toList // generates many subSets return Iterator List for value res10.next
x.sliding(3).toList
x.sliding(3,3).toList //
x.sliding(2,3).toList


val couples = List(("Kim", "Al"), ("Julia", "Terry"),("mudasser","Aman"),("Shaik","Durdana"))
val (nameL, nameF) = couples.unzip


val (a,b) = x.partition(_ > 12) // breaks into two sets on conditions

// Span will put all elements in one list until an element is "false" (in terms of the predicate).
//From that point forward, it will put the elements in the second list.
val (l,r) = x.span(_>12)
x.splitAt(2) //splits the sequence into two subsets



fruit.sortBy(_.length)
List(1,2,3,4,5).sortWith(_>_)


val arr2 = new Array[Int](10)
List(1, 2, 3) copyToArray (arr2, 3)
arr2.foreach(println)

fruit.map(_.toList.reverse.mkString)

val ListOfList = fruit.map(_.toList)     // map returns a list of lists,
fruit.flatMap(_.toList)                 // flatMap returns a single list, all element lists are concatenated

List.range(1,5).flatMap(
  i => List.range(1,i).map( j => (i,j) )
)

var sum = 0
List(1, 2, 3, 4, 5) foreach (sum += _)
List(1, 2, 3, 4, 5) filter (_ % 2 == 0)
List(1, 2, 3, 4, 5).partition(_ % 2 == 0) // xs.partition(p),  (xs filter p, xs filter (!p(_)))
List(1, 2, 3, 4, 5).sum
List(1, 2, 3, 4, 5).product
List(1, 2, 3, 4, 5).max




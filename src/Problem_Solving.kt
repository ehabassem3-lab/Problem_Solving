import java.util.Locale.getDefault


fun main() {
// println( AffineCipher.encode("test", a = 5 ,b =7))10101"
////
//  println( AffineCipher.decode("ybty" , a = 5 , b = 7))
//    println(transcribeToRna("ACGT"))
   // println(occurances("Ehab assem  hafez"))
//    moveZeroes(intArrayOf(0,1,0,3,12))
//    addTwoNumbers(buildList(intArrayOf(2,4,3)) , buildList(intArrayOf(5,6,4)))
    println(maxProfit(intArrayOf(2,8,4,10,6),20))

}

fun numberSteps(steps : Int , max : Int) : List<Int>{
       var numbersList = mutableListOf<Int>()
   for ( i in 0..max){
       if (i != 0 && i % steps == 0){
           numbersList.add(i)
       }
   }
    println(numbersList)
    return numbersList

}
fun fibonacci ( max: Int) : List<Int>{
    val numbersList = mutableListOf<Int>()
    var previosNumbers = 0
    var beforePreviuos  = 0
    var total   = 0

            for (i in 0..max) {
                if (i == 0) {

                } else {
                    if (i <= 1) {
                        numbersList.add(i)
                    } else if (i == 2) {
                        numbersList.add(i - 1)
                    } else {
                        previosNumbers = numbersList.last()
                        beforePreviuos = numbersList.get(numbersList.lastIndex - 1)
                        total = previosNumbers + beforePreviuos
                        if (total <= max ){
                            numbersList.add(total)
                        }

                    }

                }
            }



     println(numbersList)

     return numbersList
}
fun consistentCapitalization(word : String)  : String{
    println("Enter Your Formater Of Choice ")
    println("0 ->  Exit  ")
    println("1 ->  Upper  ")
    println("2 ->  Lower ")
    println("3 -> Camel   ")
    println("4->  Snake ")
    val choice  = readln().toInt()
       when(choice){
           0 ->  return  "";
           1 ->  return  word.uppercase(getDefault())  ;

           2->  return   word.lowercase(getDefault()) ;
           3->  {
               val result = StringBuilder()
               var capitalizeNext = false
             for (char in word){
                 when{
                     char == ' ' || char == '_' || char == '-' -> capitalizeNext = true
                     result.isEmpty() -> result.append(char.lowercaseChar())
                     capitalizeNext -> {  result.append(char.uppercase())  ; capitalizeNext =false}
                     else -> result.append(char.lowercaseChar())

                 }
             }
               println(result)
              return  result.toString()

           };

           4 ->   return word
               .replace(" " , "_")
               .lowercase()

       }
    println(word)
    return word
}
fun  theLongestWord(word : String) : String{
    val map  : MutableMap<Int , String> =  mutableMapOf()
    var longest : StringBuilder = StringBuilder()

        for (char in word){
            if (char == ' ' || char == '_' || char == '-' ){
             map[longest.length] = longest.toString()
                longest.setLength(0)
            }else{
                longest.append(char)
            }
        }
    map[longest.length] = longest.toString()


    val highestEntry = map.maxByOrNull { it.key }

     return  highestEntry?.value ?: ""

}
fun caesarCipher(key  : Int , word : String ){
    val alphabetMap = mapOf(
        0 to 'a',
        1 to 'b'   ,
        2 to 'c'  ,
        3 to 'd'   ,
        4 to 'e'   ,
        5 to 'f'   ,
        6 to 'g'   ,
        7 to 'h'  ,
        8 to 'i' ,
        9 to 'j',
        10 to 'k',
        11 to 'l',
        12 to 'm',
        13 to 'n',
        14 to 'o',
        15 to 'p',
        16 to 'q',
        17 to 'r',
        18 to 's',
        19 to 't',
        20 to 'u',
        21 to 'v',
        22 to 'w',
        23 to 'x',
        24 to 'y',
        25 to 'z'
    )
    val wordMap  : MutableMap<Int , Char> = mutableMapOf()
    var encrypted : StringBuilder = StringBuilder()
    for (i in 0 until word.length){
        if (alphabetMap.containsValue(word[i])){
            val key1 = alphabetMap.entries
                .firstOrNull { it.value == word[i] }
                ?.key
            wordMap[key1?:0] = word[i]

            println("${wordMap.keys.lastOrNull()}  -->  ${wordMap.values.lastOrNull()} " )
            val encryptedKey = key1?.plus(key) ?: 0
            encrypted.append(alphabetMap[encryptedKey])
            println(encrypted)

        }



    }







}
fun caesarCipherDecryption(key: Int , enryptedWord : String){
    val alphabetMap = mapOf(
        0 to 'a',
        1 to 'b'   ,
        2 to 'c'  ,
        3 to 'd'   ,
        4 to 'e'   ,
        5 to 'f'   ,
        6 to 'g'   ,
        7 to 'h'  ,
        8 to 'i' ,
        9 to 'j',
        10 to 'k',
        11 to 'l',
        12 to 'm',
        13 to 'n',
        14 to 'o',
        15 to 'p',
        16 to 'q',
        17 to 'r',
        18 to 's',
        19 to 't',
        20 to 'u',
        21 to 'v',
        22 to 'w',
        23 to 'x',
        24 to 'y',
        25 to 'z'
    )
    val encryptedWordMap  : MutableMap<Int , Char> = mutableMapOf()
    var Decrypted : StringBuilder = StringBuilder()
        for (i in 0 until  enryptedWord.length){
                val key1 = alphabetMap.entries.firstOrNull { it.value == enryptedWord[i] }?.key
                encryptedWordMap[key1?:0] = enryptedWord[i]
                val subtraction = (key1?.minus(key)) ?: 0
                println("${encryptedWordMap.keys.lastOrNull()}  -->  ${encryptedWordMap.values.lastOrNull()} " )
                val key2 = if (subtraction < 0) subtraction+26 else subtraction
            println(key2)
                Decrypted.append(alphabetMap[key2])
                println(Decrypted)



        }
}
fun  dublicateChars(word  : String) : Map<Char, Int>{
    val map : MutableMap<Char, Int> = mutableMapOf()

  for (c in word){
      map[c] = (map[c] ?: 0) +1
  }






    return map

}
fun fizzBuzz(number : Int) : List<Any>{
    var numbersList  = mutableListOf<Any>()
     for (i in number   downTo    0){
        if (i == 0 ) return  numbersList
         if (i %3 == 0 && i % 5 == 0) numbersList.add("FizzBuzz.")
         if (i%3==0) numbersList.add("Fizz.")
         if (i%5==0) numbersList.add("Buzz.")
            else{
             numbersList.add(i)

         }
     }

return numbersList


}
fun steps(step : Int) {
    var map : MutableMap<Int , String> = mutableMapOf()
    for (i in 0 .. step){
        when(i){
            0 -> {}
            1 -> {
                map[i] = "#"
                println("${map.keys.lastOrNull()} ->> ${map.values.lastOrNull()}")
            }
            else -> {
                map[i] = map[i - 1] + "#"
                println("${map.keys.lastOrNull()} ->> ${map.values.lastOrNull()}")
            }

        }

    }

}
fun triangle(rows: Int, block: String) {}
fun isIsogram(input: String): Boolean {

    for (i in 0 until input.length){
        when(input[i]){
            '-' , ',' , ' ' , '_' -> {}
            else -> {
            for (j in i+1 until input.length ){
                if (input[i].lowercaseChar() == input[j].lowercaseChar()){
                    return false
                }
            }
            }
        }


    }
    return true

}
fun translate(rna: String?): List<String> {

    val map = mapOf(
        "AUG" to "Methionine",
        "UUC" to "Phenylalanine",
        "UUU" to "Phenylalanine",
        "UUA" to "Leucine",
        "UUG" to "Leucine",
        "UCU" to "Serine",
        "UCC" to "Serine",
        "UCA" to "Serine",
        "UCG" to "Serine",
        "UAU" to "Tyrosine",
        "UAC" to "Tyrosine",
        "UGU" to "Cysteine",
        "UGC" to "Cysteine",
        "UGG" to "Tryptophan",
        "UAA" to "STOP",
        "UAG" to "STOP",
        "UGA" to "STOP"
    )

    val proteinList = mutableListOf<String>()
    val chunk = StringBuilder()

    if (rna != null) {
        for (c in rna) {
            chunk.append(c.uppercaseChar())

            if (chunk.length == 3) {
                val protein = map[chunk.toString()]
                    ?: throw IllegalArgumentException("Invalid codon")

                if (protein == "STOP") {
                    return proteinList
                }

                proteinList.add(protein)
                chunk.setLength(0)
            }
        }
    }

    if (chunk.isNotEmpty()) {
        throw IllegalArgumentException("Invalid codon")
    }

    return proteinList

}
object AffineCipher {
    val alphabetMap = mapOf(
        0 to 'a',
        1 to 'b'   ,
        2 to 'c'  ,
        3 to 'd'   ,
        4 to 'e'   ,
        5 to 'f'   ,
        6 to 'g'   ,
        7 to 'h'  ,
        8 to 'i' ,
        9 to 'j',
        10 to 'k',
        11 to 'l',
        12 to 'm',
        13 to 'n',
        14 to 'o',
        15 to 'p',
        16 to 'q',
        17 to 'r',
        18 to 's',
        19 to 't',
        20 to 'u',
        21 to 'v',
        22 to 'w',
        23 to 'x',
        24 to 'y',
        25 to 'z'
    )
    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) kotlin.math.abs(a) else gcd(b, a % b)
    }
    fun isCoprime(a: Int, b: Int): Boolean {
        return gcd(a, b) == 1
    }
    fun modInverse(a: Int): Int {
        for (x in 1 until 26) {
            if ((a * x) % 26 == 1) {
                return x
            }
        }
        return -1
    }
    fun encode(input: String, a: Int, b: Int) : String {
        val encrypted = StringBuilder()
        if (isCoprime(a,b)){
            for (i in 0 until  input.length){
              val key1 = alphabetMap.entries.firstOrNull { it.value == input[i] }?.key
               var Formuala =  (a * key1!!)+b
                while (Formuala > 26 ){
                   Formuala  %= 26
                }
                encrypted.append(alphabetMap[Formuala])

            }

        }
        return encrypted.toString()

    }
    fun decode(input: String, a: Int, b: Int)  : String{
        val decrypted = StringBuilder()

        if (isCoprime(a,b)){
            val inverse = modInverse(a)
            var Formula = 0
            for ( i in 0 until input.length){
                val key = alphabetMap.entries.firstOrNull{it.value == input[i]}?.key
                if (key!! >= b){
                    Formula = inverse * (key!!-b)
                }else{
                    Formula = inverse * (key!!+26 - b)
                }
                while (Formula >= 26){
                    Formula %= 26
                }
                decrypted.append(alphabetMap[Formula])

            }
        }
 return decrypted.toString()
    }
}
fun transcribeToRna(dna: String): String {
    val TransLated = StringBuilder()
     for (x in dna){
         when(x.uppercaseChar()) {
            'G'-> TransLated.append("C")
            'C' -> TransLated.append("G")
            'T' -> TransLated.append("A")
            'A' -> TransLated.append("U")
             else -> {
                 throw IllegalArgumentException("Dna no Valid")

             }


         }

     }


return TransLated.toString()



}
fun occurances( word : String ) : Map<Char , Int>{
     val Standard = word.uppercase(getDefault())
    val map  = mutableMapOf<Char , Int>()
    for (c in Standard){
        if (c.isWhitespace()){

        }else{
            map[c] = (map[c]?:0) + 1
        }

    }
    for ((key , value ) in map){
        println("$key  - >  $value ")

    }

    return  map
}
fun removeElement(nums: IntArray, `val`: Int): Int {
    var lengthAfter = 0


    for ( n in nums) {
        if (n != `val`) {
            nums[lengthAfter] = n
            lengthAfter++
        }



    }
    println(nums.size )

    return lengthAfter


}
fun moveZeroes(nums: IntArray): Unit {
  var zeros = 0




    for (i in nums.indices) {
        if (nums[i] != 0) {
             nums[zeros] = nums[i]
            zeros++
            println(nums[i])

        }

    }
    for (i in zeros until nums.size){
           nums[i] = 0
        println(nums[i])
    }


}
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var current = dummy

    var p1 = l1
    var p2 = l2
    var carry = 0

    while (p1 != null || p2 != null || carry != 0) {
        val x = p1?.`val` ?: 0
        val y = p2?.`val` ?: 0
        val sum = x + y + carry
        carry = sum / 10

        current.next = ListNode(sum % 10)
        current = current.next!!

        p1 = p1?.next
        p2 = p2?.next
    }

    return dummy.next
}
fun buildList(arr: IntArray): ListNode? {
    if (arr.isEmpty()) return null

    val head = ListNode(arr[0])
    var current = head

    for (i in 1 until arr.size) {
        current.next = ListNode(arr[i])
        current = current.next!!
    }

    return head
}
fun lengthOfLongestSubstring(s: String): Int {
    var word = StringBuilder()
    var subStringMape = mutableMapOf<Int, String>()
    for(c in s){
        val duplicateIndex = word.indexOf(java.lang.String.valueOf(c))
        if (!word.contains(c)){
            word.append(c)
        }else{
            subStringMape[word.length] = word.toString()
            word.delete(0, duplicateIndex + 1);
            word.append(c)
        }

    }

    subStringMape[word.length] = word.toString()


    return subStringMape.keys.maxOrNull() ?: 0


}

fun strStr(haystack: String, needle: String): Int {
    val word = StringBuilder()
    for (i in  0 until haystack.length){
        word.setLength(0)
        if (haystack[i] == needle.first()){
            if (i + needle.length > haystack.length) {
                continue
            }
                for ( j in 0  until needle.length){
                    if (haystack[j+i] == needle[j]){
                        word.append(needle[j])
                    }
                    if (needle == word.toString()){
                        return  i
                    }

            }


        }
    }

 return -1
}

fun searchInsert(nums: IntArray, target: Int): Int {

    for (i in nums.indices) {

        if (nums[i] == target) {
            return i
        }

        if (target < nums[i]) {
            return i
        }
    }

    return nums.size
}

fun lengthOfLastWord(s: String): Int {
    var counterList = mutableListOf<Int>()
    var count = 0
    for (i in 0 until s.length ){
        if (s[i].isWhitespace()){
            if (count!= 0){
                counterList.add(count)
                count = 0
            }
            continue

        }else{
            count++
        }

    }
    if (count != 0){
        counterList.add(count)

    }
    return  counterList.last()

}


fun plusOne(digits: IntArray): IntArray {
   var newSet = mutableListOf<Int>()
    var numberBuilder = StringBuilder()

   for (n in digits){ numberBuilder.append(n) }
    val number = numberBuilder.toString().toBigInteger() + 1.toBigInteger()
    numberBuilder.clear()
    numberBuilder.append(number)
  for ( i  in 0 until  numberBuilder.length){
      newSet.add(numberBuilder[i].toString().toInt())
  }


    return newSet.toIntArray()
}


fun addBinary(a: String, b: String): String {
    var i = a.length - 1
    var j = b.length - 1
    var carry = 0
    val result = StringBuilder()

    while (i >= 0 || j >= 0 || carry != 0) {
        var sum = carry

        if (i >= 0) {
            sum += a[i] - '0'
            i--
        }

        if (j >= 0) {
            sum += b[j] - '0'
            j--
        }

        result.append(sum % 2)
        carry = sum / 2
    }

    return result.reverse().toString()
}


fun generate(phrase: String) : String {
    var world   = StringBuilder()
    world.append(phrase[0].uppercase())
     for (i  in 0  until  phrase.length){

         when(phrase[i]){
             ' ' , '_' , '-' , ',',';'  -> {
                when(phrase[i+1] ){
                    ' ' , '_' , '-' , ',',';' -> {

                    }else ->{
                    world.append(phrase[i+1].uppercase())

                }
                }


             }

         }

     }


    return world.toString()
}
fun nucleotideCounts(dna: String): Map<Char, Int> {
    val map = mutableMapOf(
        'A' to 0,
        'C' to 0,
        'G' to 0,
        'T' to 0
    )
      if (dna.isEmpty())  throw IllegalArgumentException("Invalid DNA")
    for (n in dna) {
        when (n) {
            'A', 'C', 'G', 'T' -> map[n] = map[n]!! + 1
            else -> throw IllegalArgumentException("Invalid DNA")
        }
    }

    return map
}

fun sum(factors: Set<Int>, limit: Int): Int {
    val multiples = mutableSetOf<Int>()

    for (factor in factors) {
        if (factor == 0) continue

        var multiple = factor
        while (multiple < limit) {
            multiples.add(multiple)
            multiple += factor
        }
    }

    return multiples.sum()
}

fun twofer(name: String? = null): String {
   return if (name == null) "One for you, one for me." else "One for $name, one for me."
}
fun reverse(x: Int): Int {
    var n = x
    var reverse = 0

    while (n != 0) {
        val digit = n % 10
        n /= 10

        if (reverse > Int.MAX_VALUE / 10 ||
            reverse < Int.MIN_VALUE / 10) {
            return 0
        }

        reverse = reverse * 10 + digit
    }

    return reverse
}
fun maxProfit(inventory: IntArray, orders: Int): Int {
    var profit = 0L
    var remaining = orders
    val MOD = 1_000_000_007L

    while (remaining > 0) {
        var maxIndex = 0

        for (i in inventory.indices) {
            if (inventory[i] > inventory[maxIndex]) {
                maxIndex = i
            }
        }

        profit += inventory[maxIndex].toLong()
        inventory[maxIndex]--
        remaining--
    }

    return (profit % MOD).toInt()
}
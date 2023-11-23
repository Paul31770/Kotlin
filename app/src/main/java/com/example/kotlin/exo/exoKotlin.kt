
fun main() {
    println(boulangerie())
    println(scanText("ton prénom"))
    /*println(min(2,4,6))
    println(pair(4))*/
    /*println("Hello, world!!!")
    var v1 ="toto"
    println(v1.uppercase())

    var v2:String?= "toto"
    println(v2?.uppercase())


    var v3:String?=null
    println(v3?.uppercase())

    var v4=v3+v3;
    println(v4::class.simpleName)

    if(v3.isNullOrBlank()){
        println("Toto")
    }
*/


}

/*fun min(int1:Int, int2: Int, int3: Int): Int{
    var max=0;
    if (int1>int2 && int1>int3){
        return int1
    }
    else if(int2<int1 && int2<int3){
        return int2
    }
    else{
        return int3
    }

}*/

/*version en fonction expression du min*/
/*
fun min(int1: Int, int2: Int, int3: Int): Int =if(int1>int2 && int1>int3) int1 else if(int2<int1 && int2<int3) int2 else int3

fun pair(int: Int): Boolean= int%2==0
*/

/*
fun myPrint(chaine: String)= println("#$chaine#")*/

fun boulangerie(nbCroissant: Int=3, nbBaguette:Int=2, nbSandwich: Int=0): Double{
return nbCroissant*PRIX_CROISSANT+nbBaguette*PRIX_BAGUETTE+nbSandwich*PRIX_SANDWICH
}


fun scanText(question: String): String {
    println(question)
    return readlnOrNull() ?:"-"
}

/*
fun scanNumber(){
    println("Nb Baguette")
    var nbBaguette= readlnOrNull();
    println("Nb Croissant")
    var nbCroissant= readlnOrNull();
    println("Nb Sandwich")
    var nbSandwich= readlnOrNull();

    return (nbBaguette*PRIX_BAGUETTE+nbSandwich*PRIX_SANDWICH+nbCroissant*PRIX_CROISSANT)
}
*/


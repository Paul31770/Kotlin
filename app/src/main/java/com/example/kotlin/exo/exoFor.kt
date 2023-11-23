fun enleverE(phrase: String): String {
    return phrase.replace("e", "", ignoreCase = true)
}

fun nombreA(phrase:String):  Int{
    var a=0
    for( i in phrase){
        if (i== 'a'){
            a++
        }
    }
    return a
}

fun lenvers(mot: String): String{
    return mot.reversed()
}

fun maj(phrase: String): Int{
    var nombreMaj=0
    for (i in phrase){
        if (i.isUpperCase()) {
            nombreMaj++
        }
    }
    return nombreMaj
}


fun main(){

    var phrase: String= "Salut le monde"
    /*sans les e*/
    println(enleverE(phrase))

    println("Il y a "+nombreA(phrase)+" dans la phrase")

    println(lenvers("toto"))

    println(maj(phrase))
}
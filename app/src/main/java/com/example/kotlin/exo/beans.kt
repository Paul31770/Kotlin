package com.example.kotlin.exo
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

const val LONG_TEXT = """Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500"""
data class PictureData(val url: String, val text: String, val longText: String)

//jeu de donnée
val pictureList = arrayListOf(PictureData("https://picsum.photos/200", "ABCD", LONG_TEXT),
    PictureData("https://picsum.photos/201", "BCDE", LONG_TEXT),
    PictureData("https://picsum.photos/202", "CDEF", LONG_TEXT),
    PictureData("https://picsum.photos/203", "EFGH", LONG_TEXT)
)






/*class CarBean(marque: String, modele: String ){
    private val marque:String= marque
    private val modele:String =modele

    companion object{
        private val couleur:String= "grise"

        *//*pour obtenir la couleur hors de la classe*//*
        fun getCouleur(): String {
            return couleur
        }
    }

    fun afficherDetails() {
        println("Marque: $marque")
        println("Modèle: $modele")
        println("Couleur: ${CarBean.couleur}")

    }
}*/




data class WeatherBean(var name: String, var wind: WindBean, var main: TempBean)

data class TempBean(var temp:Double)

data class WindBean(var speed: Double)


fun loadWeather(): WeatherBean {
    val gson = Gson()

    val json: String = sendGet("https://api.openweathermap.org/data/2.5/weather?q=Toulouse&appid=b80967f0a6bd10d23e44848547b26550&units=metric&lang=fr")

    val data : WeatherBean = gson.fromJson(json, WeatherBean::class.java)
    println("azerty"+ data)
    return data
}
fun sendGet(url: String): String {
    val client = OkHttpClient()
    println("url : $url")

    val request = Request.Builder().url(url).build()

    return client.newCall(request).execute().use {
        if (!it.isSuccessful) {
            throw Exception("Réponse du serveur incorrect :${it.code}")
        }

        it.body.string()
    }
}




fun main(){
    println("qff"+loadWeather())
    /*val seat= CarBean("seat", "leon")
    seat.afficherDetails()*/
}
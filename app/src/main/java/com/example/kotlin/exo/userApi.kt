package com.example.kotlin.exo

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

data class userBean(var name: String, var age: Int, var coord: mailBean?)

data class mailBean(var mail: String?  )

fun loadUser(): userBean {
    val gson = Gson()

    val json: String = sendGett("https://amonteiro.fr/api/randomuser")

    val data : userBean = gson.fromJson(json, userBean::class.java)
    return data
}

fun sendGett(url: String): String {
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
    println("Je m'appelle ${loadUser().name}, j'ai ${loadUser().age} ans et mon mail est: ${(loadUser().coord?.mail) ?: "pas de mail"} ")
}
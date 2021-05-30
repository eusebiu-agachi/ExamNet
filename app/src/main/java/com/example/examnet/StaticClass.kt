package com.example.examnet

class StaticClass {
    companion object {
        lateinit var value : String
        lateinit var email : String
        lateinit var username : String
        lateinit var scor : String
    }
    init {
        value = this.toString()
        email = this.toString()
        username = this.toString()
        scor = this.toString()
    }
}
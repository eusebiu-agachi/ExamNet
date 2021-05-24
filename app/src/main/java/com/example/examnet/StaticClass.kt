package com.example.examnet

class StaticClass {
    companion object {
        lateinit var value : String
    }
    init {
        value = this.toString()
    }
}
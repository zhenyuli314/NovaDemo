package com.nova.novademo

import kotlin.reflect.typeOf


open class Animal

fun Animal.getName() = "Aninal"

class Cat : Animal()

fun Cat.getName() = "Cat"

fun printAnimal(animal: Animal) = println(animal.getName())

fun main() {
//    printAnimal(Animal())
//    printAnimal(Cat())


    val numbers = listOf("one", "two", "three", "four")
    println(numbers)
    println(numbers.joinToString())
    println(
        numbers.joinToString(
            separator = " | ",
            prefix = "start: ",
            postfix = ": end"
        )
    )


}



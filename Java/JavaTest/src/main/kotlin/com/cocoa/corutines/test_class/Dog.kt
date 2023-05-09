package com.test_class


class Dog : Thread() {

    override fun run() {
        super.run()
        println(currentThread().name)
    }

}
package com.kulya.dev.testproject.util

import android.content.Context
import android.widget.Toast


val emptyString = ""


fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun <T> unSafeLazy(initializer: () -> T): Lazy<T> {
    return lazy(LazyThreadSafetyMode.NONE) {
        initializer()
    }
}


fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' относится к листу
    this[index1] = this[index2]
    this[index2] = tmp
}
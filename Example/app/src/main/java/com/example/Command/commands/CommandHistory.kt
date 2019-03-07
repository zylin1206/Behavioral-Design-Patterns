package com.example.Command.commands

import java.util.*

/**
 * Created by Android Studio
 * Author: Duy-Linh Nguyen
 * Date: 3/7/19
 * Time: 10:11 AM
 */
class CommandHistory {
    private val history = Stack<Command>()

    val isEmpty: Boolean
        get() = history.isEmpty()

    fun push(c: Command) {
        history.push(c)
    }

    fun pop(): Command {
        return history.pop()
    }
}
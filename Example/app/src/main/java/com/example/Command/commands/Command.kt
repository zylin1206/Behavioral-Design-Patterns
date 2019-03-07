package com.example.Command.commands

import com.example.Command.Editor

/**
 * Created by Android Studio
 * Author: Duy-Linh Nguyen
 * Date: 3/7/19
 * Time: 9:25 AM
 */
abstract class Command internal constructor(var editor: Editor) {
    private var backup: String? = null

    internal fun backup() {
        backup = editor.textField.text.toString()
    }

    fun undo() {
        editor.textField.setText(backup)
    }

    abstract fun execute(): Boolean
}

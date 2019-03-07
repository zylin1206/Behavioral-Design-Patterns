package com.example.Command.commands

import com.example.Command.Editor

/**
 * Created by Android Studio
 * Author: Duy-Linh Nguyen
 * Date: 3/7/19
 * Time: 10:00 AM
 */
class CutCommand(editor: Editor) : Command(editor) {

    override fun execute(): Boolean {
        if (editor.textField.text.toString().isEmpty()) return false

        backup()
        val source = editor.textField.text.toString()
        editor.clipboard = editor.textField.text.toString()
        editor.textField.setText(cutString(source))
        return true
    }

    private fun cutString(source: String): String {
        val start = source.substring(0, editor.textField.selectionStart)
        val end = source.substring(editor.textField.selectionEnd)
        return start + end
    }
}
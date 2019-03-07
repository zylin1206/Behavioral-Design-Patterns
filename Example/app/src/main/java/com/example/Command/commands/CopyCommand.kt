package com.example.Command.commands

import com.example.Command.Editor

/**
 * Created by Android Studio
 * Author: Duy-Linh Nguyen
 * Date: 3/7/19
 * Time: 9:55 AM
 */
class CopyCommand(editor: Editor) : Command(editor) {

    override fun execute(): Boolean {
        editor.clipboard = editor.textField.getText().toString()
        return false
    }
}
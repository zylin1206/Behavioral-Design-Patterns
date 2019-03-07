package com.example.Command.commands

import com.example.Command.Editor

/**
 * Created by Android Studio
 * Author: Duy-Linh Nguyen
 * Date: 3/7/19
 * Time: 10:07 AM
 */
class PasteCommand(editor: Editor) : Command(editor) {

    override fun execute(): Boolean {
        if (editor.clipboard.isEmpty()) return false
        backup()
        editor.textField.setText(editor.clipboard)
        return true
    }
}
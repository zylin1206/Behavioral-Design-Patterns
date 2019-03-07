package com.example.Command

import android.R.id.cut
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.R
import android.R.id.undo
import android.app.Activity
import com.example.Command.commands.*


class Editor : AppCompatActivity() {
    lateinit var textField: EditText
    var clipboard: String = ""
    private var history = CommandHistory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        textField = findViewById(R.id.edt)

        val copyBtn: Button = findViewById(R.id.btn_copy)
        val cutBtn: Button = findViewById(R.id.btn_cut)
        val pasteBtn: Button = findViewById(R.id.btn_paste)
        val undoBtn: Button = findViewById(R.id.btn_undo)

        copyBtn.setOnClickListener { executeCommand(CopyCommand(this)) }
        cutBtn.setOnClickListener { executeCommand(CutCommand(this)) }
        pasteBtn.setOnClickListener { executeCommand(PasteCommand(this)) }
        undoBtn.setOnClickListener { undo() }
    }


    private fun executeCommand(command: Command) {
        if (command.execute()) {
            history.push(command)
        }
    }

    private fun undo() {
        if (history.isEmpty) return

        val command = history.pop()
        command.undo()
    }
}

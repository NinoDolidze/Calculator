package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var operand: Double = 0.0
    private var operation: String = ""
    var lastNumeric: Boolean = false
    var stateError: Boolean = false
    var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

    }

    fun numberClick (clickedView: View) {

        if (clickedView is TextView) {

            var result = resultTextView.text.toString()
            val number = clickedView.text.toString()

            if (result == "0") {
                result = ""
            }

            resultTextView.text = result + number

        }

    }


    fun operationClick(clickedView: View) {

        if (clickedView is TextView) {

            val result = resultTextView.text.toString()

            if (result.isNotEmpty()) {
                operand = result.toDouble()
            }

            operation = clickedView.text.toString()

            resultTextView.text = ""

        }
    }

    fun equalsClick(clickedView: View) {

        val secOperandText: String = resultTextView.text.toString()
        var secOperand = secOperandText.toDouble()

        if (secOperandText.isNotEmpty()) {
            secOperand = secOperandText.toDouble()
        }

        when (operation) {
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "x" -> resultTextView.text = (operand * secOperand).toString()
            "/" -> resultTextView.text = (operand / secOperand).toString()


        }

    }

    fun acButton(view: View) {
        this.resultTextView.text = ""
        lastNumeric = false
        stateError = false
        lastDot = false
    }

    fun decimalPoint(view: View) {
        if (lastNumeric && !stateError && !lastDot) {
            resultTextView.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun backspaceButton(view: View) {
        val length = resultTextView.length()
        if(length > 0)
            resultTextView.text = resultTextView.text.subSequence(0, length - 1)

    }


}

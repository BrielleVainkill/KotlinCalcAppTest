package com.example.kotlincalcapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{
    private lateinit var workingsTV: TextView
    private lateinit var resultsTV: TextView
    private var canAddOperation = false
    private var canAddDecimal = true
    private val numButtonIds = arrayOf(R.id.btn0,
                            R.id.btn1,
                            R.id.btn2,
                            R.id.btn3,
                            R.id.btn4,
                            R.id.btn5,
                            R.id.btn6,
                            R.id.btn7,
                            R.id.btn8,
                            R.id.btn9)
    private val opButtonIds = arrayOf(R.id.multBtn, R.id.divBtn, R.id.addBtn, R.id.subBtn)

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        workingsTV = findViewById(R.id.workingsTV)
        workingsTV.text = ""
        resultsTV = findViewById(R.id.workingsTV)
        resultsTV.text = ""


        //NUM BUTTONS
        for (buttonId in numButtonIds) //foreach loop to create a listener for all number buttons
        {
            val button = findViewById<Button>(buttonId)
            button.setOnClickListener()
            {
                /*
                if(workingsTV.text == ".") //if workings tv is just "."
                {
                    if(canAddDecimal)
                    {
                        workingsTV.append(button.toString()) //add input to text view
                    }
                    canAddDecimal = false
                }
                else
                {
                    workingsTV.append(button.toString()) //add input to text view
                }
                */
                workingsTV.append(button.text.toString())
                canAddOperation = true
            }
        }

        //OPERATION BUTTON
        for (buttonId in opButtonIds) {
            val button = findViewById<Button>(buttonId)
            button.setOnClickListener()
            {
                if (canAddOperation) {
                    workingsTV.append(button.toString())
                    canAddOperation = false
                    canAddDecimal = true
                }
            }
        }

        //BACKSPACE BUTTON - remove leftmost input from WorkingsTV
        findViewById<Button>(R.id.backspaceBtn).setOnClickListener()
        {
            val length = workingsTV.length() //take current length value of workingsTV
            if (length > 0) //if length greater than 0
            {
                workingsTV.text = workingsTV.text.subSequence(
                    0,
                    length - 1
                ) //returns a subsequence/substring starting at specified string index and ending at specified 2nd index parameter
            }
        }

        //ALL CLEAR BUTTON - clear all inputs, reset flags
        findViewById<Button>(R.id.AllClearBtn).setOnClickListener()
        {
            workingsTV.text = ""
            resultsTV.text = ""
            canAddDecimal = false
            canAddOperation= true
        }

        //EQUALS BUTTON
                /*
        fun numberAction(view: View)
        {
            if(view is Button)
            {
                if(view.text == ".")
                {
                    if(canAddDecimal)
                    {
                        workingsTV.append(view.text)
                    }
                    canAddDecimal = false
                }
                else
                {
                    workingsTV.append(view.text)
                }
                workingsTV.append(view.text)
                canAddOperation = true
            }
        }
        */

    }

}
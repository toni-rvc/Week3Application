package edu.student.week3application

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtNum1 = findViewById<EditText>(R.id.txtNum1)
        var txtNum2 = findViewById<EditText>(R.id.txtNum2)
        var btnAdd = findViewById<Button>(R.id.btnAdd)
        var btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val txtShow = findViewById<TextView>(R.id.txtShow)

        btnAdd.setOnClickListener {
            if (txtNum1.text.toString() == "" || txtNum2.text.toString() == "") {
                if (txtNum1.text.toString() == "") {
                    //added for messagebox
                    Toast.makeText(this, "Enter in Number 1", Toast.LENGTH_LONG).show()
                    //clear txtShow
                    txtShow.text = ""
                    //focus
                    txtNum1.requestFocus()
                } else {
                    //added for messagebox
                    Toast.makeText(this, "Enter in Number 2", Toast.LENGTH_LONG).show()
                    //clear txtShow
                    txtShow.text = ""
                    //focus
                    txtNum2.requestFocus()
                }
            } else {
                val n1: Int = txtNum1.text.toString().toInt()
                val n2: Int = txtNum2.text.toString().toInt()
                val showcalc: Int = calculate(n1, n2)
                txtShow.text = "The sum is ${showcalc}"
                txtNum1.setText("")
                txtNum2.setText("")
                txtNum1.requestFocus()
                hideKeyboard()
            }
        }


        btnMultiply.setOnClickListener {
            if (txtNum1.text.toString() == "" || txtNum2.text.toString() == "") {
                if (txtNum1.text.toString() == "") {
                    //added for messagebox
                    Toast.makeText(this, "Enter in Number 1", Toast.LENGTH_LONG).show()
                    //clear txtShow
                    txtShow.text = ""
                    //focus
                    txtNum1.requestFocus()
                } else {
                    //added for messagebox
                    Toast.makeText(this, "Enter in Number 2", Toast.LENGTH_LONG).show()
                    //clear txtShow
                    txtShow.text = ""
                    //focus
                    txtNum2.requestFocus()
                }
            } else {
                val n1: Int = txtNum1.text.toString().toInt()
                val n2: Int = txtNum2.text.toString().toInt()
                val showcalc: Int = multiply(n1, n2)
                txtShow.text = "The product is ${showcalc}"
                txtNum1.setText("")
                txtNum2.setText("")
                txtNum1.requestFocus()
            }
        }

        hideKeyboard()
        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }

    }
    fun calculate(a: Int, b: Int): Int {
        return a + b
    }
    fun multiply(a: Int, b: Int): Int {
        return a * b
    }
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
// TODO: handle exception
        }

    }
}
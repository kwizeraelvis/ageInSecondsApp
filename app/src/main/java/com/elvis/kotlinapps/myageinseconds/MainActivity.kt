package com.elvis.kotlinapps.myageinseconds

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_date_picker: Button = findViewById<Button>(R.id.btnDatePicker)
        btn_date_picker.setOnClickListener{view ->
            clickDatePicker(view)
        }
    }

    fun clickDatePicker(view: View){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener{
                    view: DatePicker?, year: Int, month: Int, dayOfMonth: Int ->
                    val selectedDate = "$dayOfMonth/${month + 1}/$year";
                    val selectedDateDisplay =  findViewById<TextView>(R.id.date);
                    selectedDateDisplay.text = selectedDate;
                    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    val finalDate = sdf.parse(selectedDate);
                    val selectedDateInMinutes = finalDate!!.time / 60000
                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    val currentDateInMinutes = currentDate!!.time / 60000
                    val diffrenceInMinutes = currentDateInMinutes - selectedDateInMinutes;
                    val resultDisplay = findViewById<TextView>(R.id.display)
                    resultDisplay.text = diffrenceInMinutes.toString()
                }
                ,year,month,day).show()
    }
}
package com.example.senthil.kotlin_datepicker

import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.*

class DatePickerActivity : AppCompatActivity() {

    lateinit var billDateEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)

        billDateEditText = findViewById(R.id.billDate_editText_billUpload)

        showDatePicker()
    }

    fun showDatePicker() {
        // DatePicker

        billDateEditText.setText(SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()))

        var cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd/MM/yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            billDateEditText.setText(sdf.format(cal.time))
        }

        billDateEditText.setOnClickListener {

            Log.d("Clicked", "Interview Date Clicked")

            val dialog = DatePickerDialog(this, dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH))
            dialog.datePicker.maxDate = CalendarHelper.getCurrentDateInMills()
            dialog.show()
        }
    }
}

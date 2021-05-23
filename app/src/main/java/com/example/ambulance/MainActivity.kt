package com.example.ambulance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val genders = findViewById<RadioGroup>(R.id.genders)
        val sub = findViewById<Button>(R.id.sub)
        genders.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                Toast.makeText(
                    applicationContext, " On checked change :" +
                            " ${radio.text}",
                    Toast.LENGTH_SHORT
                ).show()
            })
        // Get radio group selected status and text using button click event
        sub.setOnClickListener {
            // Get the checked radio button id from radio group
            var id: Int = genders.checkedRadioButtonId
            if (id != -1) { // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = findViewById(id)
                Toast.makeText(
                    applicationContext, "On button click :" +
                            " ${radio.text}",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // If no radio button checked in this radio group
                Toast.makeText(
                    applicationContext, "On button click :" +
                            " nothing selected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    // Get the selected radio button text using radio button on click listener
    fun radio_button_click(view: View) {
        // Get the clicked radio button instance
        val genders = findViewById<RadioGroup>(R.id.genders)
        val radio: RadioButton = findViewById(genders.checkedRadioButtonId)
        Toast.makeText(
            applicationContext, "On click : ${radio.text}",
            Toast.LENGTH_SHORT
        ).show()
    }
    fun dropDown()
    {
        val location = resources.getStringArray(R.array.Location)
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, location
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :

                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.selected_item) + " " +
                                "" + location[position], Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }
}


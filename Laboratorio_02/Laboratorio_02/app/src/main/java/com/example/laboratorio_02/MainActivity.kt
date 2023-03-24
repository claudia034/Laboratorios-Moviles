package com.example.laboratorio_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {


    //UI variables
    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var BMITextView: TextView
    private lateinit var weightClassTextView: TextView
    private lateinit var rangeBMITextView: TextView
    private lateinit var actionCalculateButton: Button

    //logical variables
    private var height = 0.0
    private var weight = 0.0
    private var bmi  = 0.0
    private var range_information = ""
    private var bmi_person = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //hide actionbar
        supportActionBar!!.hide();

        //calling functions
        bind()

        //setting button action onclick
        actionCalculateButton.setOnClickListener{
            weight = weightEditText.text.toString().toDouble();
            height = heightEditText.text.toString().toDouble();

            if(weight != 0.0 && height != 0.0) BMICalculator()
        }



    }

    private fun bind(){
        weightEditText = findViewById(R.id.weight_edit_text)
        heightEditText = findViewById(R.id.height_edit_text)
        rangeBMITextView = findViewById(R.id.range_bmi_edit_text)
        BMITextView = findViewById(R.id.bmi_text_view)
        weightClassTextView = findViewById(R.id.weight_class_text_view)
        actionCalculateButton = findViewById(R.id.action_calculate_button)
    }


    //creating function to calculate and display
    private fun BMICalculator() {
        bmi = weight / Math.pow(height/100, 2.0);
        BMITextView.text = String.format("%.2f", bmi)

        //setting data to display
        asignDisplayData()
        weightClassTextView.text = bmi_person
        rangeBMITextView.text = getString(R.string.bmi_description, range_information)


    }

    private fun asignDisplayData(){
        if(bmi < 18.5){
            bmi_person = "Underweight"
            weightClassTextView.setTextColor(resources.getColor(R.color.under_weight))
            range_information = "Less than 18.5"
        }
        else if(bmi in 18.5 .. 24.99){
            bmi_person = "Healthy"
            weightClassTextView.setTextColor(resources.getColor(R.color.normal_weight))
            range_information = "18.5 - 24.99"
        }
        else if(bmi in 25.0 .. 29.99){
            bmi_person = "Overweight"
            weightClassTextView.setTextColor(resources.getColor(R.color.over_weight))
            range_information = "25 - 29.99"
        }
        else if(bmi > 30){
            bmi_person = "Obese"
            weightClassTextView.setTextColor(resources.getColor(R.color.obese))
            range_information = "Greater than 30"
        }
    }
}
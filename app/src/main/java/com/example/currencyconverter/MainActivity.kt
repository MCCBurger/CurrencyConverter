package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val convertMoney = findViewById<EditText>(R.id.idConvertMoney)
        val rbConvertEuro = findViewById<RadioButton>(R.id.idrbtoEuro)
        val rbConvertDollars = findViewById<RadioButton>(R.id.idrbtoDollars)
        val txtResult = findViewById<TextView>(R.id.idResult)
        val convertIt = findViewById<Button>(R.id.btnConvert)

        convertIt.setOnClickListener {
            val dollars = DecimalFormat("##,###.00")
            var dollarAmount = convertMoney.text.toString().toDouble()
            val conversionRate = .93
            var convertMoneyNum:Double?

            if(rbConvertEuro.isChecked){
                if(dollarAmount <=10000){
                   convertMoneyNum = dollarAmount*conversionRate
                    txtResult.text = dollars.format(convertMoneyNum) +" Euros"
                }else{
                    Toast.makeText(this@MainActivity,"Dollars must be less than $10,000.00",Toast.LENGTH_LONG).show()
                }

            }

            if(rbConvertDollars.isChecked){
                if(dollarAmount <=9260){
                    convertMoneyNum = dollarAmount/conversionRate
                    txtResult.text = dollars.format(convertMoneyNum) +" Dollars"
                }else{
                    Toast.makeText(this@MainActivity,"Euros must be less than 9,260",Toast.LENGTH_LONG).show()
                }

            }




        }



    }
}

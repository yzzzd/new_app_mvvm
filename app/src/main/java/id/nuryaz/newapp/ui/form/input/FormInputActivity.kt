package id.nuryaz.newapp.ui.form.input

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.google.gson.Gson
import id.nuryaz.newapp.R
import id.nuryaz.newapp.data.constant.Constants
import id.nuryaz.newapp.ui.base.BaseActivity
import id.nuryaz.newapp.ui.form.output.FormOutputActivity
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class FormInputActivity : BaseActivity<FormInputViewModel>() {

    private lateinit var inputLocation: AutoCompleteTextView
    private lateinit var datePicker: TextView
    private lateinit var timePicker: TextView
    private lateinit var checkAcc1: CheckBox
    private lateinit var checkAcc2: CheckBox
    private lateinit var checkAcc3: CheckBox
    private lateinit var radioType: RadioGroup
    private lateinit var ratingBar: RatingBar
    private lateinit var buttonSave: Button

    private var valueLocation = ""
    private var valueDate = ""
    private var valueTime = ""
    private var valueAccessories = ArrayList<String>()
    private var valueType = ""
    private var valueRating = 0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_input)

        inputLocation = findViewById(R.id.input_location)
        datePicker = findViewById(R.id.date_picker)
        timePicker = findViewById(R.id.time_picker)
        checkAcc1 = findViewById(R.id.check_acc1)
        checkAcc2 = findViewById(R.id.check_acc2)
        checkAcc3 = findViewById(R.id.check_acc3)
        radioType = findViewById(R.id.radio_type)
        ratingBar = findViewById(R.id.rating_bar)
        buttonSave = findViewById(R.id.btn_save)

        //region autocomplete
        val dataLocation = resources.getStringArray(R.array.location)
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, dataLocation)
        inputLocation.setAdapter(adapter)
        //endregion

        //region datepicker
        datePicker.setOnClickListener {
            val picker = MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Pilih tanggal")
                    .build()

            picker.show(supportFragmentManager, "date")

            picker.addOnPositiveButtonClickListener {
                Log.d("tanggal", "${picker.selection}")

                val calendar = Calendar.getInstance()
                calendar.timeInMillis = picker.selection!!

                datePicker.text = "${calendar[Calendar.YEAR]}-${calendar[Calendar.MONTH]+1}-${calendar[Calendar.DATE]}"
                valueDate = "${calendar[Calendar.YEAR]}-${calendar[Calendar.MONTH]+1}-${calendar[Calendar.DATE]}"
            }
        }
        //endregion

        //region timepicker
        timePicker.setOnClickListener {
            val picker = MaterialTimePicker.Builder()
                    .setTimeFormat(TimeFormat.CLOCK_24H)
                    .setHour(12)
                    .setMinute(10)
                    .setTitleText("Select Appointment time")
                    .build()

            picker.show(supportFragmentManager, "time")

            picker.addOnPositiveButtonClickListener {
                timePicker.text = "${picker.hour}:${picker.minute}"
                valueTime = "${picker.hour}:${picker.minute}"
            }
        }
        //endregion

        //region checkbox
        checkAcc1.setOnCheckedChangeListener { compoundButton, b ->
            Log.d("checkbox1", "klik: $b")
            if (b) {
                valueAccessories.add(compoundButton.text.toString())
            } else {
                valueAccessories.remove(compoundButton.text.toString())
            }
        }
        checkAcc2.setOnCheckedChangeListener { compoundButton, b ->
            Log.d("checkbox2", "klik: $b")
            if (b) {
                valueAccessories.add(compoundButton.text.toString())
            } else {
                valueAccessories.remove(compoundButton.text.toString())
            }
        }
        checkAcc3.setOnCheckedChangeListener { compoundButton, b ->
            Log.d("checkbox3", "klik: $b")
            if (b) {
                valueAccessories.add(compoundButton.text.toString())
            } else {
                valueAccessories.remove(compoundButton.text.toString())
            }
        }
        //endregion

        //region radio
        radioType.setOnCheckedChangeListener { radioGroup, i ->
            val radioButton = radioGroup.findViewById<RadioButton>(i)
            valueType = radioButton.text.toString()
        }
        //endregion

        ratingBar.setOnRatingBarChangeListener { ratingBar, fl, b ->
            Log.d("rating", "rating: $fl")
            valueRating = fl
        }

        //region button
        buttonSave.setOnClickListener {
            valueLocation = inputLocation.text.toString()

            val outputIntent = Intent(this, FormOutputActivity::class.java).apply {
                putExtra(Constants.INTENT.KEY_LOCATION, valueLocation)
                putExtra(Constants.INTENT.KEY_DATE, valueDate)
                putExtra(Constants.INTENT.KEY_TIME, valueTime)
                putExtra(Constants.INTENT.KEY_ACC, Gson().toJson(valueAccessories))
                putExtra(Constants.INTENT.KEY_TYPE, valueType)
                putExtra(Constants.INTENT.KEY_RATING, valueRating)
            }

            startActivity(outputIntent)
        }
        //endregion
    }
}
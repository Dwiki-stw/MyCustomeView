package com.example.mycostumeview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.mycostumeview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setMyButtonEnable()

        binding.myTextview.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable?) {
                
            }
        } )

        binding.myButton.setOnClickListener{
            Toast.makeText(this@MainActivity, binding.myTextview.text, Toast.LENGTH_SHORT).show()
        }

    }

    private fun setMyButtonEnable(){
        val result = binding.myTextview.text
        binding.myButton.isEnabled = result != null && result.toString().isNotEmpty()
    }
}
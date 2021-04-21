package com.example.supercompress

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    companion object {
        private const val ORIGINAL_IMAGE = "Original Image"
        private const val COMPRESSED_IMAGE = "Compressed Image"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageSpinner = findViewById<Spinner>(R.id.imageSelector)

        val imageList = arrayOf("Select Image", "Girl", "Bus", "Paris")

        val imageSpinnerAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, imageList)
        imageSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        imageSpinner.adapter = imageSpinnerAdapter

        val originalImageText = findViewById<TextView>(R.id.originalImageText)
        val compressedImageText = findViewById<TextView>(R.id.compressedImageText)
        val originalImage = findViewById<ImageView>(R.id.originalImage)
        val compressedImage = findViewById<ImageView>(R.id.compressedImage)

        originalImageText.text = ORIGINAL_IMAGE
        compressedImageText.text = COMPRESSED_IMAGE

        imageSpinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                arg0: AdapterView<*>?,
                arg1: View?,
                position: Int,
                id: Long
            ) {
                if (position > 0) {
                    originalImageText.text = ""
                    compressedImageText.text = ""

                    val inputStream = assets.open(imageList[position].toLowerCase() + ".png")
                    val bitmap = BitmapFactory.decodeStream(inputStream)
                    originalImage.setImageBitmap(bitmap)

                    val inputStream2 = assets.open(imageList[1 + ((position + 1) % (imageList.size-1))].toLowerCase() + ".png")
                    val bitmap2 = BitmapFactory.decodeStream(inputStream2)
                    compressedImage.setImageBitmap(bitmap2)
                } else {
                    originalImageText.text = ORIGINAL_IMAGE
                    compressedImageText.text = COMPRESSED_IMAGE
                    originalImage.setImageResource(android.R.color.transparent)
                    compressedImage.setImageResource(android.R.color.transparent)
                }
            }
        }
    }
}
package com.deksi.bpsfmmobileapp.home.quickActions.addRequest

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.deksi.bpsfmmobileapp.R
import com.deksi.bpsfmmobileapp.databinding.ActivityAddRequestBinding
import com.deksi.bpsfmmobileapp.home.quickActions.QuickActionActivity
import com.google.android.material.snackbar.Snackbar

class AddRequestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddRequestBinding
    private val PICK_IMAGE_REQUEST = 1
    private var selectedImage: ByteArray? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddRequestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpListeners()

    }

    private fun setUpListeners() {
        val imageViewUpload = binding.imageViewUploadCloud
        val textViewUpload = binding.textViewClickToUpload
        val buttonCancel = binding.buttonCancel
        val buttonSave = binding.buttonSave
        val imageViewX = binding.imageViewX

        textViewUpload.setOnClickListener {
            openFileChooser()
        }

        imageViewUpload.setOnClickListener {
            openFileChooser()
        }

        imageViewX.setOnClickListener {
            val intent = Intent(this, QuickActionActivity::class.java)
            startActivity(intent)
        }

        buttonCancel.setOnClickListener {
            val intent = Intent(this, QuickActionActivity::class.java)
            startActivity(intent)
            finish()
        }

        buttonSave.setOnClickListener {
            Snackbar.make(buttonSave, "Successfully saved!", Snackbar.LENGTH_LONG).show()
        }
    }


    private fun openFileChooser() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select image"), PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {
            // Handle the selected image
            val imageUri = data.data

            // Load and display the image
            val inputStream = contentResolver.openInputStream(imageUri!!)
            val image = BitmapFactory.decodeStream(inputStream)
            inputStream?.close()

            // Set the selected image in the ImageView
//            imageView.setImageBitmap(image)

            // Convert the selected image to a byte array if needed
//            selectedImage = getImageBytes(image)
        }
    }

//    private fun getImageBytes(bitmap: Bitmap): ByteArray {
//        val stream = ByteArrayOutputStream()
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream)
//        return stream.toByteArray()
//    }

}
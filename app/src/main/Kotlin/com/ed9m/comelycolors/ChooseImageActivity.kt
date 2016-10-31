package com.ed9m.comelycolors

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.widget.ImageButton
import android.widget.ImageView


class ChooseImageActivity : AppCompatActivity() {

    val GALLERY_PICK = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_choose_image)
        val imgBtnOpenGallery = findViewById(R.id.imgBtnOpenGallery) as ImageButton
        imgBtnOpenGallery.setOnClickListener { openGallery() }
    }

    private fun openGallery() {
        val galleryIntent = Intent(
                Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)

        startActivityForResult(galleryIntent, GALLERY_PICK)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == GALLERY_PICK) {
                var b = MediaStore.Images.Media.getBitmap(contentResolver, data?.data)
                val imageView = findViewById(R.id.imageView) as ImageView
                imageView.setImageBitmap(b)
            }
        }
    }

}
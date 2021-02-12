package com.denver.fddta

import com.denver.fddta.firestore.FirestoreActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

  private var btnFirestore: Button? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    btnFirestore = requireViewById(R.id.btn_firestore)
    btnFirestore!!.setOnClickListener(this)
  }

  override fun onClick(view: View?) {
    if (view == btnFirestore) {
      startActivity(Intent(this, FirestoreActivity::class.java))
    } else {
      throw IllegalArgumentException("unknown view: $view")
    }
  }

}
// Copyright 2021 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.denver.fddta

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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
      try {
        Class.forName("com.denver.fddta.firestore.FirestoreActivity");
      } catch (e: ClassNotFoundException) {
        Toast.makeText(this, "Not available", Toast.LENGTH_SHORT).show();
        return
      }
      val intent = Intent()
      intent.component =
        ComponentName("com.denver.fddta", "com.denver.fddta.firestore.FirestoreActivity")
      startActivity(intent)
    } else {
      throw IllegalArgumentException("unknown view: $view")
    }
  }

}

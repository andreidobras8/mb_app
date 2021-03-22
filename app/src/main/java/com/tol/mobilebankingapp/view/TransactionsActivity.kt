package com.tol.mobilebankingapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.tol.mobilebankingapp.R
import com.tol.mobilebankingapp.utils.AnimationHelper

class TransactionsActivity : AppCompatActivity() {

    var isCardFlipped: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transactions)

        supportActionBar?.hide()

        val showBtn: Button = findViewById<ConstraintLayout>(R.id.card).findViewById<Button>(R.id.show)
        showBtn.setOnClickListener {
            isCardFlipped = AnimationHelper.startAnimation(this, showBtn, isCardFlipped)
        }

        val goPremiumBtn: Button = findViewById<Button>(R.id.go_premium_btn)
        goPremiumBtn.setOnClickListener {
            val intent = Intent(this, PremiumActivity::class.java)
            startActivity(intent)
        }
    }
}
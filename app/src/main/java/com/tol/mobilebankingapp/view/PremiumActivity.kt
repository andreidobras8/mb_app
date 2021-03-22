package com.tol.mobilebankingapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.github.mikephil.charting.charts.PieChart
import com.tol.mobilebankingapp.R
import com.tol.mobilebankingapp.utils.AnimationHelper
import com.tol.mobilebankingapp.utils.PieChartHelper


class PremiumActivity : AppCompatActivity() {

    var isCardFlipped: Boolean = false

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_premium)

        supportActionBar?.hide()

        val pieChart: PieChart = findViewById<PieChart>(R.id.pie_chart)
        PieChartHelper.getPieChart(pieChart, this)

        val showBtn: Button = findViewById<ConstraintLayout>(R.id.card).findViewById<Button>(R.id.show)
        showBtn.setOnClickListener {
            isCardFlipped = AnimationHelper.startAnimation(this, showBtn, isCardFlipped)
        }
    }
}
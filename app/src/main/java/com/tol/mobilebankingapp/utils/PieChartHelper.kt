package com.tol.mobilebankingapp.utils

import android.content.Context
import android.graphics.Color
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import java.text.NumberFormat

class PieChartHelper {

    companion object {
        private val values: IntArray = intArrayOf(30, 25, 20, 15, 10)
        private val colors: ArrayList<Int> = getPieChartColors()

        fun getPieChart(pieChart: PieChart, ctx: Context): PieChart {
            return getChart(pieChart, values, ctx, colors, 10F)
        }

        private fun getChart(
            pieChart: PieChart,
            values: IntArray,
            ctx: Context?,
            colors: ArrayList<Int>,
            size: Float
        ): PieChart {
            pieChart.description = null
            pieChart.disableScroll()
            pieChart.setBackgroundColor(Color.TRANSPARENT)
            pieChart.holeRadius = size
            pieChart.isDrawHoleEnabled = true
            pieChart.setHoleColor(Color.TRANSPARENT)
            pieChart.setTransparentCircleAlpha(0)
            pieChart.setTransparentCircleColor(Color.TRANSPARENT)
            pieChart.isRotationEnabled = false
            pieChart.setTouchEnabled(true)
            val entries: MutableList<PieEntry> = ArrayList()
            for (i in values.indices) {
                val pieEntry = PieEntry(values[i].toFloat())
                if (pieEntry.y != 0f) {
                    entries.add(pieEntry)
                }
            }
            val dataSet = PieDataSet(entries, "")
            dataSet.colors = colors
            dataSet.valueTextSize = 12f
            dataSet.valueTextColor = Color.WHITE
            dataSet.formSize = 20f
            val pieData = PieData(dataSet)
            pieData.setValueTextSize(16f)
            pieChart.data = pieData
            val legend = pieChart.legend
            legend.isEnabled = false
            pieChart.invalidate() // refresh

            dataSet.valueFormatter = object : ValueFormatter() {
                private val formatter = NumberFormat.getPercentInstance()

                override fun getFormattedValue(value: Float) =
                    formatter.format(value / 100f)
            }

            return pieChart
        }

        private fun getPieChartColors(): ArrayList<Int> {
            val list: ArrayList<Int> = ArrayList()
            list.add(Color.parseColor("#c66900"))
            list.add(Color.parseColor("#ff9800"))
            list.add(Color.parseColor("#ffc947"))
            list.add(Color.parseColor("#707070"))
            list.add(Color.parseColor("#9e9e9e"))
            list.add(Color.parseColor("#cfcfcf"))
            return list
        }
    }
}
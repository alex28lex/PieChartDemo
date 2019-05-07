package com.ginzago.courier.piechartdemo


import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), OnChartValueSelectedListener {
    val yvalues = ArrayList<PieEntry>()
    val dataSet = PieDataSet(yvalues, "")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pieChart.setUsePercentValues(true)

        // IMPORTANT: In a PieChart, no values (Entry) should have the same
        // xIndex (even if from different DataSets), since no values can be
        // drawn above each other.
        yvalues.add(PieEntry(8f, "8"))
        yvalues.add(PieEntry(15f, "15"))
        yvalues.add(PieEntry(12f, "12"))
        yvalues.add(PieEntry(25f, "25"))
        yvalues.add(PieEntry(23f, "23"))
        yvalues.add(PieEntry(17f, "17"))



        dataSet.setDrawValues(false)
        dataSet.sliceSpace = 10f
        // dataSet.setColors(tonalityColors, chart.context)

        val data = PieData(dataSet)
        // In Percentage term
        data.setValueFormatter(PercentFormatter())
        // Default value
        //data.setValueFormatter(new DefaultValueFormatter(0));
        pieChart.data = data

        pieChart.isDrawHoleEnabled = true
        pieChart.transparentCircleRadius = 25f
        pieChart.holeRadius = 25f

        dataSet.setColors(*ColorTemplate.VORDIPLOM_COLORS)
        data.setValueTextSize(13f)
        data.setValueTextColor(Color.DKGRAY)
        pieChart.setOnChartValueSelectedListener(this)

        pieChart.animateXY(1400, 1400)

    }

    override fun onNothingSelected() {

    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {
        dataSet.removeEntry(e as PieEntry)
      //  pieChart.notifyDataSetChanged()
       // pieChart .animateXY(3000,2000, Easing.EasingOption.EaseInQuart,Easing.EasingOption.EaseInOutCubic)
            // pieChart.invalidate()
    }
}

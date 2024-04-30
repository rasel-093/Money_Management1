package com.example.money_management1.components.charts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.yml.charts.common.model.PlotType
import co.yml.charts.ui.piechart.charts.PieChart
import co.yml.charts.ui.piechart.models.PieChartConfig
import co.yml.charts.ui.piechart.models.PieChartData
import com.example.money_management1.model.ExpenseCategory
import kotlin.random.Random

//categoryList: List<ExpenseCategory>, categoryValues: List<Float>
@Composable
fun CustomPieChart(labels: List<String>, values: List<Float>, colors: List<Color>) {
    val slices = mutableListOf<PieChartData.Slice>()
    for (i in labels.indices){
        slices.add(PieChartData.Slice(labels[i],values[i], colors[i]))
    }
    val pieChartData = PieChartData(
        slices = slices,
//        listOf(
//            PieChartData.Slice(categoryList[0].label, categoryValues[0], Color(0xFF333333)),
//            PieChartData.Slice(categoryList[1].label, categoryValues[1], Color(0xFF666a86)),
//            PieChartData.Slice(categoryList[2].label, categoryValues[2], Color(0xFF95B8D1)),
//            PieChartData.Slice(categoryList[3].label, categoryValues[3], Color(0xFFF53844))
//        ),
        plotType = PlotType.Pie
    )

    val pieChartConfig = PieChartConfig(
        isAnimationEnable = true,
        showSliceLabels = true,
        animationDuration = 1500
    )
    Column {
        PieChart(
            modifier = Modifier
                .width(400.dp)
                .height(400.dp),
            pieChartData,
            pieChartConfig
        )
    }
}
fun randomColor(): Color {
    val r = Random.nextInt(255)
    val g = Random.nextInt(255)
    val b = Random.nextInt(255)
    return Color(r, g, b)
}


package com.example.money_management1.components.charts



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.utils.DataUtils
import co.yml.charts.common.utils.DataUtils.getColorPaletteList
import co.yml.charts.ui.barchart.GroupBarChart
import co.yml.charts.ui.barchart.models.BarPlotData
import co.yml.charts.ui.barchart.models.GroupBar
import co.yml.charts.ui.barchart.models.GroupBarChartData

@Composable
fun CustomGroupedBarChart(months: List<String>) {

    // List of BarData objects representing each group
//    val groupBarDataList = listOf(
//        BarData("Group 1", listOf(10.0f, 20.0f, 30.0f)),
//        BarData("Group 2", listOf(15.0f, 25.0f, 35.0f)),
//        BarData("Group 3", listOf(20.0f, 30.0f, 40.0f)),
//    )
//    val barColorList = listOf(Color.Red, Color.Green, Color.Blue)



    val maxRange = 10000
//    val groupBarList = GroupBar()

    val groupBarData = BarPlotData(
        groupBarList = DataUtils.getGroupBarChartData(
            listSize = 12, //Number of item, say 10 pair of (Income, Expense)
            maxRange = maxRange,
            barSize = 2 //Number of bar, Say Income+Expense
        ),
        barColorPaletteList = getColorPaletteList(12)
    )

    val xAxisData = AxisData.Builder()
        .axisStepSize(30.dp)
        .steps(3) //groupBarData.groupingSize - 1
        .bottomPadding(40.dp)
        .labelData { index -> months[index] }
        .build()

    val yAxisData = AxisData.Builder()
        .steps(maxRange /(maxRange/10))
        .labelAndAxisLinePadding(20.dp)
        .axisOffset(30.dp)
        .labelData { index -> (index * (maxRange / 10)).toString() }
        .build()

    val groupBarChartData = GroupBarChartData(
        barPlotData =   groupBarData,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        //paddingBetweenStackedBars = 10.dp,
        horizontalExtraSpace = 20.dp
    )
    Column {
        GroupBarChart(modifier = Modifier.height(300.dp), groupBarChartData = groupBarChartData)
    }
}

//data class BarData(val label: String, val values: List<Float>)
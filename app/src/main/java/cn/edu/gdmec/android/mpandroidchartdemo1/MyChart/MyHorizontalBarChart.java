package cn.edu.gdmec.android.mpandroidchartdemo1.MyChart;

import android.graphics.Color;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by 52626 on 2017/12/6.
 */

public class MyHorizontalBarChart {
    public static BarData getHorizontalBarData(){
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(4f, 0));
        entries.add(new BarEntry(8f, 1));
        entries.add(new BarEntry(6f, 2));
        entries.add(new BarEntry(12f, 3));
        entries.add(new BarEntry(18f, 4));
        entries.add(new BarEntry(9f, 5));

        ArrayList<String> labels = new ArrayList<>();
        labels.add("七月");
        labels.add("八月");
        labels.add("九月");
        labels.add("十月");
        labels.add("十一月");
        labels.add("十二月");

        BarDataSet barDataSet = new BarDataSet(entries,"一组数据");
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        return new BarData(labels,barDataSet);
    }
    public static void showHorizontalBarChart(HorizontalBarChart horizontalBarChart,BarData barData){
        horizontalBarChart.setData(barData);
        horizontalBarChart.animateY(1000);
        horizontalBarChart.setDescription("水平柱状图");
        horizontalBarChart.setDescriptionTextSize(12);
        horizontalBarChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        horizontalBarChart.setGridBackgroundColor(Color.WHITE);
        horizontalBarChart.getAxisRight().setGridColor(Color.WHITE);
        horizontalBarChart.getXAxis().setGridColor(Color.WHITE);
    }
}

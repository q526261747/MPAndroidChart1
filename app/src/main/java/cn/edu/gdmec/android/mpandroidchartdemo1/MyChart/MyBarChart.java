package cn.edu.gdmec.android.mpandroidchartdemo1.MyChart;

import android.graphics.Color;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by 52626 on 2017/12/6.
 */

public class MyBarChart {
    public static BarData getBarData(){
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(4f, 0));
        entries.add(new BarEntry(8f, 1));
        entries.add(new BarEntry(6f, 2));
        entries.add(new BarEntry(12f, 3));
        entries.add(new BarEntry(18f, 4));
        entries.add(new BarEntry(9f, 5));

        ArrayList<String> labels = new ArrayList<>();
        labels.add("一月");
        labels.add("二月");
        labels.add("三月");
        labels.add("四月");
        labels.add("五月");
        labels.add("六月");

        BarDataSet barDataSet = new BarDataSet(entries,"一组数据");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        return new BarData(labels,barDataSet);
    }
    public static void showBarChart(BarChart barChart,BarData barData){
        barChart.setData(barData);
        barChart.animateY(1000);
        barChart.setDescription("柱状图");
        barChart.setScaleEnabled(false);
        barChart.setDescriptionTextSize(12f);
        barChart.setDescriptionPosition(720f,60f);
        barChart.getAxisRight().setEnabled(false);
        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart.setGridBackgroundColor(Color.WHITE);
        barChart.getAxisLeft().setGridColor(Color.WHITE);
        barChart.getXAxis().setGridColor(Color.WHITE);

    }
}

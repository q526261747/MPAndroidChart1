package cn.edu.gdmec.android.mpandroidchartdemo1.MyChart;

import android.graphics.Color;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;

/**
 * Created by 52626 on 2017/12/6.
 */

public class MyPieChart {
    public static PieData getPieData(int count){
        ArrayList<String> x = new ArrayList<>();
        for (int i = 0;i<count;i++){
            x.add("Part"+(i+1));
        }
        ArrayList<Entry> y = new ArrayList<>();
        y.add(new Entry(33,0));
        y.add(new Entry(52,1));
        y.add(new Entry(34,2));
        y.add(new Entry(38,3));

        PieDataSet pieDataSet = new PieDataSet(y,"饼状图");
        pieDataSet.setSliceSpace(3f);

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.rgb(205, 205, 205));
        colors.add(Color.rgb(114, 188, 223));
        colors.add(Color.rgb(255, 123, 124));
        colors.add(Color.rgb(57, 135, 200));

        pieDataSet.setColors(colors);

        return new PieData(x,pieDataSet);
    }
    public static void showPieData(PieChart pieChart, PieData pieData){
        pieChart.setData(pieData);
        pieChart.setHoleRadius(60f);
        pieChart.setTransparentCircleRadius(64f);
        pieChart.setDescription("测试饼状图");
        pieChart.setDrawHoleEnabled(true);
        pieChart.setCenterText("Quarterly Revenue");
        pieChart.animateXY(1000,1000);
        Legend legend = pieChart.getLegend();
        legend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);

    }
}

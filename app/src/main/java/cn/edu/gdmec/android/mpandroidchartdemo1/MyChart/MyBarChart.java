package cn.edu.gdmec.android.mpandroidchartdemo1.MyChart;

import android.graphics.Color;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by 52626 on 2017/12/6.
 */

public class MyBarChart {
    public static BarData getBarData(){
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(new float[]{3f,4f}, 0));
        entries.add(new BarEntry(new float[]{9f,8f}, 1));
        entries.add(new BarEntry(new float[]{8f,6f}, 2));
        entries.add(new BarEntry(new float[]{15f,12f}, 3));
        entries.add(new BarEntry(new float[]{20f,18f}, 4));
        entries.add(new BarEntry(new float[]{11f,9f}, 5));
        ArrayList<String> labels = new ArrayList<>();
        labels.add("一月");
        labels.add("二月");
        labels.add("三月");
        labels.add("四月");
        labels.add("五月");
        labels.add("六月");
        BarDataSet barDataSet = new BarDataSet(entries,"一组数据");
        barDataSet.setColors(getColors(2));
        barDataSet.setValueFormatter(new ValueFormatter() {
            float toggle = 0;
            float totalVal = 0;
            protected DecimalFormat mFormat = new DecimalFormat("###,###,##0.0");
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex,
                                            ViewPortHandler viewPortHandler) {
                if(toggle % 2 == 0){
                    toggle++;
                    totalVal =  value;
                    return "";
                }
//                else if(toggle % 3 == 1){
//                    toggle++;
//                    totalVal =  totalVal + value;
//                    return "";
//                }
                else{
                    toggle++;
                    totalVal = totalVal + value;
                    return mFormat.format(totalVal) + "%";
                }
//                return mFormat.format(value) + " %";
            }
        });
        barDataSet.setStackLabels(new String[]{"难受","舒服"});
        return new BarData(labels,barDataSet);
    }
    private static int[] getColors(int stackSize) {
        //有尽可能多的颜色每项堆栈值
        int[] colors = new int[stackSize];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = ColorTemplate.VORDIPLOM_COLORS[i];
        }
        return colors;
    }
    public static void showBarChart(BarChart barChart,BarData barData){
        barChart.setData(barData);
        barChart.animateY(1000);
        barChart.setDescription("柱状图");
        barChart.setScaleEnabled(false);
        barChart.setDescriptionTextSize(12f);
        barChart.setDescriptionPosition(730f,60f);
        barChart.setTop(barChart.getHighestVisibleXIndex());
        barChart.getAxisRight().setEnabled(false);
        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart.setGridBackgroundColor(Color.WHITE);
        barChart.getAxisLeft().setGridColor(Color.WHITE);
        barChart.getXAxis().setGridColor(Color.WHITE);

    }
}

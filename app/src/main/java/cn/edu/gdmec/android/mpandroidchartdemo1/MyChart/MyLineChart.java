package cn.edu.gdmec.android.mpandroidchartdemo1.MyChart;

import android.graphics.Color;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

/**
 * Created by 52626 on 2017/12/6.
 */

public class MyLineChart {
    public static LineData getLineData(int count, int rang){
        ArrayList<String> x = new ArrayList<>();
        for (int i = 0;i < count;i++){
            x.add(i+"");
        }
        ArrayList<Entry> y = new ArrayList<>();
        for (int i = 0;i < count;i++){
            float result = (float)(Math.random()*rang)+3;
            y.add(new Entry(result,i));
        }
        ArrayList<LineDataSet> lineDatas = new ArrayList<>();
        LineDataSet lineDataSet = new LineDataSet(y,"随机产生的折线图");
        lineDataSet.setLineWidth(1f);
        lineDataSet.setCircleColor(Color.RED);
        lineDataSet.setCircleSize(3f);
        lineDataSet.setColor(Color.GREEN);
        lineDatas.add(lineDataSet);
        return new LineData(x,lineDataSet);
    }
    public static  void showLineChart(LineChart lineChart, LineData lineData){
        lineChart.setDescription("随机生成的数据");
        lineChart.setNoDataTextDescription("我需要数据");
        lineChart.setData(lineData);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.setGridBackgroundColor(Color.WHITE);
        lineChart.getXAxis().setGridColor(Color.WHITE);
        lineChart.getAxisLeft().setGridColor(Color.WHITE);
        lineChart.animateX(2000);

        Legend legend = lineChart.getLegend();
        legend.setForm(Legend.LegendForm.LINE);
        legend.setFormSize(10f);
        legend.setTextColor(Color.BLUE);
    }
}

package cn.edu.gdmec.android.mpandroidchartdemo1;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;

import java.util.ArrayList;
import java.util.List;

import cn.edu.gdmec.android.mpandroidchartdemo1.Adapter.MyPagerAdapter;
import cn.edu.gdmec.android.mpandroidchartdemo1.MyChart.MyBarChart;
import cn.edu.gdmec.android.mpandroidchartdemo1.MyChart.MyLineChart;
import cn.edu.gdmec.android.mpandroidchartdemo1.MyChart.MyPieChart;

import static cn.edu.gdmec.android.mpandroidchartdemo1.MyChart.MyBarChart.getBarData;
import static cn.edu.gdmec.android.mpandroidchartdemo1.MyChart.MyLineChart.getLineData;
import static cn.edu.gdmec.android.mpandroidchartdemo1.MyChart.MyPieChart.getPieData;

public class MainActivity extends AppCompatActivity {
    private LineChart mLineChart;
    private PieChart mPieChart;
    private BarChart mBarChart;
    private List<View> mViews = new ArrayList<>();
    private List<View> dots;
    private int oldPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
        MyLineChart.showLineChart(mLineChart,getLineData(25,100));
        MyPieChart.showPieData(mPieChart,getPieData(4));
        MyBarChart.showBarChart(mBarChart,getBarData());
    }
    public void setView(){
        LayoutInflater inflater = getLayoutInflater();
        ViewPager vp = (ViewPager) findViewById(R.id.viewPager);

        dots = new ArrayList<>();
        dots.add(findViewById(R.id.dot_1));
        dots.add(findViewById(R.id.dot_2));
        dots.add(findViewById(R.id.dot_3));

        dots.get(0).setBackgroundResource(R.drawable.dot_focused);

        View item_line = inflater.inflate(R.layout.chart_line,null);
        View item_pie = inflater.inflate(R.layout.chart_pie,null);
        View item_bar = inflater.inflate(R.layout.chart_bar,null);
        mLineChart = (LineChart) item_line.findViewById(R.id.spread_line_chart);
        mPieChart = (PieChart) item_pie.findViewById(R.id.spread_pie_chart);
        mBarChart = (BarChart) item_bar.findViewById(R.id.spread_bar_chart);
        mViews.add(item_line);
        mViews.add(item_pie);
        mViews.add(item_bar);

        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
                dots.get(position).setBackgroundResource(R.drawable.dot_focused);
                oldPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        MyPagerAdapter myAdapter = new MyPagerAdapter(this,mViews);
        vp.setAdapter(myAdapter);
    }

}

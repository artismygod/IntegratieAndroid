package kdg.be.politiekebarometer;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private BarChart barChart;
    private PieChart pieChart;
    private LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialiseViews();
        addEventHandlers();
    }

    private void addEventHandlers() {
      //  lineChart.setOnChartGestureListener(this);
      // lineChart.setOnChartValueSelectedListener(MainActivity.this);
    }

    private void initialiseViews() {
        barChart = findViewById(R.id.barChart);
        setBarData();

        pieChart = findViewById(R.id.pieChart);
        setPieData();

        lineChart = findViewById(R.id.lineChart);
        setLineData();



    }

    private void setLineData() {
        ArrayList<Entry> yVals = new ArrayList<>();
        yVals.add(new Entry(0, 60f));
        yVals.add(new Entry(1, 50f));
        yVals.add(new Entry(2, 70f));
        yVals.add(new Entry(3, 30f));
        yVals.add(new Entry(4, 50f));
        yVals.add(new Entry(5, 60f));
        yVals.add(new Entry(6, 65f));

        LineDataSet set = new LineDataSet(yVals, "Line Data Set");
        set.setFillAlpha(110);

        set.setColor(Color.RED);
        set.setLineWidth(3f);
        set.setValueTextColor(Color.GREEN);
        set.setValueTextSize(10f);

        ArrayList<ILineDataSet> dataSet = new ArrayList<>();
        dataSet.add(set);
        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);

        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(false);
    }

    private void setPieData() {
        ArrayList<PieEntry> yVals = new ArrayList<>();

        yVals.add(new PieEntry(34f, "SPA"));
        yVals.add(new PieEntry(23f, "NVA"));
        yVals.add(new PieEntry(14f, "Vlaams Belang"));
        yVals.add(new PieEntry(35, "Groen"));
        yVals.add(new PieEntry(40, "PiratenPartij"));
        yVals.add(new PieEntry(23, "OpenVLD"));

        Description description = new Description();
        description.setText("Dit is een PieChart met wat dummy data.");
        description.setTextSize(10);
        pieChart.setDescription(description);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(true);
        pieChart.setExtraOffsets(5, 10, 5, 5);
        pieChart.setDragDecelerationFrictionCoef(0.99f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(60f);

        pieChart.animateY(1000, Easing.EasingOption.EaseInCubic);

        PieDataSet dataSet = new PieDataSet(yVals, "Partijen");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);

        pieChart.setData(data);
    }

    private void setBarData() {
        ArrayList<BarEntry> yVals = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            float value = (float) (Math.random() * 100);
            yVals.add(new BarEntry(i, (int) value));
        }

        barChart.getDescription().setEnabled(false);
        barChart.setFitBars(true);

        BarDataSet set = new BarDataSet(yVals, "Data Set");
        set.setColors(ColorTemplate.MATERIAL_COLORS);
        set.setDrawValues(true);

        BarData data = new BarData(set);

        barChart.setData(data);
        barChart.invalidate();
        barChart.animateY(500);
    }
}

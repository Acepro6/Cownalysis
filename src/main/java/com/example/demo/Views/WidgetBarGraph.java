package com.example.demo.Views;

import com.example.demo.DataClasses.KeyValuePair;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class WidgetBarGraph extends StackPane {
    public WidgetBarGraph(String title, String xAxisTitle, ArrayList<KeyValuePair> items) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yXis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yXis);
        barChart.setTitle(title);

//        xAxis.setLabel(xAxisTitle);
        yXis.setLabel("Value");
        XYChart.Series series = new XYChart.Series();
        series.setName(xAxisTitle);
//        for (HashMap.Entry<String, Number> item: items.entrySet()) {
//            series.getData().add(new XYChart.Data<>(item.getKey(), item.getValue()));
//        }
        for (KeyValuePair item: items) {
            series.getData().add(new XYChart.Data<>(item.getKey(), item.getValue()));
        }

        barChart.getData().add(series);
        barChart.setCategoryGap(1);
//        for(Node n:barChart.lookupAll(".default-color0.chart-bar")) {
//            n.setStyle("-fx-bar-fill: black;");
//        }
        this.getChildren().add(barChart);
        this.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius:20");


    }
}

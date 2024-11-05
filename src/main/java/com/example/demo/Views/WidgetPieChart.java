package com.example.demo.Views;

import com.example.demo.Enums.Icon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class WidgetPieChart extends StackPane{
    PieChart pieChart;
    public WidgetPieChart(String title, HashMap<String, Integer> items) {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        for (HashMap.Entry<String, Integer> item: items.entrySet()) {
            data.add(new PieChart.Data(item.getKey(), item.getValue()));
        }

//        ObservableList<PieChart.Data> pieChartData =
//                FXCollections.observableArrayList(
//                new PieChart.Data("Grapefruit", 13),
//                new PieChart.Data("Oranges", 25),
//                new PieChart.Data("Plums", 10),
//                new PieChart.Data("Pears", 22),
//                new PieChart.Data("Apples", 30));
        final PieChart chart = new PieChart(data);
        chart.setTitle(title);
        this.getChildren().add(chart);
        this.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius:20");

    }
}

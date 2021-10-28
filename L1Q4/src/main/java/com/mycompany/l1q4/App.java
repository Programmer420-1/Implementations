package com.mycompany.l1q4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Line Chart
       
        stage.setTitle("L1Q4");
        stage.setWidth(500);
        stage.setHeight(500);
        
        final NumberAxis yAxis = new NumberAxis();
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Months");
        // Creating the chart
        
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(xAxis,yAxis);
        
        lineChart.setTitle("L1Q4 Data Visualization");
        
        // defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Data");
        
        // Populating the chart wtith data
        series.getData().add(new XYChart.Data("January 2016",2500));
        series.getData().add(new XYChart.Data("February 2016",1600));
        series.getData().add(new XYChart.Data("March 2016",2000));
        series.getData().add(new XYChart.Data("April 2016",2700));
        series.getData().add(new XYChart.Data("May 2016",3200));
        series.getData().add(new XYChart.Data("Jun 2016",800));
        
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
       
        stage.setScene(scene);
        stage.show();       
        
        // Pie Chart
        //Scene scene = new Scene(new Group());
//        ObservableList<PieChart.Data> pieChartData =
//                FXCollections.observableArrayList(
//                    new PieChart.Data("January 2016",2500),
//                    new PieChart.Data("February 2016",1600),
//                    new PieChart.Data("March 2016",2000),
//                    new PieChart.Data("April 2016",2700),
//                    new PieChart.Data("May 2016",3200),
//                    new PieChart.Data("Jun 2016",800)
//        );
//        
//        
//        
//        final PieChart chart = new PieChart(pieChartData);
//        chart.setTitle("L1Q4 Data Visualization");
//        
//        ((Group) scene.getRoot()).getChildren().add(chart);
//        stage.setScene(scene);
//        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
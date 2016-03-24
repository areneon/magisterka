/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regression.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.ShapeUtilities;
import regression.Function;
import regression.Point;

/**
 *
 * @author Cyga
 */
public class RegressionChart extends javax.swing.JFrame {

    public RegressionChart(Function function, List<Point> points) {

        final XYDataset dataset = createDataset(function, points);
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }
    
    

    public RegressionChart(List<Point> countedPoints, List<Point> points) {

        final XYDataset dataset = createLogisticDataset(countedPoints, points);
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }

    /**
     * Creates a sample dataset.
     *
     * @return a sample dataset.
     */
    private XYDataset createDataset(Function function, List<Point> points) {
        List<Point> functionPoints = createFunction(function, points);
        final XYSeries series1 = new XYSeries("Funkcja regresji");
        for (Iterator<Point> it = functionPoints.iterator(); it.hasNext();) {
            Point point = it.next();
            series1.add(point.getX(), point.getY());
        }
        final XYSeries series2 = new XYSeries("Punkty Klasy A");
        final XYSeries series3 = new XYSeries("Punkty Klasy B");
        for (Iterator<Point> it = points.iterator(); it.hasNext();) {
            Point point = it.next();
            if (checkIfPointAboveLine(function, point)) {
                series2.add(point.getX(), point.getY());
            } else {
                series3.add(point.getX(), point.getY());
            }

        }

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series2);
        dataset.addSeries(series1);
        dataset.addSeries(series3);
        return dataset;

    }

    /**
     * Creates a sample dataset.
     *
     * @return a sample dataset.
     */
    private XYDataset createLogisticDataset(List<Point> countedPoints, List<Point> points) {

        final XYSeries series1 = new XYSeries("Funkcja regresji");
        for (Iterator<Point> it = countedPoints.iterator(); it.hasNext();) {
            Point point = it.next();
            series1.add(point.getX(), point.getY());
        }
        final XYSeries series2 = new XYSeries("Punkty Klasy A");
         final XYSeries series3 = new XYSeries("Punkty Klasy B");
       int pointToGetFuncton =  countedPoints.size()/2;
        for (Iterator<Point> it = points.iterator(); it.hasNext();) {
            Point point = it.next();
            if(checkIfPointAboveLogistic(countedPoints.get(pointToGetFuncton),point)){
            series2.add(point.getX(), point.getY());
            }else{
            series3.add(point.getX(), point.getY());
            }
            
        }

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series2);
        dataset.addSeries(series1);
        dataset.addSeries(series3);

        return dataset;

    }

    /**
     * Creates a chart.
     *
     * @param dataset the data for the chart.
     *
     * @return a chart.
     */
    private JFreeChart createChart(final XYDataset dataset) {

        final JFreeChart chart = ChartFactory.createScatterPlot(
                "Wykres funkcji regresji", // chart title
                "X", // x axis label
                "Y", // y axis label
                dataset, // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips
                false // urls
        );

        chart.setBackgroundPaint(Color.white);

        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesShape(0, ShapeUtilities.createRegularCross(1, 1));
        renderer.setSeriesShape(2, ShapeUtilities.createRegularCross(1, 1));
        renderer.setSeriesLinesVisible(0, false);

        renderer.setSeriesShapesVisible(1, false);
        renderer.setSeriesLinesVisible(2, false);
        plot.setRenderer(renderer);

        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        return chart;

    }

    public List<Point> createFunction(Function function, List<Point> testingPoints) {
        List<Point> points = new ArrayList<>();
        Collections.sort(testingPoints, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return (int) (o1.getX() - o2.getX());
            }
        });
        Point lastPoint = testingPoints.get(testingPoints.size() - 1);
        Double[] xValues = new Double[testingPoints.size()];

        for (int i = 0; i < testingPoints.size(); i++) {
            xValues[i] = testingPoints.get(i).getX();
        }
        xValues[xValues.length - 1] = lastPoint.getX() + (lastPoint.getX() / 2);

        Double y;
        Double x;
        for (int i = 0; i < xValues.length; i++) {
            for (Iterator<Double> it = function.getFactor().iterator(); it.hasNext();) {
                Double xFactor = it.next();
                y = xValues[i] * xFactor + function.getFreeFactor().doubleValue();
                points.add(new Point(xValues[i], y));
            }
        }

        return points;

    }

    private boolean checkIfPointAboveLine(Function function, Point point) {

        if (point.getY() > ((point.getX() * function.getFactor().get(0)) + function.getFreeFactor())) {
            return true;

        } else {
            return false;
        }
    }

    private boolean checkIfPointAboveLogistic(Point pointFromfunction, Point pointToCalsify) {
        Double a;
        a = Math.pow(pointFromfunction.getX(), 1 / pointFromfunction.getY());

        if (pointToCalsify.getY() > logOfX(a, pointToCalsify.getX())) {
            return true;
        } else {
            return false;
        }

    }

    private double logOfX(Double x, Double num) {
        return Math.log(num) / Math.log(x);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regression.linearRegression;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTextArea;
import regression.Function;
import regression.Point;

/**
 *
 * @author Cyga
 */
public class LinearRegression {

    public Function linear(List<Point> data, JTextArea out) throws FileNotFoundException {
        int maxIterations = data.size();
        int n = 0;
        double[] x = new double[maxIterations];
        double[] y = new double[maxIterations];
        Function function = new Function();

        double sumX = 0.0, sumY = 0.0, sumX2 = 0.0, sumXY = 0.0;;
        for (Iterator<Point> it = data.iterator(); it.hasNext();) {
            if (n < maxIterations) {
                Point point = it.next();
                x[n] = point.getX();
                y[n] = point.getY();
                sumX += x[n];
                sumX2 += x[n] * x[n];
                sumY += y[n];
                sumXY = sumXY + (x[n] * y[n]);
                n++;
            }
        }

        double avgX = sumX / n;
        double avgY = sumY / n;

        double xFactor = ((n * sumXY) - (sumX * sumY)) / ((n * sumX2) - (sumX * sumX));
        double freeFactor = avgY - xFactor * avgX;
        double xxbar = 0.0, yybar = 0.0;
        for (int i = 0; i < n; i++) {
            xxbar += (x[i] - sumX) * (x[i] - sumX);
            yybar += (y[i] - sumY) * (y[i] - sumY);
           
        }

//        System.out.println("y   = " + beta1 + " * x + " + beta0);
        out.setText("");
        out.append("y   = " + xFactor + " * x + " + freeFactor + "\n");
        function.addFactor(xFactor);
        function.setFreeFactor(freeFactor);
        // analyze results
        int df = n - 2;
        double rss = 0.0;      // residual sum of squares
        double ssr = 0.0;      // regression sum of squares
        for (int i = 0; i < n; i++) {
            double fit = xFactor * x[i] + freeFactor;
            rss += (fit - y[i]) * (fit - y[i]);
            ssr += (fit - avgY) * (fit - avgY);
        }
        double R2 = ssr / yybar;
        double svar = rss / df;
        double svar1 = svar / xxbar;
        double svar0 = svar / n + avgX * avgX * svar1;

        // out.append("std error of beta_1 = " + Math.sqrt(svar1) + "\n");
        //  out.append("std error of beta_0 = " + Math.sqrt(svar0) + "\n");
        svar0 = svar * sumX2 / (n * xxbar);
        //out.append("std error of beta_0 = " + Math.sqrt(svar0) + "\n");

        out.append("SST = " + yybar + "\n");
        out.append("SSE  = " + rss + "\n");
        out.append("SSR  = " + ssr + "\n");
        out.append("R^2 = " + R2 + "\n");
        saveFunction(function);
        return function;
    }

    private void saveFunction(Function function) throws FileNotFoundException {

        File fileToSave = new File(System.getProperty("user.dir") + "\\src\\regression\\data\\function.txt");
        PrintWriter writer = new PrintWriter(fileToSave);
        writer.print(function.getFactor().get(0) + "?" + function.getFreeFactor());
        writer.close();
    }
}

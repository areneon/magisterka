/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regression.logisticRegression;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.JTextArea;
import regression.Point;

/**
 *
 * @author Cyga
 */
public class LogisticRegression {

    /**
     * the learning rate
     */
    private double rate;

    private List<Point> finalPoints = new ArrayList<>();

    public List<Point> getFinalPoints() {
        return finalPoints;
    }

    public void setFinalPoints(List<Point> finalPoints) {
        this.finalPoints = finalPoints;
    }

    /**
     * the weight to learn
     */
    private double[] weights;

    /**
     * the number of iterations
     */
    private int ITERATIONS = 1;

    public LogisticRegression(int n) {
        this.rate = 0.0001;
        weights = new double[n];
    }

    private double sigmoid(double z) {
        return 1 / (1 + Math.exp(-z));
    }

    public void logistic(List<Point> instances, List<Point> trainingInstances, JTextArea out) throws FileNotFoundException {
        Double[] x = new Double[trainingInstances.size()];

        double lik = 0.0;

        for (int i = 0; i < trainingInstances.size(); i++) {
            x[i] = trainingInstances.get(i).getX();
        }

        for (int i = 0; i < trainingInstances.size(); i++) {
            //Double[] x = trainingInstances.get(i).getX();
            Double predicted = classify(x);
            Double label = trainingInstances.get(i).getY();
            for (int j = 0; j < weights.length; j++) {
                weights[j] = weights[j] + rate * (label - predicted) * x[j];
            }

        }

        out.setText("");
//
//        for (Iterator<Point> it = instances.iterator(); it.hasNext();) {
//            Point instance = it.next();
//            Double zmienna = classifyFinal(instance.getX());
//            out.append("dla danego x: " + instance.getX() + " prawdopodobieństwo wynosi: " + zmienna + "\n");
//
//        }
        classifyFinal2(x,out);
    }

    public Double classify(Double[] x) {
        Double logit = 0.0;
        for (int i = 0; i < weights.length; i++) {
            logit += weights[i] * x[i];
        }
        return sigmoid(logit);
    }

    public Double classifyFinal(Double x) throws FileNotFoundException {
        Double logit = 0.0;
        File fileToSave = new File(System.getProperty("user.dir") + "\\src\\regression\\data\\logisticFunction.txt");
        PrintWriter writer = new PrintWriter(fileToSave);
        for (int i = 0; i < weights.length; i++) {
            logit += weights[i] * x;
            writer.print(weights[i] + "?");
            
        }
       
        
        double y = sigmoid(logit);
        writer.close();
        this.finalPoints.add(new Point(x, y));
        return y;
    }
    
        public Double classifyFinal2(Double[] x, JTextArea out ) throws FileNotFoundException {
        Double logit = 0.0;
        File fileToSave = new File(System.getProperty("user.dir") + "\\src\\regression\\data\\logisticFunction.txt");
        PrintWriter writer = new PrintWriter(fileToSave);
        for (int i = 0; i < weights.length; i++) {
          
            writer.print(weights[i] + "?");
             logit += weights[i] * x[i];
              double y = sigmoid(logit);
            this.finalPoints.add(new Point(x[i], y));
            
             out.append("dla danego x: " + x[i] + " prawdopodobieństwo wynosi: " + y + "\n");
        }
       
        
        double y = sigmoid(logit);
        writer.close();
        
        return y;
    }

    public void classifyToTestFromFile(JTextArea output, File file) throws FileNotFoundException {

        List<Double> weights = new ArrayList<>();
        List<Double> readFromFile = getValuesToTestFromFile(file);

        try (Scanner scan = new Scanner(new File(System.getProperty("user.dir") + "\\src\\regression\\data\\logisticFunction.txt"))) {
            while (scan.hasNext()) {
                String line = scan.nextLine();
                String[] splited = line.split("\\?");
                for (int i = 0; i < splited.length; i++) {
                    weights.add(Double.parseDouble(splited[i]));
                }

            }
        }
        for (Iterator<Double> iterator = readFromFile.iterator(); iterator.hasNext();) {
            Double logit = 0.0;
            Double next = iterator.next();
            for (int i = 0; i < weights.size(); i++) {
                logit += weights.get(i) * next;
            }
            output.append("dla danego x: " + next + " prawdopodobieństwo wynosi: " + sigmoid(logit) + "\n");
        }

    }

    public List<Double> getValuesToTestFromFile(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        List<Double> x = new ArrayList<>();
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] splited = line.split("\\s+");
            for (int i = 0; i < splited.length; i++) {
                x.add(Double.parseDouble(splited[i]));

            }

        }
        scan.close();
        return x;
    }

	public void train(List<Point> points) {
            List<Instance> instances = new ArrayList<Instance>();
            for (Iterator<Point> iterator = points.iterator(); iterator.hasNext();) {
                    Point next = iterator.next();
                    Double xVariable = next.getX();
                    Double[] x = {xVariable};
                    
                    instances.add(new Instance(next.getY(),x));
                }
		for (int n=0; n<ITERATIONS; n++) {
			double lik = 0.0;
			for (int i=0; i<instances.size(); i++) {
				Double[] x = instances.get(i).x;
				double predicted = classify(x);
				Double label = instances.get(i).label;
				for (int j=0; j<weights.length; j++) {
					weights[j] = weights[j] + rate * (label - predicted) * x[j];
				}
				// not necessary for learning
				lik += label * Math.log(classify(x)) + (1-label) * Math.log(1- classify(x));
			}
			System.out.println("iteration: " + n + " " + Arrays.toString(weights) + " mle: " + lik);
		}
	}
}
     

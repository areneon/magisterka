/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regression.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.JTextArea;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import regression.Function;
import regression.Point;

/**
 *
 * @author Cyga
 */
public class GenerateLinearData {

    List<Point> points = new ArrayList<Point>();

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    /**
     * Read data from excel
     *
     * @param file
     * @throws FileNotFoundException
     * @throws IOException
     * @throws InvalidFormatException
     */
    public void readExcelDataSet(File file) throws FileNotFoundException, IOException, InvalidFormatException {
        FileInputStream excelFile = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = firstSheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Cell firstCell = row.getCell(row.getFirstCellNum());
            Cell secondCell = row.getCell(row.getFirstCellNum() + 1);

            if (firstCell.getCellType() == Cell.CELL_TYPE_NUMERIC && secondCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                try {
                    this.points.add(new Point(firstCell.getNumericCellValue(), secondCell.getNumericCellValue()));
                } catch (Exception e) {
                    System.err.println("Cannot convert data in row: " + row.getRowNum());
                }
            }

        }

    }

    public void collectPointsFromFile(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        List<StringPoints> tempPoints = new ArrayList<>();
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] splited = line.split("\\s+");
            if (splited.length > 1) {
                tempPoints.add(new StringPoints(splited[0], splited[1]));
            }

        }

        for (Iterator<StringPoints> it = tempPoints.iterator(); it.hasNext();) {
            StringPoints stringPoint = it.next();
            try {
                this.points.add(stringToDouble(stringPoint));
            } catch (Exception e) {

                continue;
            }
        }

    }

    private Point stringToDouble(StringPoints pretender) {

        Point tmpPoint = new Point(Double.parseDouble(pretender.x), Double.parseDouble(pretender.y));

        return tmpPoint;
    }

    public Function testDataFromFile(File file, JTextArea output) throws FileNotFoundException, IOException, InvalidFormatException {

        FileInputStream excelFile = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = firstSheet.iterator();
        List<Point> points = new ArrayList<>();
        Function function = getLastSavedFunction();
        output.append("Dla Funkcji:y=x" + function.getFactor().get(0) + "+" + function.getFreeFactor() + " Wartości testowe przyjmują" + "\n");
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Cell firstCell = row.getCell(row.getFirstCellNum());
            if (firstCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                try {
                    Double score = countFunction(function, firstCell.getNumericCellValue());
                    this.points.add(new Point(firstCell.getNumericCellValue(), score));
                    output.append("Dla x=" + firstCell.getNumericCellValue() + " y=" + score + "\n");
                } catch (Exception e) {
                    System.err.println("Cannot convert data in row: " + row.getRowNum());
                }
            }

        }

        return function;
    }

    public List<Point> getPointsFromFile(File file) {
        List<Point> pointsFromFile = new ArrayList<>();

        return pointsFromFile;
    }

    public void testSingleData(Double x, JTextArea output) throws FileNotFoundException {
        output.append("Dla x=" + x + " y=" + countFunction(getLastSavedFunction(), x));
    }

    public Function getLastSavedFunction() throws FileNotFoundException {
        Function function = new Function();
        Scanner scan = new Scanner(new File(System.getProperty("user.dir") + "\\src\\regression\\data\\function.txt"));
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] splited = line.split("\\?");
            function.addFactor(Double.parseDouble(splited[0]));
            function.setFreeFactor(Double.parseDouble(splited[1]));

        }
        return function;
    }

    private Double countFunction(Function function, Double x) {
        return function.getFactor().get(0) * x + function.getFreeFactor();
    }

    /**
     * Read data from excel
     *
     * @param file
     * @throws FileNotFoundException
     * @throws IOException
     * @throws InvalidFormatException
     */
    public List<Point> getExcelDataSet(File file) throws FileNotFoundException, IOException, InvalidFormatException {
        FileInputStream excelFile = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = firstSheet.iterator();
        List<Point> points = new ArrayList<>();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Cell firstCell = row.getCell(row.getFirstCellNum());
            Cell secondCell = row.getCell(row.getFirstCellNum() + 1);
        //    if (secondCell != null) {
                if ((firstCell.getCellType() == Cell.CELL_TYPE_NUMERIC && secondCell.getCellType() == Cell.CELL_TYPE_NUMERIC)) {
                    try {
                        points.add(new Point(firstCell.getNumericCellValue(), secondCell.getNumericCellValue()));
                    } catch (Exception e) {
                        System.err.println("Cannot convert data in row: " + row.getRowNum());
                    }
                }
            } //else {
               // if (firstCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
              //      try {
              //          points.add(new Point(firstCell.getNumericCellValue(), 0.0));
             //       } catch (Exception e) {
            //            System.err.println("Cannot convert data in row: " + row.getRowNum());
           //         }
          //      }
         //   }
     //   }
        return points;

    }
}

class StringPoints {

    String x;
    String y;

    public StringPoints(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

}

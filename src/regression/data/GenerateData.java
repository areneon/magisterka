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
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import regression.Point;
import regression.logisticRegression.Instance;

/**
 *
 * @author Cyga
 */
public class GenerateData {

    List<Point> points = new ArrayList<>();
    List<Point> trainingInstances = new ArrayList<>();
    int numberOfInstances;

    public List<Point> getTrainingInstances() {
        return trainingInstances;
    }

    public void setTrainingInstances(List<Point> trainingInstances) {
        this.trainingInstances = trainingInstances;
    }

    public List<Point> getInstances() {
        return points;
    }

    public int getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(int numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public void setInstances(List<Point> instances) {
        this.points = instances;
    }

    public GenerateData() throws FileNotFoundException {

    }

//    public void readDataSet(File file) throws FileNotFoundException {
//        List<Instance> dataset = new ArrayList<Instance>();
//        Scanner scanner = new Scanner(file);
//        while (scanner.hasNextLine()) {
//            String line = scanner.nextLine();
//
//            String[] columns = line.split("\\s+");
//            if (line.startsWith("T")) {
//                try {
//                    int i = 1;
//                    Double[] data = new Double[columns.length - 2];
//
//                    for (i = 1; i < columns.length - 1; i++) {
//                        try {
//                            data[i - 1] = Double.parseDouble(columns[i]);
//                        } catch (Exception e) {
//                            continue;
//                        }
//                    }
//                    Double label = Double.parseDouble(columns[i]);
//                    Point instance = new Point(label, data);
//                    this.instances.add(instance);
//                } catch (Exception e) {
//                    continue;
//                }
//            } else {
//                try {
//                    // skip first column and last column is the label
//                    int i = 0;
//                    Double[] data = new Double[columns.length - 1];
//                    this.numberOfInstances = data.length;
//                    for (i = 0; i < columns.length - 1; i++) {
//                        try {
//                            data[i] = Double.parseDouble(columns[i]);
//                        } catch (Exception e) {
//                            continue;
//                        }
//                    }
//                    Double label = Double.parseDouble(columns[i]);
//                    Instance instance = new Instance(label, data);
//                    this.trainingInstances.add(instance);
//                } catch (Exception e) {
//                    continue;
//                }
//            }
//        }
//
//    }

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
        this.numberOfInstances = points.size();
    }
//    public void readExcelDataSet(File file) throws FileNotFoundException, IOException, InvalidFormatException {
//        FileInputStream excelFile = new FileInputStream(file);
//        XSSFWorkbook workbook = new XSSFWorkbook(file);
//        XSSFSheet firstSheet = workbook.getSheetAt(0);
//        Iterator<Row> rowIterator = firstSheet.iterator();
////        List<Instance> dataset = new ArrayList<Instance>();
////        Scanner scanner = new Scanner(file);
//        while (rowIterator.hasNext()) {
//            Row row = rowIterator.next();
//             Iterator<Cell> cellIterator = row.cellIterator();
//                 
//                while (cellIterator.hasNext()) 
//                {
//                    Cell cell = cellIterator.next();
//                    if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
//                        row.getCell(row.getFirstCellNum());
//                        row.getCell(row.getLastCellNum());
//                    }
//                }
//                }
//           
//
//           
//        
//                try {
//                    // skip first column and last column is the label
//                    int i = 0;
//                    Double[] data = new Double[columns.length - 1];
//                    this.numberOfInstances = data.length;
//                    for (i = 0; i < columns.length - 1; i++) {
//                        try {
//                            data[i] = Double.parseDouble(columns[i]);
//                        } catch (Exception e) {
//                            continue;
//                        }
//                    }
//                    Double label = Double.parseDouble(columns[i]);
//                    Instance instance = new Instance(label, data);
//                    this.trainingInstances.add(instance);
//                } catch (Exception e) {
//                    continue;
//                }
//            }

    //}
}

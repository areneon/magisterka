/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regression.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.ui.RefineryUtilities;
import regression.Function;
import regression.data.GenerateData;
import regression.data.GenerateLinearData;
import regression.linearRegression.LinearRegression;
import regression.logisticRegression.LogisticRegression;
import regression.logisticRegression.LogisticRegressionCorrect;
import weka.core.Instances;

/**
 *
 * @author Cyga
 */
public class MainWindow extends javax.swing.JFrame {

    File file;
    File testFile;
    File testLogisticFile;
    Boolean classify;
LogisticRegressionCorrect regression = new LogisticRegressionCorrect(1);
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectFileWindow = new javax.swing.JFrame();
        jFileChooser = new javax.swing.JFileChooser();
        chartFrame = new javax.swing.JFrame();
        testFrame = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        testTextArea = new javax.swing.JTextArea();
        xTestValue = new javax.swing.JTextField();
        xTestLabel = new javax.swing.JLabel();
        singleTestButton = new javax.swing.JButton();
        testFromFileButton = new javax.swing.JButton();
        classifyForfileButton = new javax.swing.JButton();
        testFileChooserFrame = new javax.swing.JFrame();
        testFileChooser = new javax.swing.JFileChooser();
        LogisticTestFrame = new javax.swing.JFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        logisticTestTextArea = new javax.swing.JTextArea();
        XlogisticTestVariableTextField = new javax.swing.JTextField();
        testSingleLogisticButtin = new javax.swing.JButton();
        testFromFileLinearButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        testLogisticTestArea = new javax.swing.JTextArea();
        testFileChooserLogisticFrame = new javax.swing.JFrame();
        TestLogisticFileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        result = new javax.swing.JTextArea();
        lineRegressionStart = new javax.swing.JButton();
        logisticRegressionStart = new javax.swing.JToggleButton();
        testingButton = new javax.swing.JButton();
        LogisticTestButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemSelectFile = new javax.swing.JMenuItem();

        selectFileWindow.setMinimumSize(new java.awt.Dimension(700, 500));

        jFileChooser.setControlButtonsAreShown(false);
        jFileChooser.setCurrentDirectory(new java.io.File("C:\\Documents and Settings\\Cyga\\Moje dokumenty\\NetBeansProjects\\g\\Regression\\src\\regression\\data"));
        jFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout selectFileWindowLayout = new javax.swing.GroupLayout(selectFileWindow.getContentPane());
        selectFileWindow.getContentPane().setLayout(selectFileWindowLayout);
        selectFileWindowLayout.setHorizontalGroup(
            selectFileWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(selectFileWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(selectFileWindowLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        selectFileWindowLayout.setVerticalGroup(
            selectFileWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(selectFileWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(selectFileWindowLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        chartFrame.setMinimumSize(new java.awt.Dimension(600, 700));

        javax.swing.GroupLayout chartFrameLayout = new javax.swing.GroupLayout(chartFrame.getContentPane());
        chartFrame.getContentPane().setLayout(chartFrameLayout);
        chartFrameLayout.setHorizontalGroup(
            chartFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        chartFrameLayout.setVerticalGroup(
            chartFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        testFrame.setMinimumSize(new java.awt.Dimension(600, 400));

        testTextArea.setColumns(20);
        testTextArea.setRows(5);
        jScrollPane2.setViewportView(testTextArea);

        xTestValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xTestValueActionPerformed(evt);
            }
        });

        xTestLabel.setText("x");

        singleTestButton.setText("Policz pojedynczy");
        singleTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleTestButtonActionPerformed(evt);
            }
        });

        testFromFileButton.setText("Policz dla pliku");
        testFromFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testFromFileButtonActionPerformed(evt);
            }
        });

        classifyForfileButton.setText("Klasyfikuj dla pliku");
        classifyForfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classifyForfileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout testFrameLayout = new javax.swing.GroupLayout(testFrame.getContentPane());
        testFrame.getContentPane().setLayout(testFrameLayout);
        testFrameLayout.setHorizontalGroup(
            testFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testFrameLayout.createSequentialGroup()
                .addGroup(testFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(testFrameLayout.createSequentialGroup()
                        .addGroup(testFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(testFrameLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(xTestValue, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(testFrameLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(xTestLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(singleTestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(testFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(testFromFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(classifyForfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 190, Short.MAX_VALUE)))
                .addContainerGap())
        );
        testFrameLayout.setVerticalGroup(
            testFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testFrameLayout.createSequentialGroup()
                .addGroup(testFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(singleTestButton)
                    .addComponent(testFromFileButton)
                    .addComponent(xTestValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(testFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(classifyForfileButton)
                    .addComponent(xTestLabel))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        testFileChooserFrame.setMinimumSize(new java.awt.Dimension(700, 500));

        testFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testFileChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout testFileChooserFrameLayout = new javax.swing.GroupLayout(testFileChooserFrame.getContentPane());
        testFileChooserFrame.getContentPane().setLayout(testFileChooserFrameLayout);
        testFileChooserFrameLayout.setHorizontalGroup(
            testFileChooserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 582, Short.MAX_VALUE)
            .addGroup(testFileChooserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(testFileChooserFrameLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(testFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        testFileChooserFrameLayout.setVerticalGroup(
            testFileChooserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
            .addGroup(testFileChooserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(testFileChooserFrameLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(testFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        LogisticTestFrame.setMinimumSize(new java.awt.Dimension(600, 400));

        logisticTestTextArea.setColumns(20);
        logisticTestTextArea.setRows(5);
        jScrollPane3.setViewportView(logisticTestTextArea);

        testSingleLogisticButtin.setText("Policz pojedynczy");
        testSingleLogisticButtin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testSingleLogisticButtinActionPerformed(evt);
            }
        });

        testFromFileLinearButton.setText("Policz dla pliku");
        testFromFileLinearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testFromFileLinearButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("x");

        testLogisticTestArea.setColumns(20);
        testLogisticTestArea.setRows(5);
        jScrollPane4.setViewportView(testLogisticTestArea);

        javax.swing.GroupLayout LogisticTestFrameLayout = new javax.swing.GroupLayout(LogisticTestFrame.getContentPane());
        LogisticTestFrame.getContentPane().setLayout(LogisticTestFrameLayout);
        LogisticTestFrameLayout.setHorizontalGroup(
            LogisticTestFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogisticTestFrameLayout.createSequentialGroup()
                .addGroup(LogisticTestFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(LogisticTestFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(LogisticTestFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LogisticTestFrameLayout.createSequentialGroup()
                                .addComponent(XlogisticTestVariableTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogisticTestFrameLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)))
                        .addComponent(testSingleLogisticButtin)
                        .addGap(18, 18, 18)
                        .addComponent(testFromFileLinearButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(LogisticTestFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        LogisticTestFrameLayout.setVerticalGroup(
            LogisticTestFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogisticTestFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LogisticTestFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(XlogisticTestVariableTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(testSingleLogisticButtin)
                    .addComponent(testFromFileLinearButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addContainerGap())
        );

        testFileChooserLogisticFrame.setMinimumSize(new java.awt.Dimension(600, 400));

        TestLogisticFileChooser.setMinimumSize(new java.awt.Dimension(600, 400));
        TestLogisticFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TestLogisticFileChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout testFileChooserLogisticFrameLayout = new javax.swing.GroupLayout(testFileChooserLogisticFrame.getContentPane());
        testFileChooserLogisticFrame.getContentPane().setLayout(testFileChooserLogisticFrameLayout);
        testFileChooserLogisticFrameLayout.setHorizontalGroup(
            testFileChooserLogisticFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 582, Short.MAX_VALUE)
            .addGroup(testFileChooserLogisticFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(testFileChooserLogisticFrameLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(TestLogisticFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        testFileChooserLogisticFrameLayout.setVerticalGroup(
            testFileChooserLogisticFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
            .addGroup(testFileChooserLogisticFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(testFileChooserLogisticFrameLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(TestLogisticFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        result.setColumns(20);
        result.setRows(5);
        jScrollPane1.setViewportView(result);

        lineRegressionStart.setText("Regresja Liniowa");
        lineRegressionStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineRegressionStartActionPerformed(evt);
            }
        });

        logisticRegressionStart.setText("Regresja Logistyczna");
        logisticRegressionStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logisticRegressionStartActionPerformed(evt);
            }
        });

        testingButton.setText("Testuj liniową");
        testingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testingButtonActionPerformed(evt);
            }
        });

        LogisticTestButton.setText("Testuj logistyczną");
        LogisticTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogisticTestButtonActionPerformed(evt);
            }
        });

        jMenu1.setText("Plik");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        menuItemSelectFile.setText("Wybierz plik");
        menuItemSelectFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSelectFileActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemSelectFile);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logisticRegressionStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lineRegressionStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(testingButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LogisticTestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lineRegressionStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(testingButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logisticRegressionStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LogisticTestButton)
                        .addGap(33, 33, 33))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemSelectFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSelectFileActionPerformed
        selectFileWindow.setVisible(true);
    }//GEN-LAST:event_menuItemSelectFileActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooserActionPerformed
        JFileChooser theFileChooser = (JFileChooser) evt.getSource();
        String command = evt.getActionCommand();
        if (command.equals(JFileChooser.APPROVE_SELECTION)) {
            file = theFileChooser.getSelectedFile();
            selectFileWindow.setVisible(false);

        } else if (command.equals(JFileChooser.CANCEL_SELECTION)) {
            selectFileWindow.setVisible(false);

        }
    }//GEN-LAST:event_jFileChooserActionPerformed

    private void lineRegressionStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineRegressionStartActionPerformed
        // TODO add your handling code here:
        result.setText("obliczanie...");
        LinearRegression regression = new LinearRegression();
        GenerateLinearData generate = new GenerateLinearData();

        try {
            //generate.collectPointsFromFile(file);
            // Default excel file 
            //file = new File(System.getProperty("user.dir") + "\\src\\regression\\data\\excelLinear.xlsx");
            generate.readExcelDataSet(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

        RegressionChart chart;
        try {
            chart = new RegressionChart(regression.linear(generate.getPoints(), result), generate.getPoints());
            chart.pack();
            chart.setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_lineRegressionStartActionPerformed

    private void logisticRegressionStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logisticRegressionStartActionPerformed
        // TODO add your handling code here:
        result.setText("obliczanie..."+"\n");

        try {
            GenerateData generate = new GenerateData();
            //file = new File(System.getProperty("user.dir") + "\\src\\regression\\data\\excelLogistic.xlsx");
            generate.readExcelDataSet(file);
            generate.createWekaFile(file);
            
            regression.logistic(generate.getInstances(), generate.getInstances(), result);
            regression.weka(result);
            RegressionChart chart;

            chart = new RegressionChart(regression.getFinalPoints(), generate.getInstances(),regression.getFinalProbPoints() );
            chart.pack();
            chart.setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_logisticRegressionStartActionPerformed

    private void testingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testingButtonActionPerformed

        testFrame.setVisible(true);
    }//GEN-LAST:event_testingButtonActionPerformed

    private void testFromFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testFromFileButtonActionPerformed
        classify = false;
        testFileChooserFrame.setVisible(true);
    }//GEN-LAST:event_testFromFileButtonActionPerformed

    private void singleTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleTestButtonActionPerformed
        GenerateLinearData generate = new GenerateLinearData();

        try {
            
            generate.testSingleData(Double.parseDouble(xTestValue.getText()), testTextArea);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_singleTestButtonActionPerformed

    private void xTestValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xTestValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xTestValueActionPerformed

    private void testFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testFileChooserActionPerformed
        JFileChooser theFileChooser = (JFileChooser) evt.getSource();
        String command = evt.getActionCommand();
        if (command.equals(JFileChooser.APPROVE_SELECTION)) {
            testFile = theFileChooser.getSelectedFile();
            testFileChooserFrame.setVisible(false);
            GenerateLinearData generate = new GenerateLinearData();
            try {
                Function function = generate.testDataFromFile(testFile, testTextArea);
                RegressionChart chart;
                if (classify) {
                    chart = new RegressionChart(function, generate.getExcelDataSet(testFile));
                    chart.pack();
                    chart.setVisible(true);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidFormatException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (command.equals(JFileChooser.CANCEL_SELECTION)) {
            testFileChooserFrame.setVisible(false);

        }

    }//GEN-LAST:event_testFileChooserActionPerformed

    private void testSingleLogisticButtinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testSingleLogisticButtinActionPerformed
      
        List<Double> xList = new ArrayList<>();
        xList.add(Double.parseDouble(XlogisticTestVariableTextField.getText()));
        createExcelFile(xList);
       File fileExcel = new File(System.getProperty("user.dir") +"\\single.xlsx");
       createWekaFile("wekaSingle.arff", fileExcel);
            BufferedReader reader;
        try {
            reader = new BufferedReader(
                    new FileReader("wekaSingle.arff"));
              Instances instances = new Instances(reader);
        instances.setClassIndex(instances.numAttributes()-1);
            regression.singleTest(instances, testLogisticTestArea);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }//GEN-LAST:event_testSingleLogisticButtinActionPerformed

    private void testFromFileLinearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testFromFileLinearButtonActionPerformed
        testFileChooserLogisticFrame.setVisible(true);
       
    }//GEN-LAST:event_testFromFileLinearButtonActionPerformed

    private void TestLogisticFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TestLogisticFileChooserActionPerformed
        JFileChooser theFileChooser = (JFileChooser) evt.getSource();
        String command = evt.getActionCommand();
        if (command.equals(JFileChooser.APPROVE_SELECTION)) {
            testLogisticFile = theFileChooser.getSelectedFile();
            testFileChooserLogisticFrame.setVisible(false);
            String newWekaFile="logosticWekaTestFile.arff";
        createWekaFile(newWekaFile, testLogisticFile);
        BufferedReader reader;
        try {
            reader = new BufferedReader(
                    new FileReader(newWekaFile));
              Instances instances = new Instances(reader);
        instances.setClassIndex(instances.numAttributes()-1);
            regression.singleTest(instances, testLogisticTestArea);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

        } else if (command.equals(JFileChooser.CANCEL_SELECTION)) {
            testFileChooserLogisticFrame.setVisible(false);

        }
    }//GEN-LAST:event_TestLogisticFileChooserActionPerformed

    private void LogisticTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogisticTestButtonActionPerformed
        classify = false;
        LogisticTestFrame.setVisible(true);

    }//GEN-LAST:event_LogisticTestButtonActionPerformed

    private void classifyForfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classifyForfileButtonActionPerformed
        classify = true;
        testFileChooserFrame.setVisible(true);
    }//GEN-LAST:event_classifyForfileButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    
    void createWekaFile(String pathToNewWekaFile, File fileExcel){
        
          try {
             
        File wekaFile = new File(pathToNewWekaFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fileExcel);
        XSSFSheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = firstSheet.iterator();
        PrintWriter writer = new PrintWriter(wekaFile);
        writer.println("@RELATION logistic");
        writer.println("@ATTRIBUTE x NUMERIC");
        writer.println("@ATTRIBUTE class {1,0}");
        writer.println("@DATA");
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Cell firstCell = row.getCell(row.getFirstCellNum());
            Cell secondCell = row.getCell(row.getFirstCellNum() + 1);

            if (firstCell.getCellType() == Cell.CELL_TYPE_NUMERIC && secondCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                try {
                    writer.println(firstCell.getNumericCellValue() + "," + (int)secondCell.getNumericCellValue());
                } catch (Exception e) {
                    System.err.println("Cannot convert data in row: " + row.getRowNum());
                }
            }

        }
        writer.close();
        
     
        } catch (Exception ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void createExcelFile(List<Double> xes){
    try {
            String filename = "single.xlsx" ;
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("FirstSheet");  
            int rownum=0;
          for (Iterator<Double> iterator = xes.iterator(); iterator.hasNext();) {
            
            Double next = iterator.next();
            XSSFRow row = sheet.createRow(rownum);
            row.createCell(0).setCellValue(next);
            row.createCell(1).setCellValue(0.0);
             rownum++;
        }
 
            
           

            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
           
        System.out.println("Stworzono");
        } catch ( Exception ex ) {
            System.out.println(ex);
        } 
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogisticTestButton;
    private javax.swing.JFrame LogisticTestFrame;
    private javax.swing.JFileChooser TestLogisticFileChooser;
    private javax.swing.JTextField XlogisticTestVariableTextField;
    private javax.swing.JFrame chartFrame;
    private javax.swing.JButton classifyForfileButton;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton lineRegressionStart;
    private javax.swing.JToggleButton logisticRegressionStart;
    private javax.swing.JTextArea logisticTestTextArea;
    private javax.swing.JMenuItem menuItemSelectFile;
    private javax.swing.JTextArea result;
    private javax.swing.JFrame selectFileWindow;
    private javax.swing.JButton singleTestButton;
    private javax.swing.JFileChooser testFileChooser;
    private javax.swing.JFrame testFileChooserFrame;
    private javax.swing.JFrame testFileChooserLogisticFrame;
    private javax.swing.JFrame testFrame;
    private javax.swing.JButton testFromFileButton;
    private javax.swing.JButton testFromFileLinearButton;
    private javax.swing.JTextArea testLogisticTestArea;
    private javax.swing.JButton testSingleLogisticButtin;
    private javax.swing.JTextArea testTextArea;
    private javax.swing.JButton testingButton;
    private javax.swing.JLabel xTestLabel;
    private javax.swing.JTextField xTestValue;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package regression;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import regression.data.FileGenerator;
import regression.gui.MainWindow;
import regression.data.GenerateData;
import regression.logisticRegression.Instance;
import regression.logisticRegression.LogisticRegression;

/**
 *
 * @author Cyga
 */
public class Regression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        MainWindow window = new MainWindow();
        window.setVisible(true);
FileGenerator f = new FileGenerator();
f.generate();
            }
    
}

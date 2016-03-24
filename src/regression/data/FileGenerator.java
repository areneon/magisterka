/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regression.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Arkadiusz.Ptak
 */
public class FileGenerator {

    public void generate() throws IOException {
        File f = new File(System.getProperty("user.dir") + "plik.txt");
        FileWriter r = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(r);

        for (int i = 0; i < 1601; i++) {
            Double x = Math.random();
            bw.append(x.toString() + "\n");

           // System.out.println(Math.random());
        }
        bw.close();
        r.close();
    }
}

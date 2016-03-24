/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package regression.logisticRegression;

/**
 *
 * @author Cyga
 */
public class Instance {
  public Double label;
    public Double[] x;

    public Instance(Double label, Double[] x) {
        this.label = label;
        this.x = x;
    }

    public Double getLabel() {
        return label;
    }

    public Double[] getX() {
        return x;
    }  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package regression;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cyga
 */
public class Function {
    List<Double> factors = new ArrayList<>();
    Double freeFactor;

    public List<Double> getFactor() {
        return factors;
    }

    public void setFactor(List<Double> factor) {
        this.factors = factors;
    }

    public Double getFreeFactor() {
        return freeFactor;
    }

    public void setFreeFactor(Double freeFactor) {
        this.freeFactor = freeFactor;
    }
    
    public void addFactor(Double factor){
    factors.add(factor);
    }
}

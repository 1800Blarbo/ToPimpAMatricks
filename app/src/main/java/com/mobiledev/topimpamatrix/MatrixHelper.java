package com.mobiledev.topimpamatrix;

import org.jblas.DoubleMatrix;

/**
 * Created by larspmayrand on 4/11/16.
 */
public class MatrixHelper {

    public static Detail[] getDetails(DoubleMatrix matrix) {
        Detail[] details = new Detail[1];

        Detail eigenvalues = new Detail("eigenvalues", "2, 3");
        details[0] = eigenvalues;

        return details;
    }

}

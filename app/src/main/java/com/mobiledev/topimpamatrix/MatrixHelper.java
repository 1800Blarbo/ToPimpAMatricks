package com.mobiledev.topimpamatrix;

import org.jblas.DoubleMatrix;

/**
 * Created by larspmayrand on 4/11/16.
 */
public class MatrixHelper {

    public static Detail[] getDetails(DoubleMatrix matrix) {
        Detail[] details = new Detail[5];

        Detail eigenvalues = new Detail("eigenvalues", "5.37228, -0.37228");
        details[0] = eigenvalues;

        Detail determinant = new Detail("determinant", "-2");
        details[1] = determinant;

        Detail trace = new Detail("trace", "5");
        details[2] = trace;

        Detail characteristicPolynomial = new Detail("characteristic polynomial", "x^2 - 5x - 2");
        details[3] = characteristicPolynomial;

        Detail eigenvectors = new Detail("eigenvectors", "poop");
        details[4] = eigenvectors;

        return details;
    }

}

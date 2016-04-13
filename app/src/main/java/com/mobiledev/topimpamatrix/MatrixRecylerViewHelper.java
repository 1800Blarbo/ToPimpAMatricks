package com.mobiledev.topimpamatrix;

import org.jblas.ComplexDouble;
import org.jblas.ComplexDoubleMatrix;
import org.jblas.Eigen;

/**
 * Created by larspmayrand on 4/11/16.
 */
public class MatrixRecylerViewHelper {

    public static Detail[] getDetails(ComplexDoubleMatrix matrix) {
        Detail[] details = new Detail[9];

        Detail eigenvalues = new Detail("Eigenvalues", "1, 2"/*findStringEigenvalues(matrix)*/);
        details[0] = eigenvalues;

        Detail eigenvectors = new Detail("Eigenvectors", "v_1 = <0.457427, 1>, v_2 = <-1.45743, 1>"/*findStringEigenvectors*/);
        details[1] = eigenvectors;

        details[2] = new Detail("Determinant", "-2");

        details[3] = new Detail("Trace", MatrixFormatter.complexDoubleToString(trace(matrix)));

        Detail characteristicPolynomial = new Detail("Characteristic polynomial", "x^2 - 5x - 2");
        details[4] = characteristicPolynomial;

        double[][] reducedArray = new double[][] {{1, 0},{0, 1}};
        ComplexDoubleMatrix rref = new ComplexDoubleMatrix(reducedArray);
        Detail rowReducedEchlonForm = new Detail("Row reduced echlon form", MatrixFormatter.matrixToString(rref));
        details[5] = rowReducedEchlonForm;

        Detail solutions = new Detail("Solutions", "x_1 = 0, x_2 = 0");
        details[6] = solutions;

        double[][] inverseArray = new double[][] {{-2, 1},{1.5, -0.5}};
        ComplexDoubleMatrix inverseMatrix = new ComplexDoubleMatrix(inverseArray);
        Detail inverse = new Detail("Inverse", MatrixFormatter.matrixToString(inverseMatrix));
        details[7] = inverse;

        double[][] orthogonalArray = new double[][] {{0.32, 0.95},{0.95, -0.32}};
        ComplexDoubleMatrix orthogonalized = new ComplexDoubleMatrix(orthogonalArray);
        Detail orthogonal = new Detail("Orthogonalized matrix", MatrixFormatter.matrixToString(orthogonalized));
        details[8] = orthogonal;

        //
        // details[9] = new Detail("Complex Conjugate", MatrixFormatter.matrixToString(matrix.conj()));

        return details;
    }

    public static boolean isReal(ComplexDoubleMatrix matrix) {
        return new ComplexDoubleMatrix(matrix.real()).equals(matrix);
    }

    /** Eigen.eigenvectors(matrix) returns an array of ComplexDoubleMatrix objects containing the
     * eigenvectors stored as the columns of the first matrix, and the eigenvalues as the
     * diagonal elements of the second matrix. */
    public static ComplexDouble[] findEigenvalues(ComplexDoubleMatrix matrix) {
        if (MatrixRecylerViewHelper.isReal(matrix)) {
            return Eigen.eigenvalues(matrix.real()).toArray();
        }
        return new ComplexDouble[]{new ComplexDouble(0)};
//        ComplexDoubleMatrix[] eigenMatrix = Eigen.eigenvectors(matrix);
//        double[] eigenvalues = new double[eigenMatrix[1].rows];
//        for (int r = 0; r < eigenMatrix[1].rows; r++) {
//            for (int c = 0; c < eigenMatrix[1].columns; c++) {
//                if (r == c) eigenvalues[r] = (eigenMatrix[1].get(r, c).real());
//            }
//        }
//        return eigenvalues;
    }

    public static String findStringEigenvalues(ComplexDoubleMatrix matrix) {
        ComplexDouble[] complexEigenvalues = findEigenvalues(matrix);
        if (complexEigenvalues.equals(0)) return "upgrade to To Pimper A Matrix"; // write/find complex eigenvalues
        String stringEigenvalues = "";
        for (int i = 0; i < complexEigenvalues.length; i++) {
            if (i < complexEigenvalues.length - 1) {
                stringEigenvalues += complexEigenvalues[i].toString();
            } else {
                stringEigenvalues += complexEigenvalues[i].toString() + ", ";
            }
        }
        return stringEigenvalues;
    }

    public static ComplexDoubleMatrix[] findEigenvectors(ComplexDoubleMatrix matrix) {
        if (MatrixRecylerViewHelper.isReal(matrix)) {
            return Eigen.eigenvectors(matrix.real());
        }
        return new ComplexDoubleMatrix[]{new ComplexDoubleMatrix()}; // write/find complex eigenvectors
    }
    // find string eigenvectors

    public static ComplexDouble trace(ComplexDoubleMatrix matrix) {
        ComplexDouble trace = new ComplexDouble(0);
        for (int r = 0; r < matrix.rows; r++) {
            for (int c = 0; c < matrix.columns; c++) {
                if (r == c) {
                    trace = trace.addi(matrix.get(r, c), trace);
                }
            }
        }
        return trace;
    }


}

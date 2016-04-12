package com.mobiledev.topimpamatrix;

import org.jblas.ComplexDoubleMatrix;
import org.jblas.DoubleMatrix;

/**
 * Created by larspmayrand on 4/11/16.
 */
public class MatrixFormatter {

    public static String makeLatexString(int size, String string) {
        return  "<html><head>"
                + "<link rel='stylesheet' href='file:///android_asset/jqmath-0.4.3.css'>"
                + "<script src='file:///android_asset/jquery-1.4.3.min.js'></script>"
                + "<script src='file:///android_asset/jqmath-etc-0.4.3.min.js'></script>"
                + "</head><font size = " + size + "><body>"
                + "$$" + string + "$$</body></font></html>";
    }

    public static String makeLatexString(String string) { // defaults to size = ???
        return  "<html><head>"
                + "<link rel='stylesheet' href='file:///android_asset/jqmath-0.4.3.css'>"
                + "<script src='file:///android_asset/jquery-1.4.3.min.js'></script>"
                + "<script src='file:///android_asset/jqmath-etc-0.4.3.min.js'></script>"
                + "</head></font><body>"
                + "$$" + string + "$$</body></html>";
    }

    public static String matrixToString(DoubleMatrix matrix) {
        String string = "(\\table ";
        for (int r = 0; r < matrix.rows; r++) {
            for (int c = 0; c < matrix.columns; c++) {
                if (matrix.get(r, c) == (int) matrix.get(r, c)) {
                    string += (int) matrix.get(r, c);
                } else {
                    string += matrix.get(r, c);
                }
                if (c < matrix.columns - 1) {
                    string += ", ";
                }
            }
            if (r < matrix.rows - 1) {
                string += "; ";
            }
        }
        return makeLatexString(string+")");
    }

    public static String complexMatrixToString(ComplexDoubleMatrix matrix) {
        String string = "(\\table ";
        for (int r = 0; r < matrix.rows; r++) {
            for (int c = 0; c < matrix.columns; c++) {
                string += matrix.get(r, c);
                if (c < matrix.columns - 1) {
                    string += ", ";
                }
            }
            if (r < matrix.rows - 1) {
                string += "; ";
            }
        }
        return string+")";
    }

}

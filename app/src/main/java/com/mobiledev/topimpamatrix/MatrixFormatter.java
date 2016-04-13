package com.mobiledev.topimpamatrix;

import org.jblas.ComplexDouble;
import org.jblas.ComplexDoubleMatrix;

/**
 * Created by larspmayrand on 4/11/16.
 */
public class MatrixFormatter {

    /** For HTML string size, not LaTeX size (unfortunately). */
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

    public static String matrixToString(ComplexDoubleMatrix matrix) {
        String string = "(\\table ";
        for (int r = 0; r < matrix.rows; r++) {
            for (int c = 0; c < matrix.columns; c++) {
                if (matrix.get(r, c).isReal()) {
                    if (matrix.get(r, c).real() == (int) matrix.get(r, c).real()) {
                        string += (int) matrix.get(r, c).real();
                    } else {
                        string += matrix.get(r, c).real();
                    }
                } else {
                    string += matrix.get(r, c).toString();
                }
                if (c < matrix.columns - 1) {
                    string += ", ";
                }
            }
            if (r < matrix.rows - 1) {
                string += "; ";
            }
        }
        return string + ")";
    }

    public static String matrixToLatex(ComplexDoubleMatrix matrix) {
        String string = "(\\table ";
        for (int r = 0; r < matrix.rows; r++) {
            for (int c = 0; c < matrix.columns; c++) {
                if (matrix.get(r, c).isReal()) {
                    if (matrix.get(r, c).real() == (int) matrix.get(r, c).real()) {
                        string += (int) matrix.get(r, c).real();
                    } else {
                        string += matrix.get(r, c).real();
                    }
                } else {
                    string += matrix.get(r, c).toString();
                }
                if (c < matrix.columns - 1) {
                    string += ", ";
                }
            }
            if (r < matrix.rows - 1) {
                string += "; ";
            }
        }
        return makeLatexString(6, string + ")");
    }

    public static String complexDoubleToString(ComplexDouble complexDouble) { // cuz jblas' SUCKS
        String complexDoubleString = "";
        if (complexDouble.isReal()) {
            double newComplexDouble = complexDouble.real();
            if (newComplexDouble != (int) newComplexDouble) {
                return newComplexDouble + "";
            } else {
                return (int) newComplexDouble + "";
            }
        }
        return complexDouble + "";
    }

}

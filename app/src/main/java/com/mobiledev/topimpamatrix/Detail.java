package com.mobiledev.topimpamatrix;

/**
 * Created by larspmayrand on 4/11/16.
 */
public class Detail {

    private String latex;
    private String description;

    public Detail(String description, String latex) {
        this.description = description;
        this.latex = latex;
    }

    public String getLatex() {
        return latex;
    }

    public void setLatex(String latex) {
        this.latex = latex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

package org.future.foodflix.Network;

public class JsonNutrientsResponse {
    private double ENERC_KCAL;
    private double PROCNT;
    private double FAT;
    private double CHOCDF;
    private double FIBTG;

    public double getENERC_KCAL() {
        return ENERC_KCAL;
    }

    public void setENERC_KCAL(double ENERC_KCAL) {
        this.ENERC_KCAL = ENERC_KCAL;
    }

    public double getPROCNT() {
        return PROCNT;
    }

    public void setPROCNT(double PROCNT) {
        this.PROCNT = PROCNT;
    }

    public double getFAT() {
        return FAT;
    }

    public void setFAT(double FAT) {
        this.FAT = FAT;
    }

    public double getCHOCDF() {
        return CHOCDF;
    }

    public void setCHOCDF(double CHOCDF) {
        this.CHOCDF = CHOCDF;
    }

    public double getFIBTG() {
        return FIBTG;
    }

    public void setFIBTG(double FIBTG) {
        this.FIBTG = FIBTG;
    }

    @Override
    public String toString() {
        return "JsonNutrientsResponse{" +
                "ENERC_KCAL=" + ENERC_KCAL +
                ", PROCNT=" + PROCNT +
                ", FAT=" + FAT +
                ", CHOCDF=" + CHOCDF +
                ", FIBTG=" + FIBTG +
                '}';
    }
}

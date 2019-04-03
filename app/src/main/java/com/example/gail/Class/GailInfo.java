package com.example.gail.Class;

public class GailInfo {

    private String thana, mouja, rs, sa;

    public GailInfo(){

    }

    public GailInfo(String thana, String mouja, String rs, String sa) {
        this.thana = thana;
        this.mouja = mouja;
        this.rs = rs;
        this.sa = sa;
    }

    public String getThana() {
        return thana;
    }

    public void setThana(String thana) {
        this.thana = thana;
    }

    public String getMouja() {
        return mouja;
    }

    public void setMouja(String mouja) {
        this.mouja = mouja;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getSa() {
        return sa;
    }

    public void setSa(String sa) {
        this.sa = sa;
    }
}

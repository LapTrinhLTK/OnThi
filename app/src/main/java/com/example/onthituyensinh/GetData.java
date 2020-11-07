package com.example.onthituyensinh;

public class GetData
{
    public String cauhoi;
    public String chona, chonb, chonc, chond, dapan;

    public GetData(String cauhoi, String chona, String chonb, String chonc, String chond, String dapan)
    {
        this.cauhoi = cauhoi;
        this.chona = chona;
        this.chonb = chonb;
        this.chonc = chonc;
        this.chond = chond;
        this.dapan = dapan;
    }

    public GetData(){}

    public String getCauhoi() {return cauhoi; }

    public void setCauhoi(String cauhoi) { this.cauhoi = cauhoi; }

    public String getChona() {return chona; }

    public void setChona(String chona) { this.chona = chona; }

    public String getChonb() {return chonb; }

    public void setChonb(String chonb) { this.chonb = chonb; }

    public String getChonc() {return chonc; }

    public void setChonc(String chonc) { this.chonc = chonc; }

    public String getChond() {return chond; }

    public void setChond(String chond) { this.chond = chond; }

    public String getDapan() {return dapan; }

    public void setDapan(String dapan) { this.dapan = dapan; }


}

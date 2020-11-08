package com.example.onthituyensinh;

public class GetData
{
    public String cauhoi;
    public String optiona, optionb, optionc, optiond, dapan;

    public GetData(String cauhoi, String optiona, String optionb, String optionc, String optiond, String dapan)
    {
        this.cauhoi = cauhoi;
        this.optiona = optiona;
        this.optionb = optionb;
        this.optionc = optionc;
        this.optiond = optiond;
        this.dapan = dapan;
    }

    public GetData(){}

    public String getCauhoi() {return cauhoi; }

    public void setCauhoi(String cauhoi) { this.cauhoi = cauhoi; }

    public String getOptiona() {return optiona; }

    public void setOptiona(String optiona) { this.optiona = optiona; }

    public String getOptionb() {return optionb; }

    public void setOptionb(String optionb) { this.optionb = optionb; }

    public String getOptionc() {return optionc; }

    public void setOptionc(String optionc) { this.optionc = optionc; }

    public String getOptiond() {return optiond; }

    public void setOptiond(String optiond) { this.optiond = optiond; }

    public String getDapan() {return dapan; }

    public void setDapan(String dapan) { this.dapan = dapan; }


}

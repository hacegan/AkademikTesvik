/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcheck;

import java.io.InputStream;

/**
 *
 * @author samet
 */
public class arastirmalar {

    
                                                            
      private String arastirmaadi;
      private String arastirmabaslik;
      private String arastirmaicerik;
      private String arastirmayer;
      private String arastirmaulke;
      private int arastirmakisisayi;
      private String     arastirmabastar;
      private String arastirmabittar;
      private InputStream arastirmakanit;

    public arastirmalar() {
    }

    public arastirmalar(String arastirmaadi, String arastirmabaslik, String arastirmaicerik, String arastirmayer, String arastirmaulke, int arastirmakisisayi, String arastirmabastar, String arastirmabittar,InputStream arastirmakanit) {
        this.arastirmaadi = arastirmaadi;
        this.arastirmabaslik = arastirmabaslik;
        this.arastirmaicerik = arastirmaicerik;
        this.arastirmayer = arastirmayer;
        this.arastirmaulke = arastirmaulke;
        this.arastirmakisisayi = arastirmakisisayi;
        this.arastirmabastar = arastirmabastar;
        this.arastirmabittar = arastirmabittar;
        this.arastirmakanit=arastirmakanit;
    }

    public String getArastirmaadi() {
        return arastirmaadi;
    }

    public void setArastirmaadi(String arastirmaadi) {
        this.arastirmaadi = arastirmaadi;
    }

    public String getArastirmabaslik() {
        return arastirmabaslik;
    }

    public void setArastirmabaslik(String arastirmabaslik) {
        this.arastirmabaslik = arastirmabaslik;
    }

    public String getArastirmaicerik() {
        return arastirmaicerik;
    }

    public void setArastirmaicerik(String arastirmaicerik) {
        this.arastirmaicerik = arastirmaicerik;
    }

    public String getArastirmayer() {
        return arastirmayer;
    }

    public void setArastirmayer(String arastirmayer) {
        this.arastirmayer = arastirmayer;
    }

    public String getArastirmaulke() {
        return arastirmaulke;
    }

    public void setArastirmaulke(String arastirmaulke) {
        this.arastirmaulke = arastirmaulke;
    }

    public int getArastirmakisisayi() {
        return arastirmakisisayi;
    }

    public void setArastirmakisisayi(int arastirmakisisayi) {
        this.arastirmakisisayi = arastirmakisisayi;
    }

    public String getArastirmabastar() {
        return arastirmabastar;
    }

    public void setArastirmabastar(String arastirmabastar) {
        this.arastirmabastar = arastirmabastar;
    }

    public String getArastirmabittar() {
        return arastirmabittar;
    }

    public void setArastirmabittar(String arastirmabittar) {
        this.arastirmabittar = arastirmabittar;
    }

    public InputStream getArastirmakanit() {
        return arastirmakanit;
    }

    public void setArastirmakanit(InputStream arastirmakanit) {
        this.arastirmakanit = arastirmakanit;
    }

    
      
                                                            
    
    
    
    
}

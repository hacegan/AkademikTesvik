/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcheck;

/**
 *
 * @author samet
 */
public class kullanicilar {
    private String kulad;
    private String kulsifre;
    private String adsoyad;
    private String bolum;
    private String birim;
    private String unvan;
    private int puan;
    private int kid;

    public kullanicilar(String kulad, String kulsifre, String adsoyad, String bolum, String birim, String unvan, int puan,int kid) {
        this.kulad = kulad;
        this.kulsifre = kulsifre;
        this.adsoyad = adsoyad;
        this.bolum = bolum;
        this.birim = birim;
        this.unvan = unvan;
        this.puan = puan;
        this.kid=kid;
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    
    
    public String getKulad() {
        return kulad;
    }

    public void setKulad(String kulad) {
        this.kulad = kulad;
    }

    public String getKulsifre() {
        return kulsifre;
    }

    public void setKulsifre(String kulsifre) {
        this.kulsifre = kulsifre;
    }

    public String getAdsoyad() {
        return adsoyad;
    }

    public void setAdsoyad(String adsoyad) {
        this.adsoyad = adsoyad;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }
    
    
    
    
    
    
}

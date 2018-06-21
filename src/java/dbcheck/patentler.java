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
public class patentler {
    private String patbassahip;
    private String patbulsahip;
    private String patkategori;
    private String patdostip;
    private String patyil;
    private String patbulozet;

    public patentler() {
    }

    public patentler(String patbassahip, String patbulsahip, String patkategori, String patdostip, String patyil, String patbulozet) {
        this.patbassahip = patbassahip;
        this.patbulsahip = patbulsahip;
        this.patkategori = patkategori;
        this.patdostip = patdostip;
        this.patyil = patyil;
        this.patbulozet = patbulozet;
    }

    public String getPatbassahip() {
        return patbassahip;
    }

    public void setPatbassahip(String patbassahip) {
        this.patbassahip = patbassahip;
    }

    public String getPatbulsahip() {
        return patbulsahip;
    }

    public void setPatbulsahip(String patbulsahip) {
        this.patbulsahip = patbulsahip;
    }

    public String getPatkategori() {
        return patkategori;
    }

    public void setPatkategori(String patkategori) {
        this.patkategori = patkategori;
    }

    public String getPatdostip() {
        return patdostip;
    }

    public void setPatdostip(String patdostip) {
        this.patdostip = patdostip;
    }

    public String getPatyil() {
        return patyil;
    }

    public void setPatyil(String patyil) {
        this.patyil = patyil;
    }

    public String getPatbulozet() {
        return patbulozet;
    }

    public void setPatbulozet(String patbulozet) {
        this.patbulozet = patbulozet;
    }
    
    
    
    
    
    
}

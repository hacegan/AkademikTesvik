/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcheck;

import java.io.InputStream;
import java.sql.Blob;
import javax.websocket.Decoder.BinaryStream;

/**
 *
 * @author samet
 */
public class projeler {
    private String projead;
    private String projekonu;
    private String projedurum;
    private String projegorev;
    private String projebastar;
    private String projebittar;
    private InputStream  projekanit;

    public projeler() {
    }

    public projeler(String projead, String projekonu, String projedurum, String projegorev, String projebastar, String projebittar,InputStream  projekanit) {
        this.projead = projead;
        this.projekonu = projekonu;
        this.projedurum = projedurum;
        this.projegorev = projegorev;
        this.projebastar = projebastar;
        this.projebittar = projebittar;
        this.projekanit=projekanit;
    }

    public String getProjead() {
        return projead;
    }

    public void setProjead(String projead) {
        this.projead = projead;
    }

    public String getProjekonu() {
        return projekonu;
    }

    public void setProjekonu(String projekonu) {
        this.projekonu = projekonu;
    }

    public String getProjedurum() {
        return projedurum;
    }

    public void setProjedurum(String projedurum) {
        this.projedurum = projedurum;
    }

    public String getProjegorev() {
        return projegorev;
    }

    public void setProjegorev(String projegorev) {
        this.projegorev = projegorev;
    }

    public String getProjebastar() {
        return projebastar;
    }

    public void setProjebastar(String projebastar) {
        this.projebastar = projebastar;
    }

    public String getProjebittar() {
        return projebittar;
    }

    public void setProjebittar(String projebittar) {
        this.projebittar = projebittar;
    }

    public InputStream  getProjekanit() {
        return projekanit;
    }

    public void setProjekanit(InputStream  projekanit) {
        this.projekanit = projekanit;
    }
    
            
            
    
    
    
    
}

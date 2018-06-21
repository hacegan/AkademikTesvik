/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcheck;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import static org.apache.jasper.runtime.JspRuntimeLibrary.include;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
/**
 *
 * @author samet
 */

@ManagedBean(name = "kntrl")
@RequestScoped
public class kontrolet {
    private int kisiid;
    private int arasid;
    private int id;
    private String adsoyad;
    private String birim;
    private String bolum;
    private String unvan;
    private int puan;
    public String kulad;
    private String kulsifre;
    private String jsfurl;
    private String baskaurl;
    private UploadedFile file;
    private String projeekleurl;
    private SelectItem projetür;
    private  List<SelectItem> names = new ArrayList<SelectItem>();   
    private String ulusalitem;
    private String uluslaritem;
    private String projedurum;
    private String projegorev;
    private String projead;
    private String projekonu;
    private String projebastar;
    private String projebittar;
    private int projeid;
    private double kisipuan;
    private String adminkullaniciyonetmeurl;
   private List<kullanicilar> kullaniciliste=new ArrayList<>();
   private List<kullanicilar> kullanici=new ArrayList<>();
   private String arasad;
   private String arasbaslik;
   private String arasicerik;
   private String arasyer;
   private String arasulke;
   private int araskisisayi;
   private String arasbasliktur;
   private String arasbastar;
   private String arasbittar;
   private String arastirmaekleurl;
   private int patentid;
   private  String patbassahip;
   private String patbulsahip;
   private String patkategori;
   private String patdostip;
   private String patyil;
   private String patbulozet;
   private String patentekleurl;
   private int odulid;
   private String odulkurulke;
   private String odulkurtur;
   private String odulkurum;
   private String odultur;
   private String odulad;
   private String odulyil;
   private int odulkisisayi;
   private String odulaciklama;
   private String odulekleurl;
   private int tasarimid;
   private String tasarimsahip;
   private String tasarimtur;
   private String tasarimad;
   private String tasarimaciklama;
   private String tasarimbastar;
   private String tasarimbittar;
   private String tasarimekleurl;
   private String tebligkapsam;
   private String tebbiltur;
   private String tebyaydur;
   private String tebadi;
   private int tebyazsayi;
   private String tebyazarlar;
   private String tebetkadi;
   private String tebbastar;
   private String tebbittar;
   private String tebbastur;
   private String tebbasimtar;
   private String tebdil;
   private String tebekleurl;
   private int tebligid;
   private int sergiid;
   private String sergiad;
   private String sergitar;
   private String sergikapsam;
   private String sergitip;
   private int sergikisisayi;
   private int sergisure;
   private String sergiekleurl;
   private int yayinid;
   private String yayinad;
   private String yayintur;
   private String yayinkapsam;
   private String yayintarih;
   private String yayinekleurl;
   private List<projeler> projeliste=new ArrayList<projeler>();
   private String gecmisurl;
   private boolean projetabloaktif=false;
   private boolean arastirmatabloaktif=false;
   private List<arastirmalar> arastirmaliste=new ArrayList<arastirmalar>();
   private ByteArrayInputStream projekanit;
   private boolean bildiritabloaktif=false;
   private List<bildiriler> bildiriliste=new ArrayList<bildiriler>();
   private ByteArrayInputStream bildirikanit;
   private ByteArrayInputStream odulkanit;
   private boolean odultabloaktif=false;
   private List<Oduller> odulliste=new ArrayList<Oduller>();
  private List<patentler> patentliste=new ArrayList<patentler>();
  private boolean patenttabloaktif=false;
  private boolean tasarimtabloaktif=false;
  private List<tasarimlar> tasarimliste=new ArrayList<tasarimlar>();
  private ByteArrayInputStream tasarimkanit;
  private ByteArrayInputStream sergikanit;
  private boolean sergitabloaktif=false;
  private List<sergiler> sergiliste=new ArrayList<sergiler>();
  private String adminyenikulekleurl;
  private String arastirmakapsam;
  private ByteArrayInputStream gelenveri;
      private InputStream veri;
      OutputStream outputStream = null;
private String degistirkulad;
private String degistirkulsifre;
private String degistirkuladsoyad;
private String degistirkulbolum;
private String degistirkulbirim;
private String degistirkulunvan;

    public ByteArrayInputStream getGelenveri() {
        return gelenveri;
    }

    public void setGelenveri(ByteArrayInputStream gelenveri) {
        this.gelenveri = gelenveri;
    }

    public InputStream getVeri() {
        return veri;
    }

    public void setVeri(InputStream veri) {
        this.veri = veri;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public String getDegistirkulad() {
        return degistirkulad;
    }

    public void setDegistirkulad(String degistirkulad) {
        this.degistirkulad = degistirkulad;
    }

    public String getDegistirkulsifre() {
        return degistirkulsifre;
    }

    public void setDegistirkulsifre(String degistirkulsifre) {
        this.degistirkulsifre = degistirkulsifre;
    }

    public String getDegistirkuladsoyad() {
        return degistirkuladsoyad;
    }

    public void setDegistirkuladsoyad(String degistirkuladsoyad) {
        this.degistirkuladsoyad = degistirkuladsoyad;
    }

    public String getDegistirkulbolum() {
        return degistirkulbolum;
    }

    public void setDegistirkulbolum(String degistirkulbolum) {
        this.degistirkulbolum = degistirkulbolum;
    }

    public String getDegistirkulbirim() {
        return degistirkulbirim;
    }

    public void setDegistirkulbirim(String degistirkulbirim) {
        this.degistirkulbirim = degistirkulbirim;
    }

    public String getDegistirkulunvan() {
        return degistirkulunvan;
    }

    public void setDegistirkulunvan(String degistirkulunvan) {
        this.degistirkulunvan = degistirkulunvan;
    }
      




      public void degistiradata(String degistirgelenad){
          this.kulad=degistirgelenad;
      }
      public void degistirsifreata(String gelensifre){
          this.kulsifre=gelensifre;
      }
      public void degistiradsoyadata(String gelenadsoyad){
          this.adsoyad=gelenadsoyad;
      }
      public void degistirbolumata(String gelenbolum){
          this.bolum=gelenbolum;
      }
      public void degistirbirimata(String gelenbirim){
          this.birim=gelenbirim;
      }
      public void degistirunvanata(String gelenunvan){
          this.unvan=gelenunvan;
      }
      
    public String getArastirmakapsam() {
        return arastirmakapsam;
    }

    public void setArastirmakapsam(String arastirmakapsam) {
        this.arastirmakapsam = arastirmakapsam;
    }
  
  

    public String getAdminyenikulekleurl() {
        return adminyenikulekleurl;
    }

    public void setAdminyenikulekleurl(String adminyenikulekleurl) {
        this.adminyenikulekleurl = adminyenikulekleurl;
    }

  
  
  
    public ByteArrayInputStream getSergikanit() {
        return sergikanit;
    }

    public void setSergikanit(ByteArrayInputStream sergikanit) {
        this.sergikanit = sergikanit;
    }

    public boolean isSergitabloaktif() {
        return sergitabloaktif;
    }

    public void setSergitabloaktif(boolean sergitabloaktif) {
        this.sergitabloaktif = sergitabloaktif;
    }

    public List<sergiler> getSergiliste() {
        return sergiliste;
    }

    public void setSergiliste(List<sergiler> sergiliste) {
        this.sergiliste = sergiliste;
    }

  
  public void sergirendered(){
      this.sergitabloaktif=true;
  }
  
  public void tasarimrendered(){
      this.tasarimtabloaktif=true;
  }
  
  
    public boolean isTasarimtabloaktif() {
        return tasarimtabloaktif;
    }

    public void setTasarimtabloaktif(boolean tasarimtabloaktif) {
        this.tasarimtabloaktif = tasarimtabloaktif;
    }

    public List<tasarimlar> getTasarimliste() {
        return tasarimliste;
    }

    public void setTasarimliste(List<tasarimlar> tasarimliste) {
        this.tasarimliste = tasarimliste;
    }

    public ByteArrayInputStream getTasarimkanit() {
        return tasarimkanit;
    }

    public void setTasarimkanit(ByteArrayInputStream tasarimkanit) {
        this.tasarimkanit = tasarimkanit;
    }
  
  
  
  
  
  
    public List<patentler> getPatentliste() {
        return patentliste;
    }

    public void setPatentliste(List<patentler> patentliste) {
        this.patentliste = patentliste;
    }

    public boolean isPatenttabloaktif() {
        return patenttabloaktif;
    }

    public void setPatenttabloaktif(boolean patenttabloaktif) {
        this.patenttabloaktif = patenttabloaktif;
    }
  
  
  
  
  
  
  public void patentrendered(){
      this.patenttabloaktif=true;
  }
  
   public void odulrendered(){
       this.odultabloaktif=true;
   }
   
   
    public List<bildiriler> getBildiriliste() {
        return bildiriliste;
    }

    public void setBildiriliste(List<bildiriler> bildiriliste) {
        this.bildiriliste = bildiriliste;
    }

    public ByteArrayInputStream getBildirikanit() {
        return bildirikanit;
    }

    public void setBildirikanit(ByteArrayInputStream bildirikanit) {
        this.bildirikanit = bildirikanit;
    }

    public ByteArrayInputStream getOdulkanit() {
        return odulkanit;
    }

    public void setOdulkanit(ByteArrayInputStream odulkanit) {
        this.odulkanit = odulkanit;
    }

    public boolean isOdultabloaktif() {
        return odultabloaktif;
    }

    public void setOdultabloaktif(boolean odultabloaktif) {
        this.odultabloaktif = odultabloaktif;
    }

    public List<Oduller> getOdulliste() {
        return odulliste;
    }

    public void setOdulliste(List<Oduller> odulliste) {
        this.odulliste = odulliste;
    }

   
   
   
 
   
   public void bildirirendered(){
       this.bildiritabloaktif=true;
   }
   
    public boolean isBildiritabloaktif() {
        return bildiritabloaktif;
    }

    public void setBildiritabloaktif(boolean bildiritabloaktif) {
        this.bildiritabloaktif = bildiritabloaktif;
    }
   

   
   
   
    public List<arastirmalar> getArastirmaliste() {
        return arastirmaliste;  
    }

    public void setArastirmaliste(List<arastirmalar> arastirmaliste) {
        this.arastirmaliste = arastirmaliste;
    }

    public ByteArrayInputStream getProjekanit() {
        return projekanit;
    }

    public void setProjekanit(ByteArrayInputStream projekanit) {
        this.projekanit = projekanit;
    }
   
   
   

    public boolean isArastirmatabloaktif() {
        return arastirmatabloaktif;
    }

    public void setArastirmatabloaktif(boolean arastirmatabloaktif) {
        this.arastirmatabloaktif = arastirmatabloaktif;
    }
   
    
    public void arastirmarendered(){
        this.arastirmatabloaktif=true;
    }
  
   public void projerendered(){
       this.projetabloaktif=true;
   }
   public void projederendered(){
       this.projetabloaktif=false;    
   }
   
   public List<sergiler> sergilistedondur(){
       sergiliste.clear();
            try{
            Class.forName("com.mysql.jdbc.Driver");
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8","root","");
              Statement stmt=connection.createStatement();
             ResultSet rs=stmt.executeQuery("SELECT * FROM sergi");
        while(rs.next()){
                   // if(arastirmaliste.indexOf(rs.getString("arasid"))==-1){ 
                        sergiliste.add(new sergiler(rs.getString("sergiad"),rs.getString("sergitar"),rs.getString("sergikapsam"),rs.getString("sergitip"),rs.getInt("sergikisisayi"),rs.getInt("sergisure")));
                  //  }
        }
          connection.close();
               stmt.close();
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
             return sergiliste;  

   }
   
   
   public List<tasarimlar> tasarimlistedondur(){
       tasarimliste.clear();
       try{
            Class.forName("com.mysql.jdbc.Driver");
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8","root","");
              Statement stmt=connection.createStatement();
             ResultSet rs=stmt.executeQuery("SELECT * FROM tasarim");
        while(rs.next()){
                   // if(arastirmaliste.indexOf(rs.getString("arasid"))==-1){ 
                        tasarimliste.add(new tasarimlar(rs.getString("tasarimsahip"),rs.getString("tasarimtur"),rs.getString("tasarimad"),rs.getString("tasarimaciklama"),rs.getString("tasarimbastar"),rs.getString("tasarimbittar")));
                  //  }
        }
          connection.close();
               stmt.close();
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
             return tasarimliste;
       
       
   }
   
   
   public List<patentler> patentListedondur(){
         patentliste.clear();
        try{
            Class.forName("com.mysql.jdbc.Driver");
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8","root","");
              Statement stmt=connection.createStatement();
             ResultSet rs=stmt.executeQuery("SELECT * FROM patent");
        while(rs.next()){
                   // if(arastirmaliste.indexOf(rs.getString("arasid"))==-1){ 
                        patentliste.add(new patentler(rs.getString("patbassahip"),rs.getString("patbulsahip"),rs.getString("patkategori"),rs.getString("patdostip"),rs.getString("patyil"),rs.getString("patbulozet")));
                  //  }
        }
          connection.close();
               stmt.close();
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
             return patentliste;
       
       
       
   }
   
   
   
   public List<Oduller> odullistedondur(){
       
         odulliste.clear();
        try{
            Class.forName("com.mysql.jdbc.Driver");
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8","root","");
              Statement stmt=connection.createStatement();
             ResultSet rs=stmt.executeQuery("SELECT * FROM odul");
        while(rs.next()){
                   // if(arastirmaliste.indexOf(rs.getString("arasid"))==-1){ 
                        odulliste.add(new Oduller(rs.getString("odulkurulke"),rs.getString("odulkurtur"),rs.getString("odulkurum"),rs.getString("odultur"),rs.getString("odulad"),rs.getString("odulyil"),rs.getInt("odulkisisayi"),rs.getString("odulaciklama")));
                  //  }
        }
          connection.close();
               stmt.close();
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
             return odulliste;
       
   }
   
   
   
   public List<bildiriler> bildirilistedondur(){
       bildiriliste.clear();
        try{
            Class.forName("com.mysql.jdbc.Driver");
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8","root","");
              Statement stmt=connection.createStatement();
             ResultSet rs=stmt.executeQuery("SELECT * FROM bildiri");
        while(rs.next()){
                   // if(arastirmaliste.indexOf(rs.getString("arasid"))==-1){ 
                        bildiriliste.add(new bildiriler(rs.getString("bildiriad"),rs.getString("bildiribastar"),rs.getString("bildiribittar"),rs.getString("tebkapsam"),rs.getString("tebbiltur"),rs.getString("tebyaydur"),rs.getInt("tebyazsayi"),rs.getString("tebyazarlar"),rs.getString("tebetkadi"),rs.getString("tebbasimtur"),rs.getString("tebbasimtarih"),rs.getString("tebdil")));
                  //  }
        }
          connection.close();
               stmt.close();
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
             return bildiriliste;
       
       
       
   }
   
   
   
   
   public List<arastirmalar> arastirmalistedondur(){
        arastirmaliste.clear();
        try{
            Class.forName("com.mysql.jdbc.Driver");
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8","root","");
              Statement stmt=connection.createStatement();
             ResultSet rs=stmt.executeQuery("SELECT * FROM arastirma");
        while(rs.next()){
                   // if(arastirmaliste.indexOf(rs.getString("arasid"))==-1){ 
                        arastirmaliste.add(new arastirmalar(rs.getString("arasad"),rs.getString("arasbaslik"),rs.getString("arasicerik"),rs.getString("arasyer"),rs.getString("arasulke"),rs.getInt("araskisisayi"),rs.getString("arasbastar"),rs.getString("arasbittar"),rs.getBinaryStream("resume")));
                  //  }
        }
          connection.close();
               stmt.close();
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
             return arastirmaliste;
       
       
       
   }
   
   
   
   
   
   public List<projeler> projelistedondur(){
       projeliste.clear();
       try{
            Class.forName("com.mysql.jdbc.Driver");
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8","root","");
             Statement stmt=connection.createStatement();
             ResultSet rs=stmt.executeQuery("SELECT * FROM proje");
               while(rs.next()){
                 if(projeliste.indexOf(rs.getString("projeid"))==-1){         
                   projeliste.add(new projeler(rs.getString("projead"),rs.getString("projekonu"),rs.getString("projedurum"),rs.getString("projegorev"),rs.getString("projebastar"),rs.getString("projebittar"),rs.getBinaryStream("resume")));   
                 }
                
             }
               connection.close();
               stmt.close();
       }
        catch(Exception e){
            e.printStackTrace();
        }
       return projeliste;
   }
   
   
    public List<kullanicilar> kullanicilistesidondur(){
kullaniciliste.clear();

        try{
            
             Class.forName("com.mysql.jdbc.Driver");
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8","root","");
             Statement stmt=connection.createStatement();
             ResultSet rs=stmt.executeQuery("SELECT * FROM kisiler");
             while(rs.next()){
                 if(kullaniciliste.indexOf(rs.getString("kulad"))==-1)
                 kullaniciliste.add(new kullanicilar(rs.getString("kulad"),rs.getString("kulsifre"),rs.getString("adsoyad"),rs.getString("bolum"),rs.getString("birim"),rs.getString("nvan"),rs.getInt("puan"),rs.getInt("kisiid")));
             }
             
        }
        catch(Exception e){
            e.printStackTrace();
        }
       
        return kullaniciliste;
 
    }

    public boolean isProjetabloaktif() {
        return projetabloaktif;
    }

    public void setProjetabloaktif(boolean projetabloaktif) {
        this.projetabloaktif = projetabloaktif;
    }

    
    
    
    public int getYayinid() {
        return yayinid;
    }

    public void setYayinid(int yayinid) {
        this.yayinid = yayinid;
    }

    public String getYayinad() {
        return yayinad;
    }

    public void setYayinad(String yayinad) {
        this.yayinad = yayinad;
    }

    public String getYayintur() {
        return yayintur;
    }

    public void setYayintur(String yayintur) {
        this.yayintur = yayintur;
    }

    public String getYayinkapsam() {
        return yayinkapsam;
    }

    public void setYayinkapsam(String yayinkapsam) {
        this.yayinkapsam = yayinkapsam;
    }

    public String getYayintarih() {
        return yayintarih;
    }

    public void setYayintarih(String yayintarih) {
        this.yayintarih = yayintarih;
    }

    public String getYayinekleurl() {
        return yayinekleurl;
    }

    public void setYayinekleurl(String yayinekleurl) {
        this.yayinekleurl = yayinekleurl;
    }

    
    
    
    public int getSergiid() {
        return sergiid;
    }

    public void setSergiid(int sergiid) {
        this.sergiid = sergiid;
    }

    public String getSergiad() {
        return sergiad;
    }

    public void setSergiad(String sergiad) {
        this.sergiad = sergiad;
    }

    public String getSergitar() {
        return sergitar;
    }

    public void setSergitar(String sergitar) {
        this.sergitar = sergitar;
    }

    public String getSergikapsam() {
        return sergikapsam;
    }

    public void setSergikapsam(String sergikapsam) {
        this.sergikapsam = sergikapsam;
    }

    public String getSergitip() {
        return sergitip;
    }

    public void setSergitip(String sergitip) {
        this.sergitip = sergitip;
    }

    public int getSergikisisayi() {
        return sergikisisayi;
    }

    public void setSergikisisayi(int sergikisisayi) {
        this.sergikisisayi = sergikisisayi;
    }

    public int getSergisure() {
        return sergisure;
    }

    public void setSergisure(int sergisure) {
        this.sergisure = sergisure;
    }

    public String getSergiekleurl() {
        return sergiekleurl;
    }

    public void setSergiekleurl(String sergiekleurl) {
        this.sergiekleurl = sergiekleurl;
    }
    
    
    
   public void sergiekleata(){
       this.sergiekleurl="sergi.xhtml?id="+kisiid;
   }
    

    public String getTebekleurl() {
        return tebekleurl;
    }

    public void setTebekleurl(String tebekleurl) {
        this.tebekleurl = tebekleurl;
    }

    public int getTebligid() {
        return tebligid;
    }

    public void setTebligid(int tebligid) {
        this.tebligid = tebligid;
    }

    
    
    public void tebekleata(){
        this.tebekleurl="teblig.xhtml?id="+kisiid;
    }
    
    public String getTebligkapsam() {
        return tebligkapsam;
    }

    public void setTebligkapsam(String tebligkapsam) {
        this.tebligkapsam = tebligkapsam;
    }

    public String getTebbiltur() {
        return tebbiltur;
    }

    public void setTebbiltur(String tebbiltur) {
        this.tebbiltur = tebbiltur;
    }

    public String getTebyaydur() {
        return tebyaydur;
    }

    public void setTebyaydur(String tebyaydur) {
        this.tebyaydur = tebyaydur;
    }

    public String getTebadi() {
        return tebadi;
    }

    public void setTebadi(String tebadi) {
        this.tebadi = tebadi;
    }

    public int getTebyazsayi() {
        return tebyazsayi;
    }

    public void setTebyazsayi(int tebyazsayi) {
        this.tebyazsayi = tebyazsayi;
    }

    public String getTebyazarlar() {
        return tebyazarlar;
    }

    public void setTebyazarlar(String tebyazarlar) {
        this.tebyazarlar = tebyazarlar;
    }

    public String getTebetkadi() {
        return tebetkadi;
    }

    public void setTebetkadi(String tebetkadi) {
        this.tebetkadi = tebetkadi;
    }

    public String getTebbastar() {
        return tebbastar;
    }

    public void setTebbastar(String tebbastar) {
        this.tebbastar = tebbastar;
    }

    public String getTebbittar() {
        return tebbittar;
    }

    public void setTebbittar(String tebbittar) {
        this.tebbittar = tebbittar;
    }

    public String getTebbastur() {
        return tebbastur;
    }

    public void setTebbastur(String tebbastur) {
        this.tebbastur = tebbastur;
    }

    public String getTebbasimtar() {
        return tebbasimtar;
    }

    public void setTebbasimtar(String tebbasimtar) {
        this.tebbasimtar = tebbasimtar;
    }

    public String getTebdil() {
        return tebdil;
    }

    public void setTebdil(String tebdil) {
        this.tebdil = tebdil;
    }

    
    public int getTasarimid() {
        return tasarimid;
    }

    public void setTasarimid(int tasarimid) {
        this.tasarimid = tasarimid;
    }

    public String getTasarimsahip() {
        return tasarimsahip;
    }

    public void setTasarimsahip(String tasarimsahip) {
        this.tasarimsahip = tasarimsahip;
    }

    public String getTasarimtur() {
        return tasarimtur;
    }

    public void setTasarimtur(String tasarimtur) {
        this.tasarimtur = tasarimtur;
    }

    public String getTasarimad() {
        return tasarimad;
    }

    public void setTasarimad(String tasarimad) {
        this.tasarimad = tasarimad;
    }

    public String getTasarimaciklama() {
        return tasarimaciklama;
    }

    public void setTasarimaciklama(String tasarimaciklama) {
        this.tasarimaciklama = tasarimaciklama;
    }

    public String getTasarimbastar() {
        return tasarimbastar;
    }

    public void setTasarimbastar(String tasarimbastar) {
        this.tasarimbastar = tasarimbastar;
    }

    public String getTasarimbittar() {
        return tasarimbittar;
    }

    public void setTasarimbittar(String tasarimbittar) {
        this.tasarimbittar = tasarimbittar;
    }

    public String getTasarimekleurl() {
        return tasarimekleurl;
    }

    public void setTasarimekleurl(String tasarimekleurl) {
        this.tasarimekleurl = tasarimekleurl;
    }

    
    
    
    public String getOdulekleurl() {
        return odulekleurl;
    }

    public void setOdulekleurl(String odulekleurl) {
        this.odulekleurl = odulekleurl;
    }

    
    
    public int getOdulid() {
        return odulid;
    }

    public void setOdulid(int odulid) {
        this.odulid = odulid;
    }

    public String getOdulkurulke() {
        return odulkurulke;
    }

    public void setOdulkurulke(String odulkurulke) {
        this.odulkurulke = odulkurulke;
    }

    public String getOdulkurtur() {
        return odulkurtur;
    }

    public void setOdulkurtur(String odulkurtur) {
        this.odulkurtur = odulkurtur;
    }

    public String getOdulkurum() {
        return odulkurum;
    }

    public void setOdulkurum(String odulkurum) {
        this.odulkurum = odulkurum;
    }

    public String getOdultur() {
        return odultur;
    }

    public void setOdultur(String odultur) {
        this.odultur = odultur;
    }

    public String getOdulad() {
        return odulad;
    }

    public void setOdulad(String odulad) {
        this.odulad = odulad;
    }

    public String getOdulyil() {
        return odulyil;
    }

    public void setOdulyil(String odulyil) {
        this.odulyil = odulyil;
    }

    public int getOdulkisisayi() {
        return odulkisisayi;
    }

    public void setOdulkisisayi(int odulkisisayi) {
        this.odulkisisayi = odulkisisayi;
    }

    public String getOdulaciklama() {
        return odulaciklama;
    }

    public void setOdulaciklama(String odulaciklama) {
        this.odulaciklama = odulaciklama;
    }

    
    
    
    
    
    public int getArasid() {
        return arasid;
    }

    public String getPatentekleurl() {
        return patentekleurl;
    }

    public void setPatentekleurl(String patentekleurl) {
        this.patentekleurl = patentekleurl;
    }

   

    
    
    public void setArasid(int arasid) {
        this.arasid = arasid;
    }

    public String getArastirmaekleurl() {
        return arastirmaekleurl;
    }

    public void setArastirmaekleurl(String arastirmaekleurl) {
        this.arastirmaekleurl = arastirmaekleurl;
    }

    public int getPatentid() {
        return patentid;
    }

    public void setPatentid(int patentid) {
        this.patentid = patentid;
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

    
    
    
    
    
    
    public String getArasbastar() {
        return arasbastar;
    }

    public void setArasbastar(String arasbastar) {
        this.arasbastar = arasbastar;
    }

    public String getArasbittar() {
        return arasbittar;
    }

    public void setArasbittar(String arasbittar) {
        this.arasbittar = arasbittar;
    }

    
    
    
    public List<kullanicilar> getKullaniciliste() {
        return kullaniciliste;
    }

    public void setKullaniciliste(List<kullanicilar> kullaniciliste) {
        this.kullaniciliste = kullaniciliste;
    }

    public List<kullanicilar> getKullanici() {
        return kullanici;
    }

    public void setKullanici(List<kullanicilar> kullanici) {
        this.kullanici = kullanici;
    }

    public String getArasad() {
        return arasad;
    }

    public String getArasbasliktur() {
        return arasbasliktur;
    }

    public void setArasbasliktur(String arasbasliktur) {
        this.arasbasliktur = arasbasliktur;
    }

    
    
    public void setArasad(String arasad) {
        this.arasad = arasad;
    }

    public String getArasbaslik() {
        return arasbaslik;
    }

    public void setArasbaslik(String arasbaslik) {
        this.arasbaslik = arasbaslik;
    }

    public String getArasicerik() {
        return arasicerik;
    }

    public void setArasicerik(String arasicerik) {
        this.arasicerik = arasicerik;
    }

    public String getArasyer() {
        return arasyer;
    }

    public void setArasyer(String arasyer) {
        this.arasyer = arasyer;
    }

    public String getArasulke() {
        return arasulke;
    }

    public void setArasulke(String arasulke) {
        this.arasulke = arasulke;
    }

    public int getAraskisisayi() {
        return araskisisayi;
    }

    public void setAraskisisayi(int araskisisayi) {
        this.araskisisayi = araskisisayi;
    }
    
    
    
    public void adminyenikulekleata(){
        this.adminyenikulekleurl="adminyenikulekle.xhtml";
    }
    

    public void adminkulyonetata(){
        this.adminkullaniciyonetmeurl="adminkullaniciyonetim.xhtml";
    }
    
    
    public String getAdminkullaniciyonetmeurl() {
        return adminkullaniciyonetmeurl;
    }

    public void setAdminkullaniciyonetmeurl(String adminkullaniciyonetmeurl) {
        this.adminkullaniciyonetmeurl = adminkullaniciyonetmeurl;
    }

    
    
    
    public double getKisipuan() {
        return kisipuan;
    }

    public void setKisipuan(double kisipuan) {
        this.kisipuan = kisipuan;
    }
    
    
    

    public int getProjeid() {
        return projeid;
    }

    public void setProjeid(int projeid) {
        this.projeid = projeid;
    }

    
    
    public int getKisiid() {
        return kisiid;
    }

    public void setKisiid(int kisiid) {
        this.kisiid = kisiid;
    }
    
    

    
    
    public String getProjegorev() {
        return projegorev;
    }

    public void setProjegorev(String projegorev) {
        this.projegorev = projegorev;
    }

    public String getUlusalitem() {
        return ulusalitem;
    }

    public void setUlusalitem(String ulusalitem) {
        this.ulusalitem = ulusalitem;
    }

    public String getProjedurum() {
        return projedurum;
    }

    public void setProjedurum(String projedurum) {
        this.projedurum = projedurum;
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


    
    public String getUluslaritem() {
        return uluslaritem;
    }

    public void setUluslaritem(String uluslaritem) {
        this.uluslaritem = uluslaritem;
    }
    

    public List<SelectItem> getNames() {
        return names;
    }

    public void setNames(List<SelectItem> names) {
        this.names = names;
    }

    public SelectItem getProjetür() {
        return projetür;
    }

    public void setProjetür(SelectItem projetür) {
        this.projetür = projetür;
    }

    public List<projeler> getProjeliste() {
        return projeliste;
    }

    public void setProjeliste(List<projeler> projeliste) {
        this.projeliste = projeliste;
    }

    public String getGecmisurl() {
        return gecmisurl;
    }

    public void setGecmisurl(String gecmisurl) {
        this.gecmisurl = gecmisurl;
    }
    

    
    public String getProjeekleurl() {
        return projeekleurl;
    }

    public void setProjeekleurl(String projeekleurl) {
        this.projeekleurl = projeekleurl;
    }

    public void gecmisekleata(){
        this.gecmisurl="gecmisim.xhtml?id="+kisiid;
    }
    
    
    public void yayinekleata(){
        this.yayinekleurl="yayinekle.xhtml?id="+kisiid;
    }
    
    public void tasarimekleata(){
        this.tasarimekleurl="tasarimekle.xhtml?id="+kisiid;
    }
    
    public void odulekleata(){
        this.odulekleurl="odulekle.xhtml?id="+kisiid;
    }
    
       public void projeekleata() {
        this.projeekleurl = "projeekle.xhtml?id="+kisiid;
    }
    public void arastirmaekleata(){
        this.arastirmaekleurl="arastirmaekle.xhtml?id="+kisiid;
        
    }
    public void patentekleata(){
        this.patentekleurl="patentekle.xhtml?id="+kisiid;
    }
    
    public String getBaskaurl() {
        return baskaurl;
    }

    public void setBaskaurl(String baskaurl) {
        this.baskaurl = baskaurl;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    
       public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdsoyad() {
        return adsoyad;
    }

    public void setAdsoyad(String adsoyad) {
        this.adsoyad = adsoyad;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
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
    
    
    
    public void kullanicisil(){
        
        try{
           Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8","root","");
            PreparedStatement ps = con.prepareStatement("DELETE FROM kisiler WHERE kisiid=?");
            ps.setInt(1,kisiid);
            ps.executeUpdate();
            ps.close();
            con.close();
            FacesContext.getCurrentInstance().getExternalContext().redirect("adminkullaniciyonetim.xhtml");
            
        }
        catch(Exception e){
            e.printStackTrace();
            FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "SQL HATASI", e.getMessage());  
            FacesContext.getCurrentInstance().addMessage(null, errorMsg);
        }
        
    }
    
    
    public void kullanicieditle(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8","root","");         
            PreparedStatement ps = con.prepareStatement("UPDATE  kisiler SET kulad=? WHERE kisiid=?");
            ps.setString(1,kulad);
            ps.setInt(2,kisiid);
            ps.executeUpdate();
            ps.close();
             ps = con.prepareStatement("UPDATE  kisiler SET kulsifre=? WHERE kisiid=?");
            ps.setString(1,kulsifre);
            ps.setInt(2,kisiid);
            ps.executeUpdate();
            ps.close();
              ps = con.prepareStatement("UPDATE  kisiler SET adsoyad=? WHERE kisiid=?");
            ps.setString(1,adsoyad);
            ps.setInt(2,kisiid);
            ps.executeUpdate();
            ps.close();
             ps = con.prepareStatement("UPDATE  kisiler SET birim=? WHERE kisiid=?");
            ps.setString(1,birim);
            ps.setInt(2,kisiid);
            ps.executeUpdate();
            ps.close();
             ps = con.prepareStatement("UPDATE  kisiler SET bolum=? WHERE kisiid=?");
            ps.setString(1,bolum);
            ps.setInt(2,kisiid);
            ps.executeUpdate();
            ps.close();
             ps = con.prepareStatement("UPDATE  kisiler SET nvan=? WHERE kisiid=?");
            ps.setString(1,unvan);
            ps.setInt(2,kisiid);
            ps.executeUpdate();
            ps.close();
              /* ps = con.prepareStatement("UPDATE  kisiler SET puan=? WHERE kisiid=?");
            ps.setInt(1,puan);
            ps.setInt(2,kisiid);
            ps.executeUpdate();
            ps.close();*/
            con.close();
            
            
        }
        catch(Exception e){
           FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Değiştirmede Hata oldu", e.getMessage());  
            FacesContext.getCurrentInstance().addMessage(null, errorMsg);  
        }
        
        
    }
    
    
    public List<kullanicilar> kisibilgigetir(){
        
           try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8","root","");
            PreparedStatement ps = con.prepareStatement("Select * FROM kisiler WHERE kisiid=?");
            ps.setInt(1,kisiid);
            ResultSet rs=ps.executeQuery();
            kullanici.clear();
            while(rs.next()){
                 if(kullanici.indexOf(rs.getString("kulad"))==-1)
                     kullanici.add(new kullanicilar(rs.getString("kulad"),rs.getString("kulsifre"),rs.getString("adsoyad"),rs.getString("bolum"),rs.getString("birim"),rs.getString("nvan"),rs.getInt("puan"),rs.getInt("kisiid")));
            }
            
            ps.close();
            rs.close();
            con.close();
            
        }
        catch(Exception e){
             FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Değiştirme Hatası", e.getMessage());  
            FacesContext.getCurrentInstance().addMessage(null, errorMsg);
        }
        return kullanici;
        
    }
    
    public void arastirmaupload(){
        
        
          try {
   
            // Load driver
            Class.forName("com.mysql.jdbc.Driver");
            // Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8","root","");
            // Set autocommit to false to manage it by hand
            connection.setAutoCommit(false);
         
            PreparedStatement statement = connection.prepareStatement("UPDATE arastirma  SET resume=? WHERE kisiid=?");
            statement.setBinaryStream(1,file.getInputstream());
            statement.setInt(2,kisiid);
            
             
            // Insert data to the database
            statement.executeUpdate();
             
            // Commit & close
            connection.commit();    // when autocommit=false
            connection.close();
             
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Upload success", file.getFileName() + " is uploaded.");  
            FacesContext.getCurrentInstance().addMessage(null, msg);
           // pdfgoster();//<embed src="file_name.pdf" width="800px" height="2100px" />
             
        } catch (Exception e) {
            e.printStackTrace();
             
            // Add error message
            FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Upload error", e.getMessage());  
            FacesContext.getCurrentInstance().addMessage(null, errorMsg);
        }
        
    }
    
     
    public void  projedownload(){
       this.projetabloaktif=true;
        try{         
    Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8","root","");
             Statement stmt=con.createStatement();
             ResultSet rs=stmt.executeQuery("Select * from proje");
             while(rs.next()){
                 veri= rs.getBinaryStream("resume");              
             }
          outputStream =
                    new FileOutputStream(new File("C:\\projekanit.pdf"));

		int read = 0;
		byte[] bytes = new byte[4096];

		while ((read = veri.read(bytes)) != -1) {
			outputStream.write(bytes, 0, read);
		}
             
                File file = new File("C:\\projekanit.pdf");
    HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();  
    response.setHeader("Content-Disposition", "attachment;filename=projekanit.pdf");  
    response.setContentLength((int) file.length());  
                ServletOutputStream out = null;  
                
                FileInputStream input = new FileInputStream(file);  
        byte[] buffer = new byte[4096];  
        out = response.getOutputStream();  
        int i = 0;  
        while ((i = input.read(buffer)) != -1) {  
            out.write(buffer);  
            out.flush();  
        }  
        FacesContext.getCurrentInstance().getResponseComplete();  
            
        }
        catch(Exception e){
                e.printStackTrace();
             
            // Add error message
            FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Download error", e.getMessage());  
            FacesContext.getCurrentInstance().addMessage(null, errorMsg);
        }
         this.projetabloaktif=true;
    }
    
    
    
    
    public void projeupload(){
        
        try {
   
            // Load driver
            Class.forName("com.mysql.jdbc.Driver");
            // Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8","root","");
            // Set autocommit to false to manage it by hand
            connection.setAutoCommit(false);
         
            PreparedStatement statement = connection.prepareStatement("UPDATE proje  SET resume=? WHERE kisiid=?");
            statement.setBinaryStream(1,file.getInputstream());
            statement.setInt(2,kisiid);
            
             
            // Insert data to the database
            statement.executeUpdate();
             
            // Commit & close
            connection.commit();    // when autocommit=false
            connection.close();
             
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Upload success", file.getFileName() + " is uploaded.");  
            FacesContext.getCurrentInstance().addMessage(null, msg);
           // pdfgoster();//<embed src="file_name.pdf" width="800px" height="2100px" />
             
        } catch (Exception e) {
            e.printStackTrace();
             
            // Add error message
            FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Upload error", e.getMessage());  
            FacesContext.getCurrentInstance().addMessage(null, errorMsg);
        }
        
    }
 
    
    public void upload()  {
        //jdbc:mysql://localhost:3306/akademiktesvik
    
          try {
             /*  FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);  
String isim=   (String) session.getAttribute("username");
             FacesContext fc = FacesContext.getCurrentInstance();
           Map<String,String> params =fc.getExternalContext().getRequestParameterMap();
           String isim = params.get("action");*/
              
        
              
            // Load driver
            Class.forName("com.mysql.jdbc.Driver");
            // Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8","root","");
            // Set autocommit to false to manage it by hand
            connection.setAutoCommit(false);
             
            
            
            /*
            // Create the statement object
            PreparedStatement statement = connection.prepareStatement("UPDATE kisiler  SET resume=? WHERE kisiid=?");
            // Set file data
            statement.setBinaryStream(1, file.getInputstream());
            statement.setInt(2,kisiid);*/
            
            PreparedStatement statement = connection.prepareStatement("UPDATE proje  SET resume=? WHERE kisiid=?");
            statement.setBinaryStream(1, file.getInputstream());
            statement.setInt(2,kisiid);
            
             
            // Insert data to the database
            statement.executeUpdate();
             
            // Commit & close
            connection.commit();    // when autocommit=false
            connection.close();
             
            //FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Upload success", file.getFileName() + " is uploaded.");  
            //FacesContext.getCurrentInstance().addMessage(null, msg);
           // pdfgoster();//<embed src="file_name.pdf" width="800px" height="2100px" />
             
        } catch (Exception e) {
            e.printStackTrace();
             
            // Add error message
            FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Upload error", e.getMessage());  
            FacesContext.getCurrentInstance().addMessage(null, errorMsg);
        }
        

    }
    

    public void baskaata() {
        this.baskaurl = "baska.xhtml";
    }

    public kontrolet() {
    }

    public String bilgidorumu() throws ScriptException {
        try {

            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            if(kulad!=null)
            session.setAttribute("username",kulad);
              System.out.println("Kullanıcı Adı Bu geldi"+session.getAttribute("username"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8", "root", "");
            String query = "Select * from kisiler";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                /*
                if (rs.getString("kulad").equals(kulad) && rs.getString("kulsifre").equals(kulsifre)) {
                    this.adsoyad = rs.getString("adsoyad");
                    this.kisiid=rs.getInt("kisiid");
                    return "anasayfa?faces-redirect=true&includeViewParams=true";
                }*/
                if (rs.getString("kulad").equals(kulad) && rs.getString("kulsifre").equals(kulsifre) && rs.getString("isadmin").equals("no")) {
                 this.adsoyad = rs.getString("adsoyad");
                    this.kisiid=rs.getInt("kisiid");  
                    return "anasayfa?faces-redirect=true&includeViewParams=true";
                }
                
                 if (rs.getString("kulad").equals(kulad) && rs.getString("kulsifre").equals(kulsifre) && rs.getString("isadmin").equals("yes")) {
                    this.adsoyad = rs.getString("adsoyad");
                    this.kisiid=rs.getInt("kisiid");
                    return "adminarayuz?faces-redirect=true&includeViewParams=true";
                }
                
                
                

            }

        } catch (Exception e) {
            System.out.println("Baglanti kuurulmadı hata var" + e.getMessage());
        }
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Hatalı kullanıcı girişi",
                "Message details");
        context.addMessage(null, message);
        context.validationFailed();

        return "index";

    }

    public void kullaniciekle() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8", "root", "");
            String query = "Insert Into kisiler(kulad,kulsifre,adsoyad,birim,bolum,nvan) Values(?,?,?,?,?,?)";
            PreparedStatement psmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            psmt.setString(1, kulad);
            psmt.setString(2, kulsifre);
            psmt.setString(3, adsoyad);
            psmt.setString(4, birim);
            psmt.setString(5, bolum);
            psmt.setString(6, unvan);

            psmt.executeUpdate();
            

            con.close();

        } catch (Exception e) {
            System.out.println("Baglanti kuurulmadı hata var" + e.getMessage());
        }
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Kullanıcı Başarıyla Kayıt Edildi",
                "Message details");
        context.addMessage(null, message);
        context.validationFailed();

    }

    public String getJsfurl() {
        return jsfurl;
    }

    public void setJsfurl(String jsfurl) {
        this.jsfurl = jsfurl;
    }

    public void oturumkapat() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        session.invalidate();

    }

    public void showjsf() {
        jsfurl = "kredi.xhtml?id="+kisiid;
    }

    public void yayinkaydet(){
        
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8", "root", "");
            String query="INSERT INTO yayin(kisiid,yayinad,yayintur,yayinkapsam,yayintarih) VALUES(?,?,?,?,?)";
             PreparedStatement psmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
             psmt.setInt(1,kisiid);
             psmt.setString(2,yayinad);
             psmt.setString(3,yayintur);
             psmt.setString(4,yayinkapsam);
             psmt.setString(5,yayintarih);
             psmt.executeUpdate();
             psmt.close();
             
             String yayingetirquery="Select * from sergi where kisiid=?";
       psmt=con.prepareStatement(yayingetirquery,PreparedStatement.RETURN_GENERATED_KEYS);
       psmt.setInt(1,kisiid);
        ResultSet rs=psmt.executeQuery();
        while(rs.next()){
            if(rs.getInt("kisiid")==kisiid){
                yayinid=rs.getInt("yayinid");             
            }
     
        }
        psmt.close();
        
          query="UPDATE kisiler SET yayinid=? WHERE kisiid=?";
        psmt=con.prepareStatement(query);
        psmt.setInt(1,yayinid);
        psmt.setInt(2,kisiid);
        psmt.executeUpdate();
        psmt.close();
            
            
          }
           catch(Exception e){
            e.printStackTrace();
             FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, kisiid+"SQL HATASI", e.getMessage());  
            FacesContext.getCurrentInstance().addMessage(null, errorMsg);
        }
        
    }
    
    
    
    public void sergikaydet(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8", "root", "");
            String query="INSERT INTO sergi(kisiid,sergiad,sergitar,sergikapsam,sergitip,sergikisisayi,sergisure) Values(?,?,?,?,?,?,?)";
             PreparedStatement psmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
             psmt.setInt(1,kisiid);
             psmt.setString(2,sergiad);
             psmt.setString(3,sergitar);
             psmt.setString(4,sergikapsam);
             psmt.setString(5,sergitip);
             psmt.setInt(6,sergikisisayi);
               psmt.setInt(7,sergisure);
               psmt.executeUpdate();
               psmt.close();
               
               
                String sergigetirquery="Select * from sergi where kisiid=?";
       psmt=con.prepareStatement(sergigetirquery,PreparedStatement.RETURN_GENERATED_KEYS);
       psmt.setInt(1,kisiid);
        ResultSet rs=psmt.executeQuery();
        while(rs.next()){
            if(rs.getInt("kisiid")==kisiid){
                sergiid=rs.getInt("sergiid");             
            }
     
        }
        psmt.close();
        
          query="UPDATE kisiler SET sergiid=? WHERE kisiid=?";
        psmt=con.prepareStatement(query);
        psmt.setInt(1,sergiid);
        psmt.setInt(2,kisiid);
        psmt.executeUpdate();
        psmt.close();
               
        double kisininpuani=0;
        String getirpuanquery="SELECT puan from kisiler where kisiid=?";
        psmt=con.prepareStatement(getirpuanquery);
        psmt.setInt(1,kisiid);
        rs= psmt.executeQuery();
        while(rs.next()){
            kisininpuani=rs.getDouble("puan");
        }
        if(sergikapsam.equals("Ulusal")){
          kisininpuani+=3;  
        }
        else if(sergikapsam.equals("Uluslararası")){
            kisininpuani+=6;
        }
        query="UPDATE kisiler SET puan=? WHERE kisiid=?";
         psmt=con.prepareStatement(query);
        psmt.setDouble(1,kisininpuani);
        psmt.setInt(2,kisiid);
         psmt.executeUpdate();
        psmt.close();
        rs.close();
        
        
            
         }
           catch(Exception e){
            e.printStackTrace();
             FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, kisiid+"SQL HATASI", e.getMessage());  
            FacesContext.getCurrentInstance().addMessage(null, errorMsg);
        }
        
    }
    
    
    
    public void tebligkaydet(){
        
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8", "root", "");
            String query="INSERT INTO bildiri(kisiid,bildiriad,bildiribastar,bildiribittar,tebkapsam,tebbiltur,tebyaydur,tebyazsayi,tebyazarlar,tebetkadi,tebbasimtur,tebbasimtarih,tebdil) Values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
             PreparedStatement psmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
             psmt.setInt(1,kisiid);
            psmt.setString(2,tebadi);
            psmt.setString(3,tebbastar);
            psmt.setString(4,tebbittar);
            psmt.setString(5,tebligkapsam);
            psmt.setString(6,tebbiltur);
            psmt.setString(7,tebyaydur);
             psmt.setInt(8,tebyazsayi);
             psmt.setString(9,tebyazarlar);
             psmt.setString(10,tebetkadi);
             psmt.setString(11,tebbastur);
             psmt.setString(12,tebbastar);
             psmt.setString(13,tebdil);
             psmt.executeUpdate();
             psmt.close();
             
             String tebliggetirquery="Select * from bildiri where kisiid=?";
       psmt=con.prepareStatement(tebliggetirquery,PreparedStatement.RETURN_GENERATED_KEYS);
       psmt.setInt(1,kisiid);
        ResultSet rs=psmt.executeQuery();
        while(rs.next()){
            if(rs.getInt("kisiid")==kisiid){
                tebligid=rs.getInt("bildiriid");             
            }
     
        }
        psmt.close();
        
          query="UPDATE kisiler SET bildiriid=? WHERE kisiid=?";
        psmt=con.prepareStatement(query);
        psmt.setInt(1,tebligid);
        psmt.setInt(2,kisiid);
        psmt.executeUpdate();
        psmt.close();
             
             
            
          }
           catch(Exception e){
            e.printStackTrace();
             FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, kisiid+"SQL HATASI", e.getMessage());  
            FacesContext.getCurrentInstance().addMessage(null, errorMsg);
        }
        
    }
    
    
    
    
    public void tasarimkaydet(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8", "root", "");
            String query = "INSERT INTO tasarim(kisiid,tasarimsahip,tasarimtur,tasarimad,tasarimaciklama,tasarimbastar,tasarimbittar) Values(?,?,?,?,?,?,?)";
            PreparedStatement psmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            psmt.setInt(1, kisiid);
            psmt.setString(2, tasarimsahip);
            psmt.setString(3, tasarimtur);
            psmt.setString(4, tasarimad);
            psmt.setString(5, tasarimaciklama);
            psmt.setString(6, tasarimbastar);
            psmt.setString(7, tasarimbittar);
            psmt.executeUpdate();
            psmt.close();
            
            
            String tasarimgetirquery="Select * from tasarim where kisiid=?";
       psmt=con.prepareStatement(tasarimgetirquery,PreparedStatement.RETURN_GENERATED_KEYS);
       psmt.setInt(1,kisiid);
        ResultSet rs=psmt.executeQuery();
        while(rs.next()){
            if(rs.getInt("kisiid")==kisiid){
                tasarimid=rs.getInt("tasarimid");             
            }
     
        }
        psmt.close();
        
          query="UPDATE kisiler SET tasarimid=? WHERE kisiid=?";
        psmt=con.prepareStatement(query);
        psmt.setInt(1,tasarimid);
        psmt.setInt(2,kisiid);
        psmt.executeUpdate();
        psmt.close();
            
           
        }
           catch(Exception e){
            e.printStackTrace();
             FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, kisiid+"SQL HATASI", e.getMessage());  
            FacesContext.getCurrentInstance().addMessage(null, errorMsg);
        }
        
    }
    
    
    
    
 
    public void odulkaydet(){
        
        
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8","root","");
            String query="INSERT INTO odul(kisiid,odulkurulke,odulkurtur,odulkurum,odultur,odulad,odulyil,odulkisisayi,odulaciklama) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement psmt=con.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
           psmt.setInt(1,kisiid);
           psmt.setString(2,odulkurulke);
           psmt.setString(3,odulkurtur);
           psmt.setString(4,odulkurum);
           psmt.setString(5,odultur);
           psmt.setString(6,odulad);
           psmt.setString(7,odulyil);
           psmt.setInt(8,odulkisisayi);
           psmt.setString(9,odulaciklama);
           psmt.executeUpdate();
           psmt.close();
           
           
           String odulgetirquery="Select * from odul where kisiid=?";
       psmt=con.prepareStatement(odulgetirquery,PreparedStatement.RETURN_GENERATED_KEYS);
       psmt.setInt(1,kisiid);
        ResultSet rs=psmt.executeQuery();
        while(rs.next()){
            if(rs.getInt("kisiid")==kisiid){
                odulid=rs.getInt("odulid");             
            }
     
        }
        psmt.close();
        
          query="UPDATE kisiler SET odulid=? WHERE kisiid=?";
        psmt=con.prepareStatement(query);
        psmt.setInt(1,odulid);
        psmt.setInt(2,kisiid);
        psmt.executeUpdate();
        psmt.close();
           
           
           
           
        }
        
          catch(Exception e){
            e.printStackTrace();
             FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, kisiid+"SQL HATASI", e.getMessage());  
            FacesContext.getCurrentInstance().addMessage(null, errorMsg);
        }
        
    }
    
    
    public void patentkaydet(){
        
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8","root","");
            String query="INSERT INTO patent(kisiid,patbassahip,patbulsahip,patkategori,patdostip,patyil,patbulozet) Values(?,?,?,?,?,?,?)";
            PreparedStatement psmt=con.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
            psmt.setInt(1,kisiid);
            psmt.setString(2,patbassahip);
            psmt.setString(3,patbulsahip);
            psmt.setString(4,patkategori);
            psmt.setString(5,patdostip);
            psmt.setString(6,patyil);
            psmt.setString(7,patbulozet);
            psmt.executeUpdate();
            psmt.close();
            
            
             String patentgetirquery="Select * from patent where kisiid=?";
       psmt=con.prepareStatement(patentgetirquery,PreparedStatement.RETURN_GENERATED_KEYS);
       psmt.setInt(1,kisiid);
        ResultSet rs=psmt.executeQuery();
        while(rs.next()){
            if(rs.getInt("kisiid")==kisiid){
                patentid=rs.getInt("patentid");             
            }
     
        }
        psmt.close();
        
          query="UPDATE kisiler SET patentid=? WHERE kisiid=?";
        psmt=con.prepareStatement(query);
        psmt.setInt(1,patentid);
        psmt.setInt(2,kisiid);
        psmt.executeUpdate();
        psmt.close();
        
        
            
            
        }
        catch(Exception e){
            e.printStackTrace();
             FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, kisiid+"SQL HATASI", e.getMessage());  
            FacesContext.getCurrentInstance().addMessage(null, errorMsg);
        }
        
    }
    
    
    
    

public void arastirmakaydet(){
    
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8", "root", "");
        String query="Insert Into arastirma(kisiid,arasad,arasbaslik,arasicerik,arasyer,arasulke,araskisisayi,arasbastar,arasbittar) Values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement psmt=con.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
        psmt.setInt(1,kisiid);
        psmt.setString(2,arasad);
        psmt.setString(3,arasbaslik);
        psmt.setString(4,arasicerik);
        psmt.setString(5,arasyer);
        psmt.setString(6,arasulke);
        psmt.setInt(7,araskisisayi);
        psmt.setString(8,arasbastar);
        psmt.setString(9,arasbittar);
        psmt.executeUpdate();
        psmt.close();
        
        String arasgetirquery="Select * from arastirma where kisiid=?";
       psmt=con.prepareStatement(arasgetirquery,PreparedStatement.RETURN_GENERATED_KEYS);
       psmt.setInt(1,kisiid);
        ResultSet rs=psmt.executeQuery();
        while(rs.next()){
            if(rs.getInt("kisiid")==kisiid){
                arasid=rs.getInt("arasid");             
            }
     
        }
        psmt.close();
        rs.close();
        
        query="UPDATE kisiler SET arasid=? WHERE kisiid=?";
        psmt=con.prepareStatement(query);
        psmt.setInt(1,arasid);
        psmt.setInt(2,kisiid);
        psmt.executeUpdate();
        psmt.close();
        
        double kisininpuani=0;
        String getirpuanquery="SELECT puan from kisiler where kisiid=?";
        psmt=con.prepareStatement(getirpuanquery);
        psmt.setInt(1,kisiid);
        rs= psmt.executeQuery();
        while(rs.next()){
            kisininpuani=rs.getDouble("puan");
        }
        if(arastirmakapsam.equals("Ulusal")){
          kisininpuani+=6;  
        }
        else if(arastirmakapsam.equals("Uluslararası")){
            kisininpuani+=9;
        }
        query="UPDATE kisiler SET puan=? WHERE kisiid=?";
         psmt=con.prepareStatement(query);
        psmt.setDouble(1,kisininpuani);
        psmt.setInt(2,kisiid);
         psmt.executeUpdate();
        psmt.close();
        rs.close();
        
    }
    catch(Exception e){
        e.printStackTrace();
         FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, kisiid+"SQL HATASI", e.getMessage());  
            FacesContext.getCurrentInstance().addMessage(null, errorMsg);
    }
    
    
    
}
    
    
    
    
    public void projekaydet(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik?useUnicode=true&characterEncoding=UTF-8", "root", "");
            String query = "Insert Into proje(kisiid,projead,projekonu,projedurum,projegorev,projebastar,projebittar) Values(?,?,?,?,?,?,?)";
             PreparedStatement psmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            double score=0.0;
             if(ulusalitem!=null){
                 
                 if(projegorev.equals("Yürütücü")){
                     score+=22.5;
                 }
                 if(projegorev.equals("Araştırmacı")){
                     score+=18;
                 }
                 
             }
             
             else if(uluslaritem!=null){    
                 
                 if(projegorev.equals("Yürütücü")){
                     score+=30;
                 }
                 if(projegorev.equals("Araştırmacı")){
                     score+=24;
                 }
                                
             }
             
             
             
             
             
            psmt.setInt(1,kisiid);
            psmt.setString(2,projead);
            psmt.setString(3,projekonu);
            psmt.setString(4,projedurum);
            psmt.setString(5,projegorev);
            psmt.setString(6,projebastar);
            psmt.setString(7,projebittar);
            
            psmt.executeUpdate();
            psmt.close();
            
            query="UPDATE kisiler SET projeid=? where kisiid=?";
            String projeidquery="Select * from proje where kisiid="+kisiid;
            Statement statement=con.createStatement();
            ResultSet rs=statement.executeQuery(projeidquery);
            while(rs.next()){               
                if(kisiid==rs.getInt("kisiid")){
                    projeid=rs.getInt("projeid");
                }
                
            }
            statement.close();
            rs.close();
            PreparedStatement psmt2;
             psmt2 = con.prepareStatement(query);
            psmt2.setInt(1,projeid);
            psmt2.setInt(2,kisiid);
            psmt2.executeUpdate();
            psmt2.close();
            
            query="UPDATE kisiler SET puan=? where kisiid=?";           
            PreparedStatement psmt3 = null;
            psmt3=con.prepareStatement(query);
            psmt3.setDouble(1,score);
            psmt3.setInt(2,kisiid);
            psmt3.executeUpdate();
            psmt3.close();
            
            
            con.close();
            
    
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(kontrolet.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Class Hatası",
                "Message details");
        context.addMessage(null, message);
        context.validationFailed();
        } catch (SQLException ex) {
            Logger.getLogger(kontrolet.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "SQL HATASI",
                ex.getMessage());
        context.addMessage(null, message);
        context.validationFailed();
        }
        
        
    } 
     
     
     
     public void pdfgoster() throws IOException{
        
           try {
            // Image bytes
            byte[] imageBytes = null;
             
            // Load driver
            Class.forName("com.mysql.jdbc.Driver");
            // Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik","root","");
             
            // Create the statement
            // This query is specific to MySQL, it returns only one row (using 'LIMIT 1') - the last uploaded file
            PreparedStatement statement = connection.prepareStatement("SELECT resume FROM kisiler ORDER BY kisiid DESC LIMIT 1");
             
            ResultSet rs = statement.executeQuery();
             
            while (rs.next()) { // This will run only once
                imageBytes = rs.getBytes("resume");
            }
 
            // Close the connection
            connection.close();
             HttpServletResponse resp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            resp.getOutputStream().write(imageBytes);
            resp.getOutputStream().close();
             
        } catch (Exception e) {
            // Display error message
            HttpServletResponse resp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            resp.getWriter().write(e.getMessage());
            resp.getWriter().close();
        }
 
    }
    
    
    public void puanhesaplama(){
    
        try{
            Class.forName("com.mysql.jdbc.Driver");
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik","root","");
            Statement psmt=connection.createStatement();
  
            ResultSet rs=psmt.executeQuery("SELECT puan from kisiler");
            while(rs.next()){
                 this.kisipuan=rs.getDouble("puan");
                 break;
            }
   
            rs.close();
            connection.close();
        }
        catch(Exception e){
            
        }
  
}
     
     public void kisiraporolustur(){
         
       try{
           Class.forName("com.mysql.jdbc.Driver");
          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/akademiktesvik","root","");
           String reportPath="C:\\Users\\samet\\Documents\\NetBeansProjects\\AkademikTesvik\\src\\java\\dbcheck\\kisilerraporu.jrxml";
           JasperReport jr=JasperCompileManager.compileReport(reportPath);
           JasperPrint jp=JasperFillManager.fillReport(jr,null,connection);
           JasperViewer.viewReport(jp);
           connection.close();
       }  
         catch(Exception e){
             
         }
         
         
     }
    
     
     
     
        /*
    public void ProjeDesTurDegistir(ValueChangeEvent e){
        String[] Ulusal={"TÜBA ve TÜBİTAK destekli proje","Kalkınma Bakanlığı destekli proje","Sanayi Tezleri Programı (SAN-TEZ) projesi"};
        String[] Uluslararası={"Diğer uluslararası özel veya resmi kurum ve kuruluşlar tarafından desteklenmiş proje (Yalnızca Ar-Ge niteliğindeki projeler)","Dünya Bankası, Avrupa Birliği ve Avrupa Konseyi tarafından desteklenmiş proje (Yalnızca Ar-Ge niteliğindeki projeler)"};
        
        if(projetür.getLabel().equals("Ulusal")){
            names.add(new SelectItem(Ulusal,"label"));
        }
        else if(projetür.getLabel().equals("Uluslararası")){
            names.add(new SelectItem(Uluslararası.toString(),"label"));
        }
        
    }*/

}

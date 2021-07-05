package rs.ac.uns.ftn.WebProjekat.model.dto;

import java.sql.Time;
import java.sql.Date;

public class TerminDTO{
    
    private Long id;
    private String nazivTreninga;
    private Tip tipTreninga;
    private String opisTreninga;
    private Double cena;
    private Time vreme;
    private Date datum;
    private String imeTrenera;
    private String prezimeTrenera;
    private Long salaId;
    private Long treningId;
    private String oznakaSale;

    public TerminDTO(){}

    public TerminDTO(Long id, String naziv,Tip tip, String opis, Double cena, Time vreme, Date datum, String ime, String prezime){
        this.id=id;
        this.nazivTreninga=naziv;
        this.tipTreninga=tip;
        this.opisTreninga=opis;
        this.cena=cena;
        this.vreme=vreme;
        this.datum=datum;
        this.imeTrenera=ime;
        this.prezimeTrenera=prezime;
    }

    public TerminDTO(Long id, String naziv,Tip tip, String opis, Double cena, Time vreme, Date datum, String ime, String prezime, String oznaka){
        this.id=id;
        this.nazivTreninga=naziv;
        this.tipTreninga=tip;
        this.opisTreninga=opis;
        this.cena=cena;
        this.vreme=vreme;
        this.datum=datum;
        this.imeTrenera=ime;
        this.prezimeTrenera=prezime;
        this.oznakaSale=oznaka;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public String getNaziv(){return nazivTreninga;}
    public void setNaziv(String naziv){this.nazivTreninga=naziv;}

    public Tip getTipTreninga(){return tipTreninga;}
    public void setTipTreninga(Tip tip){this.tipTreninga=tip;}

    public String getOpis(){return opisTreninga;}
    public void setOpis(String opis){this.opisTreninga=opis;}

    public Double getCena(){return cena;}
    public void setCena(Double cena){this.cena=cena;}

    public Time getVreme(){return vreme;}
    public void setVreme(Time vreme){this.vreme=vreme;}

    public Date getDatum(){return datum;}
    public void setDatum(Date datum){this.datum=datum;}

    public String getImeTrenera(){return imeTrenera;}
    public void setImeTrenera(String ime){this.imeTrenera=ime;}

    public String getPrezimeTrenera(){return prezimeTrenera;}
    public void setprezimeTrenera(String prezime){this.prezimeTrenera=prezime;}

    public Long getSalaId(){return salaId;}
    public void setSalaId(Long id){this.salaId=id;}

    public Long getTreningId(){return treningId;}
    public void setTreningId(Long id){this.treningId=id;}

    public String getOznaka(){return oznakaSale;}
    public void setOznaka(String oznaka){this.oznakaSale=oznaka;}

}

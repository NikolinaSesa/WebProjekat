package rs.ac.uns.ftn.WebProjekat.model.dto;

import java.sql.Time;

public class TerminDTO{
    
    private Long id;
    private String nazivTreninga;
    private Tip tipTreninga;
    private String opisTreninga;
    private Double cena;
    private Time vreme;
    private Dani dan;
    private String imeTrenera;
    private String prezimeTrenera;

    public TerminDTO(){}

    public TerminDTO(Long id, String naziv,Tip tip, String opis, Double cena, Time vreme, Dani dan, String ime, String prezime){
        this.id=id;
        this.nazivTreninga=naziv;
        this.tipTreninga=tip;
        this.opisTreninga=opis;
        this.cena=cena;
        this.vreme=vreme;
        this.dan=dan;
        this.imeTrenera=ime;
        this.prezimeTrenera=prezime;
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

    public Dani getDan(){return dan;}
    public void setDan(Dani dan){this.dan=dan;}

    public String getImeTrenera(){return imeTrenera;}
    public void setImeTrenera(String ime){this.imeTrenera=ime;}

    public String getPrezimeTrenera(){return prezimeTrenera;}
    public void setprezimeTrenera(String prezime){this.prezimeTrenera=prezime;}
}

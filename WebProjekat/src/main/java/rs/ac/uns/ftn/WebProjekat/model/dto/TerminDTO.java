package rs.ac.uns.ftn.WebProjekat.model.dto;

public class TerminDTO {
    
    private Long id;
    private String nazivTreninga;
    private String opisTreninga;
    private Double cena;
    private Double vreme;
    private String imeTrenera;
    private String prezimeTrenera;

    public TerminDTO(){}

    public TerminDTO(Long id, String naziv, String opis, Double cena, Double vreme, String ime, String prezime){
        this.id=id;
        this.nazivTreninga=naziv;
        this.opisTreninga=opis;
        this.cena=cena;
        this.vreme=vreme;
        this.imeTrenera=ime;
        this.prezimeTrenera=prezime;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public String getNaziv(){return nazivTreninga;}
    public void setNaziv(String naziv){this.nazivTreninga=naziv;}

    public String getOpis(){return opisTreninga;}
    public void setOpis(String opis){this.opisTreninga=opis;}

    public Double getCena(){return cena;}
    public void setCena(Double cena){this.cena=cena;}

    public Double getVreme(){return vreme;}
    public void setVreme(Double vreme){this.vreme=vreme;}

    public String getImeTrenera(){return imeTrenera;}
    public void setImeTrenera(String ime){this.imeTrenera=ime;}

    public String getPrezimeTrenera(){return prezimeTrenera;}
    public void setprezimeTrenera(String prezime){this.prezimeTrenera=prezime;}
}

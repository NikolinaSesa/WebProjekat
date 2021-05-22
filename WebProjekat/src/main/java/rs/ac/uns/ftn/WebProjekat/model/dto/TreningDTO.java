package rs.ac.uns.ftn.WebProjekat.model.dto;

public class TreningDTO{

    private Long id;
    private String naziv;
    private String opis;
    private Double trajanje;
    private String imeTrenera;
    private String prezimeTrenera;
    
    public TreningDTO(){}

    public TreningDTO(Long id, String n, String o, Double tr, String ime, String prezime){
        this.id=id;
        this.naziv=n;
        this.opis=o;
        this.trajanje=tr;
        this.imeTrenera=ime;
        this.prezimeTrenera=prezime;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public String getNaziv(){return naziv;}
    public void setNaziv(String naziv){this.naziv=naziv;}

    public String getOpis(){return opis;}
    public void setOpis(String opis){this.opis=opis;}

    public Double getTrajanje(){return trajanje;}
    public void setTrajanje(Double trajanje){this.trajanje=trajanje;}

    public String getImeTrenera(){return imeTrenera;}
    public void setImeTrenera(String ime){this.imeTrenera=ime;}

    public String getPrezimeTrenera(){return prezimeTrenera;}
    public void setprezimeTrenera(String prezime){this.prezimeTrenera=prezime;}
}

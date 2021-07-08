package rs.ac.uns.ftn.WebProjekat.model.dto;

public class TreningDTO2 {
    
    private Long id;
    private String naziv;
    private Tip tip;
    private String opis;
    private Double trajanje;
    
    public TreningDTO2(){}

    public TreningDTO2(Long id, String n, Tip tip, String o, Double tr){
        this.id=id;
        this.naziv=n;
        this.tip=tip;
        this.opis=o;
        this.trajanje=tr;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public String getNaziv(){return naziv;}
    public void setNaziv(String naziv){this.naziv=naziv;}

    public Tip getTip(){return tip;}
    public void setTip(Tip tip){this.tip=tip;}

    public String getOpis(){return opis;}
    public void setOpis(String opis){this.opis=opis;}

    public Double getTrajanje(){return trajanje;}
    public void setTrajanje(Double trajanje){this.trajanje=trajanje;}
}

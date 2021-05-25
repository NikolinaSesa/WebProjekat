package rs.ac.uns.ftn.WebProjekat.model.dto;

public class TrenerDTO {

    private Long id;
    private String korisnickoIme;
    private String ime;
    private String prezime;
    private String brTelefona;
    private String email;
    private String datumRodjenja;
    private Boolean aktivan;

    public TrenerDTO(){}

    public TrenerDTO(Long id, String ki, String ime, String prez, String br, String email, String datum, Boolean aktivan){
        this.id=id;
        this.korisnickoIme=ki;
        this.ime=ime;
        this.prezime=prez;
        this.brTelefona=br;
        this.email=email;
        this.datumRodjenja=datum;
        this.aktivan=aktivan;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public String getKorisnickoIme(){return korisnickoIme;}
    public void setKorisnickoIme(String ki){this.korisnickoIme=ki;}

    public String getIme(){return ime;}
    public void setIme(String ime){this.ime=ime;}

    public String getPrezime(){return prezime;}
    public void setPrezime(String prez){this.prezime=prez;}

    public String getBr(){return brTelefona;}
    public void setBr(String br){this.brTelefona=br;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}

    public String getDatum(){return datumRodjenja;}
    public void setDatum(String datum){this.datumRodjenja=datum;}

    public Boolean getAktivan(){return aktivan;}
    public void setAktivan(Boolean aktivan){this.aktivan=aktivan;}
    
}

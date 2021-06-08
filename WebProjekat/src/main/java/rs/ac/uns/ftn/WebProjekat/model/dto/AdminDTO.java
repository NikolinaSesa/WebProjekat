package rs.ac.uns.ftn.WebProjekat.model.dto;

import rs.ac.uns.ftn.WebProjekat.model.Uloga;

public class AdminDTO {

    private Long id;
    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;
    private Long brTelefona;
    private String email;
    private Uloga uloga;

    public AdminDTO(){}

    public AdminDTO(Long id, String ki, String lozinka, String ime, String prezime, Long br, String email, Uloga uloga){
        this.id=id;
        this.korisnickoIme=ki;
        this.lozinka=lozinka;
        this.ime=ime;
        this.prezime=prezime;
        this.brTelefona=br;
        this.email=email;
        this.uloga=uloga;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public String getKorisnickoIme(){return korisnickoIme;}
    public void setKorisnickoIme(String ki){this.korisnickoIme=ki;}

    public String getLozinka(){return lozinka;}
    public void setLozinka(String lozinka){this.lozinka=lozinka;}

    public String getIme(){return ime;}
    public void setIme(String ime){this.ime=ime;}

    public String getPrezime(){return prezime;}
    public void setPrezime(String prezime){this.prezime=prezime;}

    public Long getBrTelefona(){return brTelefona;}
    public void setBrTelefona(Long br){this.brTelefona=br;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}
    
    public Uloga getUloga(){return uloga;}
    public void setUloga(Uloga uloga){this.uloga=uloga;}
    
}

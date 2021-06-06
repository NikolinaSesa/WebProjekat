package rs.ac.uns.ftn.WebProjekat.model.dto;

import java.sql.Date;

import rs.ac.uns.ftn.WebProjekat.model.Fitnesscentar;
import rs.ac.uns.ftn.WebProjekat.model.Uloga;

public class TrenerDTO {

    private Long id;
    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;
    private Long brTelefona;
    private String email;
    private Date datumRodjenja;
    private Uloga uloga;
    private Boolean aktivan;
    private Fitnesscentar fitnesscentar;

    public TrenerDTO(){}

    public TrenerDTO(Long id, String ki, String ime, String prez, Long br, String email, Date datum, Uloga uloga, Boolean aktivan){
        this.id=id;
        this.korisnickoIme=ki;
        this.ime=ime;
        this.prezime=prez;
        this.brTelefona=br;
        this.email=email;
        this.datumRodjenja=datum;
        this.uloga=uloga;
        this.aktivan=aktivan;
    }

    public TrenerDTO(Long id, String ki, String lozinka, String ime, String prez, Long br, String email, Date datum, Uloga uloga, Boolean aktivan){
        this.id=id;
        this.korisnickoIme=ki;
        this.lozinka=lozinka;
        this.ime=ime;
        this.prezime=prez;
        this.brTelefona=br;
        this.email=email;
        this.datumRodjenja=datum;
        this.uloga=uloga;
        this.aktivan=aktivan;
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
    public void setPrezime(String prez){this.prezime=prez;}

    public Long getBrTelefona(){return brTelefona;}
    public void setBr(Long br){this.brTelefona=br;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}

    public Date getDatumRodjenja(){return datumRodjenja;}
    public void setDatum(Date datum){this.datumRodjenja=datum;}

    public Uloga getUloga(){return uloga;}
    public void setUloga(Uloga uloga){this.uloga=uloga;}

    public Boolean getAktivan(){return aktivan;}
    public void setAktivan(Boolean aktivan){this.aktivan=aktivan;}
    
    public Fitnesscentar getFitnesscentar(){return fitnesscentar;}
    public void setFitnesscentar(Fitnesscentar fitnesscentar){this.fitnesscentar=fitnesscentar;}
}

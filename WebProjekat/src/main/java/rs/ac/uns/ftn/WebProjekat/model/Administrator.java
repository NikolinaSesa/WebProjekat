package rs.ac.uns.ftn.WebProjekat.model;

import javax.persistence.*;
import jdk.jfr.BooleanFlag;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Administrator implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String korisnickoime;

    @Column(nullable = false)
    private String lozinka;

    @Column(nullable = false)
    private String ime;

    @Column(nullable = false)
    private String prezime;

    @Column
    private Long brtelefona;

    @Column
    private String email;

    @Column
    private Date datumrodjenja;

    @Enumerated(EnumType.STRING)
    @Column
    private Uloga uloga;

    @BooleanFlag
    @Column
    private Boolean aktivan;

    @OneToOne
    private Fitnesscentar fitnesscentar;

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public String getKorisnickoIme(){return korisnickoime;}
    public void setKorisnickoIme(String ki){this.korisnickoime=ki;}

    public String getLozinka(){return lozinka;}
    public void setLozinka(String lozinka){this.lozinka=lozinka;}

    public String getIme(){return ime;}
    public void setIme(String ime){this.ime=ime;}

    public String getPrezime(){return prezime;}
    public void setPrezime(String prezime){this.prezime=prezime;}

    public Long getBrTelefona(){return brtelefona;}
    public void setBrTelefona(Long tel){this.brtelefona=tel;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}

    public Date getDatum(){return datumrodjenja;}
    public void setDatum(Date datum){this.datumrodjenja=datum;}

    public Uloga getUloga(){return uloga;}
    public void setUloga(Uloga uloga){this.uloga=uloga;}

    public Boolean getAktivan(){return aktivan;}
    public void setAktivan(Boolean aktivan){this.aktivan=aktivan;}
}

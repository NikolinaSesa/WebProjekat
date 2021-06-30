package rs.ac.uns.ftn.WebProjekat.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import jdk.jfr.BooleanFlag;

@Entity
public class Clan implements Serializable{
    
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

    @ManyToMany
    @JoinTable(name = "ocene", joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ocena_id", referencedColumnName = "id"))
    private Set<Ocena> listaOcena = new HashSet<>();

    @ManyToMany(mappedBy = "prijavljeni")
    private Set<Termin> listaPrijavaZaTermine = new HashSet<>();

    @ManyToMany(mappedBy = "clanoviKojiSuOdradili")
    private Set<Termin> listaOdradjenihTreninga = new HashSet<>();

    public Clan(){}

    public Clan(String ki, String lozinka, String ime, String prezime, Long br, String email, Date datum, Uloga uloga, Boolean aktivan){
        this.korisnickoime=ki;
        this.lozinka=lozinka;
        this.ime=ime;
        this.prezime=prezime;
        this.brtelefona=br;
        this.email=email;
        this.datumrodjenja=datum;
        this.uloga=uloga;
        this.aktivan=aktivan;
    }

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

package rs.ac.uns.ftn.WebProjekat.model;

import java.io.Serializable;
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
    private String brtelefona;

    @Column
    private String email;

    @Column
    private String datumrodjenja;

    @Enumerated(EnumType.STRING)
    @Column
    private Uloga uloga;

    @BooleanFlag
    @Column
    private Boolean aktivan;

    @ManyToOne(fetch = FetchType.EAGER)
    private Fitnesscentar fitnesscentar;

    @ManyToMany
    @JoinTable(name = "ocene", joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ocena_id", referencedColumnName = "id"))
    private Set<Ocena> listaOcena = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "listaprijava", joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    private Set<Termin> listaPrijavaZaTermine= new HashSet<>();

    @ManyToMany
    @JoinTable(name = "odradjeni", joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    private Set<Termin> listaOdradjenihTreninga = new HashSet<>();

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

    public String getBrTelefona(){return brtelefona;}
    public void setBrTelefona(String tel){this.brtelefona=tel;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}

    public String getDatum(){return datumrodjenja;}
    public void setDatum(String datum){this.datumrodjenja=datum;}

    public Uloga getUloga(){return uloga;}
    public void setUloga(Uloga uloga){this.uloga=uloga;}

    public Boolean getAktivan(){return aktivan;}
    public void setAktivan(Boolean aktivan){this.aktivan=aktivan;}

    public Fitnesscentar getFC(){return fitnesscentar;}
    public void setFC(Fitnesscentar fc){this.fitnesscentar=fc;}
}

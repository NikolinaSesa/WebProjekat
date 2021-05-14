package rs.ac.uns.ftn.WebProjekat.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

enum Tip{CARDIO, YOGA, PILATES, HIIT, KICKBOX}

@Entity
public class Trening implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String opis;

    @Enumerated(EnumType.STRING)
    @Column
    private Tip tip;

    @Column
    private Double trajanje;

    @ManyToOne(fetch = FetchType.EAGER)
    private Trener trener;

    @ManyToMany(mappedBy = "odradjenitreninzi")
    private Set<Clan> clanovi = new HashSet<>();

    @OneToMany(mappedBy = "trening", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Termin> termini= new HashSet<>();

    @Column
    private Double ocena;

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public String getOpis(){return opis;}
    public void setOpis(String opis){this.opis=opis;}

    public Tip getTip(){return tip;}
    public void setTip(Tip tip){this.tip=tip;}

    public Double getTrajanje(){return trajanje;}
    public void setTrajanje(Double trajanje){this.trajanje=trajanje;}

    public Trener getTrener(){return trener;}
    public void setTrener(Trener trener){this.trener=trener;}

    public Set<Termin> getTermini(){return termini;}
    public void setTermini(Set<Termin> termini){this.termini=termini;}

    public Double getOcena(){return ocena;}
    public void setOcena(Double ocena){this.ocena=ocena;}
    
}

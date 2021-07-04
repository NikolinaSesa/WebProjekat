package rs.ac.uns.ftn.WebProjekat.model;

import javax.persistence.Entity;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;

@Entity
public class Termin{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double cena;

    @Column
    private Date datum;

    @Column
    private Time vreme;

    @ManyToOne(fetch = FetchType.EAGER)
    private Sala sala;

    @ManyToMany
    @JoinTable(name = "listaprijava", joinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"))
    private Set<Clan> prijavljeni= new HashSet<>();

    @ManyToMany
    @JoinTable(name = "odradjeni", joinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"))
    private Set<Clan> clanoviKojiSuOdradili = new HashSet<>();

    @OneToMany(mappedBy = "termin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Ocena> oceneTermina=new HashSet<>();
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Trening trening;

    @Column
    private Integer brPrijavljenihClanova;

    public Termin(){}

    public Termin(Double cena, Date datum, Time vreme, Sala sala, Trening trening){
        this.cena=cena;
        this.datum=datum;
        this.vreme=vreme;
        this.sala=sala;
        this.trening=trening;
        this.brPrijavljenihClanova=0;

    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public Double getCena(){return cena;}
    public void setCena(Double cena){this.cena=cena;}

    public Date getDatum(){return datum;}
    public void setDatum(Date datum){this.datum=datum;}

    public Time getVreme(){return vreme;}
    public void setVreme(Time vreme){this.vreme=vreme;}

    public Sala getSala(){return sala;}
    public void setSala(Sala sala){this.sala=sala;}

    public Trening getTrening(){return trening;}
    public void setTrening(Trening trening){this.trening=trening;}

    public Integer getBrPrijavljenihClanova(){return brPrijavljenihClanova;}
    public void setBrPrijavljenihClanova(Integer br){this.brPrijavljenihClanova=br;}

    public Set<Clan> getPrijavljeni(){return prijavljeni;}
    public void setPrijavljeni(Clan clan){this.prijavljeni.add(clan);}
    public void otkazi(Set<Clan> prijavljeni){this.prijavljeni=prijavljeni;}

    public Set<Clan> getClanoviKojiSuOdradili(){return clanoviKojiSuOdradili;}
    public void setClanKojiJeOdradio(Clan clan){this.clanoviKojiSuOdradili.add(clan);}

    public Set<Ocena> getOceneTermina(){return oceneTermina;}
    public void setOcena(Ocena ocena){this.oceneTermina.add(ocena);}
    

}

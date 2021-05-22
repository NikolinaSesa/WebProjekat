package rs.ac.uns.ftn.WebProjekat.model;

import javax.persistence.Entity;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.*;
import rs.ac.uns.ftn.WebProjekat.model.dto.Dani;

@Entity
public class Termin{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double cena;

    @Enumerated(EnumType.STRING)
    @Column
    private Dani dan;

    @Column
    private Double vreme;

    @ManyToOne(fetch = FetchType.EAGER)
    private Sala sala;

    @ManyToMany(mappedBy = "listaPrijavaZaTermine")
    private Set<Clan> prijavljeni = new HashSet<>();

    @ManyToMany(mappedBy = "listaOdradjenihTreninga")
    private Set<Clan> clanoviKojiSuOdradili = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "ocene", joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    private Set<Ocena> oceneTermina = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Trening trening;

    @Column
    private Integer brPrijavljenihClanova;

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public Double getCena(){return cena;}
    public void setCena(Double cena){this.cena=cena;}

    public Dani getDan(){return dan;}
    public void setDan(Dani dan){this.dan=dan;}

    public Double getVreme(){return vreme;}
    public void setVreme(Double vreme){this.vreme=vreme;}

    public Sala getSala(){return sala;}
    public void setSala(Sala sala){this.sala=sala;}

    public Trening getTrening(){return trening;}
    public void setTrening(Trening trening){this.trening=trening;}

    public Integer getBrPrijavljenihClanova(){return brPrijavljenihClanova;}
    public void setBrPrijavljenihClanova(Integer br){this.brPrijavljenihClanova=br;}

}

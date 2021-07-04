package rs.ac.uns.ftn.WebProjekat.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Ocena implements Serializable{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer ocena;

    @ManyToOne(fetch = FetchType.EAGER)
    private Clan clan;

    @ManyToOne(fetch = FetchType.EAGER)
    private Termin termin;

    public Ocena(){}
    public Ocena(Integer ocena, Clan clan, Termin termin){
        this.ocena=ocena;
        this.clan=clan;
        this.termin=termin;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public Integer getOcena(){return ocena;}
    public void setOcena(Integer ocena){this.ocena = ocena;}

    public Clan getClan(){return clan;}
    public void setClan(Clan clan){this.clan=clan;}

    public Termin getTermin(){return termin;}
    public void setTermin(Termin termin){this.termin=termin;}


}
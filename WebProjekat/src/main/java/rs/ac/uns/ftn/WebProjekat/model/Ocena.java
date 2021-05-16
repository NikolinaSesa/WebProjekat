package rs.ac.uns.ftn.WebProjekat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Ocena implements Serializable{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer ocena;

    @ManyToMany(mappedBy = "listaOcena")
    private Set<Clan> clanovi = new HashSet<>();

    @ManyToMany(mappedBy = "oceneTermina")
    private Set<Termin> termini = new HashSet<>();

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public Integer getOcena(){return ocena;}
    public void setOcena(Integer ocena){this.ocena = ocena;}
}
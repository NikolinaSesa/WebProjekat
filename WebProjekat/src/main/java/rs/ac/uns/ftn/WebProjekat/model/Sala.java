package rs.ac.uns.ftn.WebProjekat.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sala implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column 
    private Integer kapacitet;

    @Column 
    private String oznaka;

    @ManyToOne(fetch = FetchType.EAGER)
    private Fitnesscentar fitnesscentar;

    @OneToMany(mappedBy = "sala", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Termin> listatermina= new HashSet<>();

    public Sala(){}

    public Sala(Integer kapacitet, String oznaka, Fitnesscentar fitnesscentar){
        this.kapacitet=kapacitet;
        this.oznaka=oznaka;
        this.fitnesscentar=fitnesscentar;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public Integer getKapacitet(){return kapacitet;}
    public void setKapacitet(Integer kapacitet){this.kapacitet=kapacitet;}

    public String getOznaka(){return oznaka;}
    public void setOznaka(String oznaka){this.oznaka=oznaka;}

    public Fitnesscentar getFitnessCentar(){return fitnesscentar;}
    public void setFitnessCentar(Fitnesscentar fitnessCentar){this.fitnesscentar=fitnessCentar;}

    public Set<Termin> getListaTermina(){return listatermina;}
    public void setListaTermina(Set<Termin> lt){this.listatermina=lt;}
}

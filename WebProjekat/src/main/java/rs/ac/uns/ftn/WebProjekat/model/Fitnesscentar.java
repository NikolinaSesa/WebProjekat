package rs.ac.uns.ftn.WebProjekat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Fitnesscentar implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String adresa;

    @Column
    private String brtelefona;

    @Column
    private String email;

    @OneToMany(mappedBy = "fitnesscentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Sala> sale = new HashSet<>();

    @OneToMany(mappedBy = "fitnesscentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Trener> treneri= new HashSet<>();

    @OneToMany(mappedBy = "fitnesscentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Clan> clanovi= new HashSet<>();

    @OneToOne(mappedBy = "fitnesscentar")
    private Administrator admin;

    public Fitnesscentar(){}

    public Fitnesscentar(String naziv, String adresa, String br, String email){
        this.naziv=naziv;
        this.adresa=adresa;
        this.brtelefona=br;
        this.email=email;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public String getNaziv(){return naziv;}
    public void setNaziv(String naziv){this.naziv=naziv;}

    public String getAdresa(){return adresa;}
    public void setAdresa(String adresa){this.adresa=adresa;}

    public String getBrTelefona(){return brtelefona;}
    public void setBrTelefona(String brtelefona){this.brtelefona=brtelefona;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}

    public Set<Sala> getListaSala(){return sale;}
    public void setListaSala(Set<Sala> sala){this.sale=sala;}

    public Set<Trener> getTreneri(){return treneri;}
    public void setTreneri(Set<Trener> treneri){this.treneri=treneri;}

    public Set<Clan> getClanovi(){return clanovi;}
    public void setClanovi(Set<Clan> clanovi){this.clanovi=clanovi;}

    @Override
    public String toString(){
        return "Fitness centar{" + "id= "+id+", naziv: "+naziv+", adresa: "+adresa+", broja telefona: "+brtelefona+" i email: "+email+"}";
    }
    
}

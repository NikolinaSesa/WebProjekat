package rs.ac.uns.ftn.WebProjekat.model.dto;

public class FitnesscentarDTO {
    
    private Long id;
    private String naziv;
    private String adresa;
    private Long brTelefona;
    private String email;

    public FitnesscentarDTO(){}

    public FitnesscentarDTO(Long id, String naziv, String adresa, Long brTel, String email){
        this.id=id;
        this.naziv=naziv;
        this.adresa=adresa;
        this.brTelefona=brTel;
        this.email=email;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public String getNaziv(){return naziv;}
    public void setNaziv(String naziv){this.naziv=naziv;}

    public String getAdresa(){return adresa;}
    public void setAdresa(String adresa){this.adresa=adresa;}

    public Long getBrTelefona(){return brTelefona;}
    public void setBrTelefona(Long brTelefona){this.brTelefona=brTelefona;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}
}

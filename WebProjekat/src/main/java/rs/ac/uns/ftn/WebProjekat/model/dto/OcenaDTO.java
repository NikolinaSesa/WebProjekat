package rs.ac.uns.ftn.WebProjekat.model.dto;

public class OcenaDTO {

    private Long id;
    private Integer ocena;

    public OcenaDTO(){}
    public OcenaDTO(Long id, Integer ocena){
        this.id=id;
        this.ocena=ocena;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public Integer getOcena(){return ocena;}
    public void setOcena(Integer ocena){this.ocena=ocena;}
    
}

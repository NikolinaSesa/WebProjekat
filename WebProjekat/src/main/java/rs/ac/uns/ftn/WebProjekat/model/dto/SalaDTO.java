package rs.ac.uns.ftn.WebProjekat.model.dto;

public class SalaDTO {

    private Long id;
    private Integer kapacitet;
    private String oznaka;
    private Long fitnesscentarId;

    public SalaDTO(){}

    public SalaDTO(Long id, Integer kapacitet, String oznaka, Long fitnesscentarId){
        this.id=id;
        this.kapacitet=kapacitet;
        this.oznaka=oznaka;
        this.fitnesscentarId=fitnesscentarId;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public Integer getKapacitet(){return kapacitet;}
    public void setKapacitet(Integer kapacitet){this.kapacitet=kapacitet;}

    public String getOznaka(){return oznaka;}
    public void setOznaka(String oznaka){this.oznaka=oznaka;}

    public Long getFitnesscentar(){return fitnesscentarId;}
    public void setFitnesscentarId(Long fitnesscentarId){this.fitnesscentarId=fitnesscentarId;}

    
}

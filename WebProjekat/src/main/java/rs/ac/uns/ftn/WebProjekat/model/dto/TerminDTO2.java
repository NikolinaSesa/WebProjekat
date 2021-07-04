package rs.ac.uns.ftn.WebProjekat.model.dto;

import java.sql.Date;
import java.sql.Time;

public class TerminDTO2 {
    
    private Double cena;
    private Date datum;
    private Time vreme;

    public Double getCena(){return cena;}
    public void setCena(Double cena){this.cena=cena;}

    public Date getDatum(){return datum;}
    public void setDatum(Date datum){this.datum=datum;}

    public Time getVreme(){return vreme;}
    public void setVreme(Time vreme){this.vreme=vreme;}


}

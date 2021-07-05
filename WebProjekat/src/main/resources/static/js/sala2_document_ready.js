//Pregled postojecih podataka za salu
$(document).ready(function(){

    let salaId=localStorage.getItem("salaId");
    let id=localStorage.getItem("korisnikId");
    let uloga=localStorage.getItem("uloga");

    $.ajax({
        type:"GET",
        url:"http://localhost:8080/api/sala/"+salaId+"/"+id+"/"+uloga,
        dataType:"json",
        success:function(response){
            console.log("SUCCESS:\n", response);

            document.getElementById("oznaka").defaultValue=response.oznaka;
            document.getElementById("kapacitet").defaultValue=response.kapacitet;

        },
        error:function(response){
            console.log("ERROR:\n", response);
        }
    });
});

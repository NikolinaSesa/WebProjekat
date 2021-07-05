$(document).ready(function(){

    let fitnesscentarId=localStorage.getItem("fitnesscentarId");

    $.ajax({
        type:"GET",
        url:"http://localhost:8080/api/fitnesscentar/id/"+fitnesscentarId,
        dataType:"json",
        success:function(response){
            console.log("SUCCESS:\n", response);

            document.getElementById("naziv").defaultValue=response.naziv;
            document.getElementById("adresa").defaultValue=response.adresa;
            document.getElementById("broj").defaultValue=response.brTelefona;
            document.getElementById("email").defaultValue=response.email;
        },
        error:function(response){
            console.log("ERROR:\n", response);
        }
    });
});
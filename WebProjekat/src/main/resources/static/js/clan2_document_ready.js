$(document).ready(function(){

    let id=localStorage.getItem("korisnikId");
    let uloga=localStorage.getItem("uloga");

    $.ajax({
         type:"GET",
         url:"http://localhost:8080/api/clan/id/"+id+"/"+uloga,
         dataType:"json",
         success:function(response){
             console.log("SUCCESS:\n", response);

             document.getElementById("korisnickoIme").defaultValue=response.korisnickoIme;
             document.getElementById("lozinka").defaultValue=response.lozinka;
             document.getElementById("ime").defaultValue=response.ime;
             document.getElementById("prezime").defaultValue=response.prezime;
             document.getElementById("broj").defaultValue=response.brTelefona;
             document.getElementById("email").defaultValue=response.email;
             document.getElementById("datum").defaultValue=response.datumRodjenja;

         },
         error:function(response){
             console.log("ERROR:\n", response);
         }
    });
});
//dodavanje fitness centar
//moze da radi samo admin
$(document).on("submit", "#dodajFC", function(event){
    event.preventDefault();

    let naziv = $("#naziv").val();
    let adresa = $("#adresa").val();
    let broj = $("#broj").val();
    let email = $("#email").val();

    let noviFC = {
        naziv,
        adresa,
        broj,
        email
    }

    let id=localStorage.getItem("korisnikId");
    let uloga=localStorage.getItem("uloga");

    $.ajax({
        type:"POST",
        url:"http://localhost:8080/api/fitnesscentar/dodaj/"+id+"/"+uloga,
        dataType:"json",
        contentType:"application/json",
        data: JSON.stringify(noviFC),
        success:function(response){
            console.log(response);
            alert("Fitnesscentar "+response.id+" je uspesno kreiran!");

            window.location.href="adminFunkcije.html";
        },
        error:function(response){
            console.log(response);
            alert("Greska prilikom kreiranja fitnesscentra!");
        }
    });
});

//izmena fitnesscentra
$(document).on("submit", "#izmeniFC", function(event){
    event.preventDefault();

    let fitnesscentarId=localStorage.getItem("fitnesscentarId");
    let naziv = $("#naziv").val();
    let adresa = $("#adresa").val();
    let brTelefona = $("#broj").val();
    let email = $("#email").val();

    let updateFitnesscentar={
        naziv,
        adresa,
        brTelefona,
        email
    }

    $.ajax({
        type:"PUT",
        url:"http://localhost:8080/api/fitnesscentar/izmeni/"+fitnesscentarId,
        dataType:"json",
        contentType:"application/json",
        data: JSON.stringify(updateFitnesscentar),
        success:function(response){
            console.log("SUCCESS:\n", response);
            alert("Uspesno ste izmenili podatke!");
            window.location.href="Fitnesscentar.html";
        },
        error:function(response){
            console.log("ERROR:\n", response);
            alert("Greska prilikom izmene podataka!");
        }
    });
});
//dodavanje sale
//samo admin
$(document).on("submit", "#dodajSalu", function(event){
    event.preventDefault();

    let oznaka=$("#oznaka").val();
    let kapacitet=$("#kapacitet").val();

    let novaSala={
        oznaka,
        kapacitet
    }

    let fitnesscentarId=localStorage.getItem("fitnesscentarId");
    let id=localStorage.getItem("korisnikId");
    let uloga=localStorage.getItem("uloga");

    $.ajax({
        type:"POST",
        url:"http://localhost:8080/api/sala/dodaj/"+id+"/"+uloga+"/"+fitnesscentarId,
        dataType:"json",
        contentType:"application/json",
        data: JSON.stringify(novaSala),
        success:function(response){
            console.log(response)
            alert("Sala "+response.id+" je uspesno dodata!");
            window.location.href="Sale.html";
        },
        error:function(response){
            console.log(response);
            alert("Greska prilikom dodavanja sale!");
        }
    });
});

//brisanje sale
//samo admin
$(document).on('click', '.obrisi', function(){
    let salaId=this.dataset.id;
    let id=localStorage.getItem("korisnikId");
    let uloga=localStorage.getItem("uloga");

    $.ajax({
        type:"DELETE",
        url:"http://localhost:8080/api/sala/obrisi/"+salaId+"/"+id+"/"+uloga,
        dataType:"json",
        success:function(){
            console.log("SUCCESS");
            $('[data-id="'+salaId+'"]').parent().parent().remove();
        },
        error:function(){
            alert("Neuspesno brisanje sale!");
        }
    });
});

//izmena sale
//samo admin
$(document).on('click', '.izmeni', function(){
    let salaId=this.dataset.id;
    localStorage.setItem("salaId", salaId);
    window.location.href="Izmena_sale.html";
});

$(document).on("submit", "#izmeniSalu", function(event){
    event.preventDefault();

    let salaId=localStorage.getItem("salaId");
    let id=localStorage.getItem("korisnikId");
    let uloga=localStorage.getItem("uloga");
    let fitnesscentarId=localStorage.getItem("fitnesscentarId");

    let oznaka=$("#oznaka").val();
    let kapacitet=$("#kapacitet").val();

    let updateSala={
        oznaka,
        kapacitet
    }

    $.ajax({
        type:"PUT",
        url:"http://localhost:8080/api/sala/izmeni/"+salaId+"/"+id+"/"+uloga+"/"+fitnesscentarId,
        dataType:"json",
        contentType:"application/json",
        data: JSON.stringify(updateSala),
        success:function(response){
            console.log("SUCCESS:\n", response);
            alert("Uspesno ste izmenili podatke!");
            window.location.href="Sale.html";
        },
        error:function(response){
            console.log("ERROR:\n", response);
            alert("Greska prilikom izmene podataka!")
        }
    });
});


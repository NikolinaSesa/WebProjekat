//registracija clana
$(document).on("submit", "#regKorisnika", function(event){
    event.preventDefault();

    let ime=$("#ime").val();
    let prezime=$("#prezime").val();
    let korisnickoIme=$("#korisnickoIme").val();
    let email=$("#email").val();
    let lozinka=$("#lozinka").val();
    let datumRodjenja=$("#datum").val();
    let brTelefona=$("#broj").val();

    let newClan = {
        korisnickoIme,
        lozinka,
        ime,
        prezime,
        brTelefona,
        email,
        datumRodjenja
    }

    $.ajax({
        type:"POST",
        url:"http://localhost:8080/api/clan",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(newClan),
        success:function(response){
            console.log(response);

            alert("Hvala na registraciji!");

            window.location.href="Login_korisnika.html";
        },
        error:function(){
            alert("Greska prilikom registracije!");
        }
    });
});

//pregled profila
$(document).on('click', '.btnSeeMore', function(){
    let fitnesscentriDiv=$("#fitnesscentri");
    fitnesscentriDiv.hide();

    let clanId=localStorage.getItem("korisnikId");

    $.ajax({
        type:"GET",
        url:"http://localhost:8080/api/clan/id/"+clanId,
        dataType:"json",
        success:function(response){
            console.log("SUCCESS:\n", response);

            $('#ime').text(response.ime);
            $('#prezime').text(response.prezime);
            $('#korisnickoIme').text(response.korisnickoIme);
            $('#lozinka').text(response.lozinka);
            $('#email').text(response.email);
            $('#broj').text(response.brTelefona);
            $('#datum').text(response.datumRodjenja);

            let clanDiv=$('#Profil');
            clanDiv.show();
        },
        error:function(response){
            console.log("ERROR:\n", response);
            alert("Niste prijavljeni!");
        }
    });
});

//Pregled svih treninga u ponudi
$(document).on('click', '.treninzi', function(){
    let fitnesscentarId=this.dataset.id;
    localStorage.setItem("fitnesscentarId", fitnesscentarId);

    window.location.href="Pregled_treninga.html";
});

//Prijava za termin
$(document).on('click', '.prijava', function(){
    
    let korisnikId=localStorage.getItem("korisnikId");
    let uloga=localStorage.getItem("uloga");
    let terminId=this.dataset.id;
    localStorage.setItem("terminId", terminId);

    $.ajax({
        type:"GET",
        url:"http://localhost:8080/api/termin/prijava/"+korisnikId+"/"+uloga+"/"+terminId,
        dataType:"json",
        success:function(response){
           console.log("SUCCESS:\n", response);
           alert("Uspesno ste se prijavili za zeljeni termin!");
        },
        error:function(response){
            console.log("ERROR:\n", response);
            alert("Greska prilikom prijave! Svi termini su zauzeti!");
        }

    });
});

//Prikaz liste prijava za termine
$(document).on('click', '.prijavljeni', function(){
    let fitnesscentarId=this.dataset.id;
    localStorage.setItem("fitnesscentarId", fitnesscentarId);

    window.location.href="Pregled_prijava_za_termine.html";
});

//Otkazivanje prijave za termin
$(document).on('click', '.odjava', function(){
    let terminId=this.dataset.id;
    let id=localStorage.getItem("korisnikId");
    let uloga=localStorage.getItem("uloga");

    $.ajax({
        type:"GET",
        url:"http://localhost:8080/api/termin/otkazi/"+id+"/"+uloga+"/"+terminId,
        dataType:"json",
        success:function(response){
            console.log("SUCCESS:\n", response);
            alert("Uspesno ste otkazali prijavu za dati termin!");
            $('[data-id="'+terminId+'"]').parent().parent().remove();
        },
        error:function(response){
            console.log("ERROR:\n", response);
            alert("Greska prilikom otkazivanja termina!");
        }
    });
});
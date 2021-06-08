//prikaz dodatnih informacija o svakom treneru iz zahteva
//samo admin
$(document).on('click', '.btnSeeMore', function(){
    let treneriDiv = $('#treneri');
    treneriDiv.hide();

    let trenerId = this.dataset.id;

    $.ajax({
        type:"GET",
        url:"http://localhost:8080/api/trener/id/"+trenerId,
        dataType:"json",
        success:function(response){
            console.log("SUCCESS:\n", response);

            $('#ime').text(response.ime);
            $('#prezime').text(response.prezime);
            $('#korisnickoIme').text(response.korisnickoIme);
            $('#email').text(response.email);
            $('#broj').text(response.brTelefona);
            $('#datum').text(response.datumRodjenja);

            let trenerDiv = $('#InfoTrener');
            trenerDiv.show();
        },
        error:function(response){
            console.log("ERROR:\n", response);
            alert("Niste prijavljeni!");
        }
    });
});

//odobravanje zahteva treneru
$(document).on('click','.btnOdobri', function(){
    let trenerId = this.dataset.id;
    
    $.ajax({
        type:"PUT",
        url:"http://localhost:8080/api/trener/put/"+trenerId,
        dataType:"json",
        contentType:"application/json",
        data: JSON.stringify({"aktivan":true}),
        success:function(response){
            console.log("SUCCESS:\n", response);
            $('[data-id="'+trenerId+'"]').parent().parent().remove();
        },
        error:function(response){
            console.log("ERROR:\n", response);
        }
    });
});

//odbijanje zahteva treneru
$(document).on('click','.btnOdbi', function(){
    let trenerId = this.dataset.id;

    $.ajax({
        type:"DELETE",
        url:"http://localhost:8080/api/trener/delete/"+trenerId,
        dataType:"json",
        success:function(){
            console.log("SUCCESS");
            $('[data-id="'+trenerId+'"]').parent().parent().remove();
        },
        error:function(){
            alert("ERROR");
        }
    });
});

//registracija novog trenera i prikaz u tabeli zahteva
$(document).on("submit", "#regTrenera", function(event){
    event.preventDefault();

    let ime = $("#ime").val();
    let prezime = $("#prezime").val();
    let korisnickoIme = $("#korisnickoIme").val();
    let email = $("#email").val();
    let lozinka = $("#lozinka").val();
    let datumRodjenja = $("#datum").val()
    let brTelefona = $("#telefon").val();

    let newTrener = {
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
        url:"http://localhost:8080/api/trener/dodaj",
        dataType:"json",
        contentType:"application/json",
        data: JSON.stringify(newTrener),
        success:function(response){
            console.log(response);

            alert("Hvala na registraciji! Molim Vas sacekajte da vas zahtev bude obradjen!");

            window.location.href="Login_korisnika.html";
        },
        error:function(response){
            console.log("ERROR:\n", response);
            alert("Greska prilikom registracije!\nKorisnicko ime vec postoji!");
        }
    });
});

//registracija trenera od strane administratora 
$(document).on("submit", "#adminRegTrenera", function(event){
    event.preventDefault();

    let ime = $("#ime").val();
    let prezime = $("#prezime").val();
    let korisnickoIme = $("#korisnickoIme").val();
    let email = $("#email").val();
    let lozinka = $("#lozinka").val();
    let datumRodjenja = $("#datum").val()
    let brTelefona = $("#telefon").val();
    let fitnesscentarId=localStorage.getItem("fitnesscentarId")

        let newTrener = {
            korisnickoIme,
            lozinka,
            ime,
            prezime,
            brTelefona,
            email,
            datumRodjenja,
        }
        
        $.ajax({
            type:"POST",
            url:"http://localhost:8080/api/trener/dodajKaoAdmin/"+fitnesscentarId,
            dataType:"json",
            contentType:"application/json",
            data: JSON.stringify(newTrener),
            success:function(response){
                console.log(response);
                    
                alert("Uspesno registrovan novi trener!");
                
                window.location.href="Fitnesscentar.html";
            },
            error:function(response){
                console.log("ERROR:\n", response);
                alert("Greska prilikom registracije!\nKorisnicko ime vec postoji!");

            }   
    });  
});

//uklanjanje trenera od strane administratora
$(document).on('click','.btnObrisi', function(){
    let trenerId = this.dataset.id;

    $.ajax({
        type:"DELETE",
        url:"http://localhost:8080/api/trener/delete/"+trenerId,
        dataType:"json",
        success:function(){
            console.log("SUCCESS");
            $('[data-id="'+trenerId+'"]').parent().parent().remove();
        },
        error:function(){
            alert("ERROR");
        }
    });
});
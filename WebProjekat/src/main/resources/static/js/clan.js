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
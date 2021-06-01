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

    $.ajax({
        type:"POST",
        url:"http://localhost:8080/api/fitnesscentar/dodaj",
        dataType:"json",
        contentType:"application/json",
        data: JSON.stringify(noviFC),
        success:function(response){
            console.log(response);
            alert("Fitnesscentar "+response.id+" je uspesno kreiran!");

            window.location.href="admin_funkcije.html";
        },
        error:function(response){
            console.log(response);
            alert("Greska prilikom kreiranja fitnesscentra!");
        }
    });
});
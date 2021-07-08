$(document).on('click', '.btn1', function(){

    let uloga=localStorage.getItem("uloga");
    if(uloga=="CLAN"){
        let id = 1;
        localStorage.setItem("sortId", id);
        window.location.href="Prijava_za_termine.html";
    }
    else{
        let id = 1;
        localStorage.setItem("sortId", id);
        window.location.href="Termini.html";
    }

});

$(document).on('click', '.btn2', function(){

    let uloga=localStorage.getItem("uloga");
    if(uloga=="CLAN"){
        let id = 2;
        localStorage.setItem("sortId", id);
        window.location.href="Prijava_za_termine.html";
    }
    else{
        let id = 2;
        localStorage.setItem("sortId", id);
        window.location.href="Termini.html";
    }

});

$(document).on('click', '.btn3', function(){

    let uloga=localStorage.getItem("uloga");
    if(uloga=="CLAN"){
        let id = 3;
        localStorage.setItem("sortId", id);
        window.location.href="Prijava_za_termine.html";
    }
    else{
        let id = 3;
        localStorage.setItem("sortId", id);
        window.location.href="Termini.html";
    }

});

$(document).on('click', '.btn4', function(){

    let uloga=localStorage.getItem("uloga");
    if(uloga=="CLAN"){
        let id = 4;
        localStorage.setItem("sortId", id);
        window.location.href="Prijava_za_termine.html";
    }
    else{
        let id = 4;
        localStorage.setItem("sortId", id);
        window.location.href="Termini.html";
    }

});

$(document).on('click', '.btn5', function(){

    let naziv=$("#naziv").val();
    localStorage.setItem("naziv", naziv);
    let tip=$("#tip").val();
    localStorage.setItem("tip", tip);
    let opis=$("#opis").val();
    localStorage.setItem("opis", opis);
    let cena=$("#cena").val();
    localStorage.setItem("cena", cena);
    let vreme=$("#vreme").val();
    localStorage.setItem("vreme", vreme);

    let uloga=localStorage.getItem("uloga");
    if(uloga=="CLAN"){
        let id = 5;
        localStorage.setItem("sortId", id);
        window.location.href="Prijava_za_termine.html";
    }
    else{
        let id = 5;
        localStorage.setItem("sortId", id);
        window.location.href="Termini.html";
    }
});

$(document).on("submit", "#dodajTrening", function(event){
    event.preventDefault();

    let id=localStorage.getItem("korisnikId");
    let uloga=localStorage.getItem("uloga");

    let naziv=$("#nazivTreninga").val();
    let tip=$("#tip").val();
    let opis=$("#opis").val();
    let trajanje=$("#trajanje").val();

    let newTrening={
        naziv,
        tip,
        opis,
        trajanje
    }

    $.ajax({
        type:"POST",
        url:"http://localhost:8080/api/treninzi/dodajNoviTrening/"+id+"/"+uloga,
        dataType:"json",
        contentType:"application/json",
        data: JSON.stringify(newTrening),
        success:function(response){
            console.log("SUCCESS:\n", response);
            alert("Uspesno ste kreirali novi trening!");
            window.location.href="Trener_pregled_treninga.html";
        },
        error:function(response){
            console.log("ERROR:\n", response);
            alert("Greska prilikom kreiranja novog treninga!");
        }
    });
});
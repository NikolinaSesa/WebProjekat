$(document).on('click', '.btn1', function(){

    let id = 1;
    localStorage.setItem("sortId", id);
    window.location.href="Termini.html";

});

$(document).on('click', '.btn2', function(){

    let id=2;
    localStorage.setItem("sortId", id);
    window.location.href="Termini.html";

});

$(document).on('click', '.btn3', function(){

    let id=3;
    localStorage.setItem("sortId", id);
    window.location.href="Termini.html";

});

$(document).on('click', '.btn4', function(){

    let id=4;
    localStorage.setItem("sortId", id);
    window.location.href="Termini.html";

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

    let id=5;
    localStorage.setItem("sortId", id);
    window.location.href="Termini.html";
});
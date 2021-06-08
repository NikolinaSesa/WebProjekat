$(document).on('click', '.btnSeeMore', function(){

    let fitnesscentarId = this.dataset.id;
    localStorage.setItem("fitnesscentarId", fitnesscentarId);

    window.location.href="Fitnesscentar.html";

});
//ZA KRAJNJU ODBRANU
/*
$(document).on(function(){

    let id=localStorage.getItem("fitnesscentarId");

    $.ajax({
        type:"DELETE",
        url:"http://localhost:8080/api/fitnesscentar/obrisi/"+id,
        dataType:"json",
        success:function(){
            console.log("SUCCESS");
            localStorage.removeItem("fitnesscentarId");
            alert("Fitness Centar je uklonjen");
        },
        error:function(){
            alert("Neuspesno uklanjanje Fitness Centra!");
        }
    });
});
*/
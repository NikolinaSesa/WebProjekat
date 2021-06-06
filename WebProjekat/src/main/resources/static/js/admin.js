$(document).on('click', '.btnSeeMore', function(){

    let fitnesscentarId = this.dataset.id;
    localStorage.setItem("fitnesscentarId", fitnesscentarId);

    window.location.href="Fitnesscentar.html";

});

$(document).on('click', '.obrisi', function(){

    let id=localStorage.getItem("fitnesscentarId");

    $.ajax({
        type:"DELETE",
        url:"http://localhost:8080/api/fitnesscentar/obrisi/"+id,
        dataType:"json",
        success:function(response){
            console.log("SUCCESS:\n", response);
            alert("Fitness Centar je uklonjen");
            console.log(response.naziv);
            window.location.href="adminFunkcije.html";
        },
        error:function(){
            alert("Neuspesno uklanjanje Fitness Centra!");
        }
    });
});

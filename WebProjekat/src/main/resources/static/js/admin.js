$(document).on('click', '.btnSeeMore', function(){

    let fitnesscentarId = this.dataset.id;
    localStorage.setItem("fitnesscentarId", fitnesscentarId);

    window.location.href="Fitnesscentar.html";

});
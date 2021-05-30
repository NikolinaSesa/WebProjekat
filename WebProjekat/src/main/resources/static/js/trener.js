//prikaz dodatnih informacija o svakom treneru iz zahteva
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
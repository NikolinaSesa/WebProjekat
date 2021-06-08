//pregled svi trenera 
//SAMO ZA ADMINA
$(document).ready(function(){

    let id=localStorage.getItem("korisnikId");
    let uloga=localStorage.getItem("uloga");

    $.ajax({
        type:"GET",
        url:"http://localhost:8080/api/fitnesscentar/svi/"+id+"/"+uloga,
        dataType:"json",
        success:function(response){
            console.log("SUCCESS:\n", response);

            for(let fitnesscentar of response){
                let row="<tr>";
                row+="<td>"+fitnesscentar.naziv+"</td>";
                let btn="<button class='btnSeeMore' data-id="+fitnesscentar.id+">Detalji</button>";
                row+="<td>"+btn+"</td>";
                row+="</tr>";

                $('#sviFitnesscentri').append(row);
            }
        },
        error:function(response){
            console.log("ERROR:\n", response);
            alert("Niste prijavljeni!");
            window.location.href="Login_korisnika.html";
        }
    });
});


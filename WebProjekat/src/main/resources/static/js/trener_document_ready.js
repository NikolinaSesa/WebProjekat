$(document).ready(function(){
    // ajax poziv za dobavljanje svih trenera ciji zahtevi nisu odobreni
    let fitnesscentarId = localStorage.getItem("fitnesscentarId");
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/api/trener/aktivan/fcid/false/"+fitnesscentarId,
        dataType:"json",
        success:function(response){
            console.log("SUCCESS:\n", response);

            for(let trener of response){
                let row="<tr>";
                row+="<td>"+trener.ime+"</td>";
                row+="<td>"+trener.prezime+"</td>";
                let btn="<button class='btnSeeMore' data-id="+trener.id+">Ostali Podaci</button>";
                row+="<td>"+btn+"</td>";
                btn="<button class='btnOdobri' data-id="+trener.id+">ODOBRI</button>";
                row+="<td>"+btn+"</td>";
                btn="<button class='btnOdbi' data-id="+trener.id+">ODBI</button>";
                row+="<td>"+btn+"</td>";
                row+="</tr>";

                $('#zahtevi').append(row);
            }
        },
        error:function(response){
            console.log("ERROR:\n",response);
        }
    });
});
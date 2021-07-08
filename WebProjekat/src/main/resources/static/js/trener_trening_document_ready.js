$(document).ready(function(){

    let id=localStorage.getItem("korisnikId");
    let uloga=localStorage.getItem("uloga");

    $.ajax({
        type:"GET",
        url:"http://localhost:8080/api/treninzi/trenerPregledTreninga/"+id+"/"+uloga,
        dataType:"json",
        success:function(response){
            console.log("SUCCESS:\n", response);

            for(let trening of response){
                let row="<tr>";
                row+="<td>"+trening.naziv+"</td>";
                row+="<td>"+trening.tip+"</td>";
                row+="<td>"+trening.opis+"</td>";
                row+="<td>"+trening.trajanje+"</td>";
                row+="<td>"+trening.imeTrenera+"</td>";
                row+="<td>"+trening.prezimeTrenera+"</td>";
                row+="</tr>";

                $("#sviTreninzi").append(row);
            }
        },
        error:function(response){
            console.log("ERROR:\n", response);
        }
    });
});
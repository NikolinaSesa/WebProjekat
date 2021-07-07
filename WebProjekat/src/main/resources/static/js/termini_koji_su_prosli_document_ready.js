$(document).ready(function(){

    let id=localStorage.getItem("korisnikId");
    let uloga=localStorage.getItem("uloga");

    $.ajax({
        type:"GET",
        url:"http://localhost:8080/api/termin/terminiTrenerId/"+id+"/"+uloga,
        dataType:"json",
        success:function(response){
            console.log("SUCCESS:\n", response);

            for(let termin of response){
                let row="<tr>";
                row+="<td>"+termin.naziv+"</td>";
                row+="<td>"+termin.tipTreninga+"</td>";
                row+="<td>"+termin.opis+"</td>";
                row+="<td>"+termin.cena+"</td>";
                row+="<td>"+termin.datum+"</td>";
                row+="<td>"+termin.vreme+"</td>";
                row+="<td>"+termin.imeTrenera+"</td>";
                row+="<td>"+termin.prezimeTrenera+"</td>";
                let btn="<button class='clanovi' data-id="+termin.id+">Prijavljeni clanovi</button>";
                row+="<td>"+btn+"</td>";
                row+="</tr>";

                $('#sviTermini').append(row);
            }
        },
        error:function(response){
            console.log("ERROR:\n", response);
        }
    });
});
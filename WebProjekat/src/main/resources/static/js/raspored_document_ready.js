$(document).ready(function(){

    let id=localStorage.getItem("korisnikId");
    let uloga=localStorage.getItem("uloga");

    $.ajax({
        type:"GET",
        url:"http://localhost:8080/api/termin/raspored/"+id+"/"+uloga,
        dataType:"json",
        success:function(response){
            console.log("SUCCESS:\n", response);

            for(termin of response){
                let row="<tr>";
                row+="<td>"+termin.naziv+"</td>";
                row+="<td>"+termin.tipTreninga+"</td>";
                row+="<td>"+termin.opis+"</td>";
                row+="<td>"+termin.cena+"</td>";
                row+="<td>"+termin.datum+"</td>";
                row+="<td>"+termin.vreme+"</td>";
                row+="<td>"+termin.oznakaSale+"</td>";
                row+="<td>"+termin.imeTrenera+"</td>";
                row+="<td>"+termin.prezimeTrenera+"</td>";
                let btn="<button class='obrisi' data-id="+termin.id+">Ukloni iz rasporeda</button>";
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

$(document).on('click', '.obrisi', function(){
    let terminId=this.dataset.id;
    let id=localStorage.getItem("korisnikId");
    let uloga=localStorage.getItem("uloga");

    $.ajax({
        type:"DELETE",
        url:"http://localhost:8080/api/termin/delete/"+id+"/"+uloga+"/"+terminId,
        dataType:"json",
        success:function(){
            console.log("SUCCESS");
            $('[data-id="'+terminId+'"]').parent().parent().remove();
        },
        error:function(){
            console.log("ERROR");
        }
    });
});
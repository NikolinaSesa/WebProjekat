$(document).ready(function(){

    let terminId=localStorage.getItem("terminId");
    let id=localStorage.getItem("korisnikId");
    let uloga=localStorage.getItem("uloga");

    $.ajax({
        type:"GET",
        url:"http://localhost:8080/api/clan/prijavljeniClanovi/"+id+"/"+uloga+"/"+terminId,
        dataType:"json",
        success:function(response){
            console.log("SUCCESS:\n", response);

            for(let clan of response){
                let row="<tr>";
                row+="<td>"+clan.ime+"</td>";
                row+="<td>"+clan.prezime+"</td>";
                row+="<td>"+clan.datumRodjenja+"</td>";
                row+="<td>"+clan.brTelefona+"</td>";
                row+="<td>"+clan.email+"</td>";
                let btn1="<button class='odradio' data-id="+clan.id+">ODRADIO</button>"
                row+="<td>"+btn1+"</td>";
                row+="</tr>";

                $("#sviClanovi").append(row);
            }
        },
        error:function(response){
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('click', '.odradio', function(){

    let id=localStorage.getItem("korisnikId");
    let uloga=localStorage.getItem("uloga");
    let terminId=localStorage.getItem("terminId");
    let clanId=this.dataset.id;

    $.ajax({
        type:"GET",
        url:"http://localhost:8080/api/termin/odradjenTermin/"+id+"/"+uloga+"/"+terminId+"/"+clanId,
        dataType:"json",
        success:function(response){
            console.log("SUCCESS:\n", response);
            alert("Clan "+clanId+" je odradio "+terminId+". termin!");
        },
        error:function(response){
            console.log(response);
        }
    });
});

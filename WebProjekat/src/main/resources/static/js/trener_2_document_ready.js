$(document).ready(function(){
    // ajax poziv za dobavljanje svih trenera u datom fitnesscentra
    //samo admin
    let fitnesscentarId = localStorage.getItem("fitnesscentarId");
    let id=localStorage.getItem("korisnikId");
    let uloga=localStorage.getItem("uloga");
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/api/trener/aktivan/fcid/true/"+fitnesscentarId+"/"+id+"/"+uloga,
        dataType:"json",
        success:function(response){
            console.log("SUCCESS:\n", response);

            for(let trener of response){
                let row="<tr>";
                row+="<td>"+trener.ime+"</td>";
                row+="<td>"+trener.prezime+"</td>";
                let btn="<button class='btnSeeMore' data-id="+trener.id+">Ostali Podaci</button>";
                row+="<td>"+btn+"</td>";
                btn="<button class='btnObrisi' data-id="+trener.id+">OBRISI</button>";
                row+="<td>"+btn+"</td>";
                row+="</tr>";

                $('#sviTreneri').append(row);
            }
        },
        error:function(response){
            console.log("ERROR:\n",response);
            alert("Niste prijavljeni!");
            window.location.href="Login_korisnika.html";
        }
    });
});
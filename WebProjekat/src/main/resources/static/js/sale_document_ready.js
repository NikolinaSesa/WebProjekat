//pregled svih sala u datom fitnesscentru
//SAMO ADMIN
$(document).ready(function(){

    let id=localStorage.getItem("korisnikId");
    let uloga=localStorage.getItem("uloga");
    let fitnesscentarId=localStorage.getItem("fitnesscentarId");

    $.ajax({
        type:"GET",
        url:"http://localhost:8080/api/sala/sve/"+fitnesscentarId+"/"+id+"/"+uloga,
        dataType:"json",
        success:function(response){
            console.log("SUCCESS:\n", response);

            for(let sala of response){
                let row="<tr>";
                row+="<td>"+sala.oznaka+"</td>";
                row+="<td>"+sala.kapacitet+"</td>";
                let btn1="<button class='izmeni' data-id="+sala.id+">Izmeni</button>";
                row+="<td>"+btn1+"</td>";
                let btn2="<button class='obrisi' data-id="+sala.id+">Obrisi</button>";
                row+="<td>"+btn2+"</td>";

                $('#sveSale').append(row);
            }
        },
        error:function(response){
            console.log("ERROR:\n", response);
            alert("Niste prijavljeni!");
            window.location.href="Login_korisnika.html";
        }
    });
});
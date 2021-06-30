//pocetna stranica clanu
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
                row+="<td>"+fitnesscentar.adresa+"</td>";
                row+="<td>"+fitnesscentar.brTelefona+"</td>";
                row+="<td>"+fitnesscentar.email+"</td>";
                let btn1="<button class='treninzi' data-id="+fitnesscentar.id+">Treninzi</button>";
                row+="<td>"+btn1+"</td>";
                let btn2="<button class='prijavljeni' data-id="+fitnesscentar.id+">Prijavljeni</button>";
                row+="<td>"+btn2+"</td>";
                let btn3="<button class='odradjeni' data-id="+fitnesscentar.id+">Odradjeni</button>";
                row+="<td>"+btn3+"</btn3>";
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

$(document).on('submit','#logIn', function(){

    let korisnickoime = $('#korisnickoIme').val();
    let lozinka = $('#lozinka').val();
    
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/api/clan/ki/"+korisnickoime,
        dataType:"json",
        success:function(response){
            console.log("SUCCESS:\n",response);
            
            if(lozinka == response.lozinka){
            localStorage.setItem("clanId", response.id);
            alert("Uspesno ste prijavljeni!");
            window.location.href="Clan_Pocetna_Strana.html";
            }
            else{
                alert("Pogresili ste lozinku!");
                window.location.href="Login_korisnika.html";
                }
        },
        error:function(){
            console.log("ERROR:\n");
            alert("Niste registrovani!");
            window.location.href="Login_korisnika.html";
        }
    });
});
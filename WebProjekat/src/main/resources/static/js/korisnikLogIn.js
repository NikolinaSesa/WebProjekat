$(document).on('submit','#logIn', function(event){

    event.preventDefault();

    let korisnickoime = $('#korisnickoIme').val();
    let lozinka = $('#lozinka').val();
    
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/api/clan/ki/"+korisnickoime,
        dataType:"json",
        success:function(response){
            console.log("SUCCESS:\n",response);
            if(lozinka == response.lozinka){
            localStorage.setItem("korisnikId", response.id);
            localStorage.setItem("uloga", response.uloga);
            alert("Uspesno ste prijavljeni!");
            window.location.href="Clan_Pocetna_Strana.html";
            }
            else{
                console.log("ERROR")
                alert("Pogresili ste lozinku!");
                }
        },
        error:function(){
            $.ajax({
                type:"GET",
                url:"http://localhost:8080/api/trener/ki/"+korisnickoime,
                dataType:"json",
                success:function(response){
                    console.log("SUCCESS: ", response);
                    if(lozinka == response.lozinka){
                        localStorage.setItem("korisnikId", response.id);
                        localStorage.setItem("uloga", response.uloga);
                        alert("Uspesno ste prijavljeni!");
                        window.location.href="Trener_Pocetna_Strana.html";
                    }
                    else{
                        console.log("ERROR")
                        alert("Pogresili ste lozinku!");
                    }
                },
                error:function(){
                    $.ajax({
                        type:"GET",
                        url:"http://localhost:8080/api/admin/ki/"+korisnickoime,
                        dataType:"json",
                        success:function(response){
                            console.log("SUCCESS:\n",response);
                            if(lozinka == response.lozinka){
                                localStorage.setItem("korisnikId", response.id);
                                localStorage.setItem("uloga", response.uloga);
                                alert("Uspesno ste prijavljeni!");
                                window.location.href="adminFunkcije.html";
                            }
                            else{
                                console.log("ERROR")
                                alert("Pogresili ste lozinku!");
                            }
                        },
                        error:function(){
                            console.log("ERROR");
                            alert("Niste registrovani!");
                            window.location.href="Login_korisnika.html";
                        }
                    });
                }
            });
        }
    });
});
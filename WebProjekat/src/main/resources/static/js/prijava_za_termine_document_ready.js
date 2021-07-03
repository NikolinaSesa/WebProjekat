$(document).ready(function(){

    let id=localStorage.getItem("sortId");
    let fitnesscentarId=localStorage.getItem("fitnesscentarId");

    switch(id){
        case '1':
            $.ajax({
                type:"GET",
                url:"http://localhost:8080/api/termin/sort/rastuce/cena/"+fitnesscentarId,
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
                           let btn="<button class='prijava' data-id="+termin.id+">Prijavi se</button>";
                           row+="<td>"+btn+"</td>";
                           row+="</tr>";
           
                           $('#sviTermini').append(row);
                       }
                },
                error:function(response){
                     console.log("ERROR:\n", response);
                }
           });
           break;
        case '2':
            $.ajax({
                type:"GET",
                url:"http://localhost:8080/api/termin/sort/opadajuce/cena/"+fitnesscentarId,
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
                           let btn="<button class='prijava' data-id="+termin.id+">Prijavi se</button>";
                           row+="<td>"+btn+"</td>";
                           row+="</tr>";
           
                           $('#sviTermini').append(row);
                       }
                },
                error:function(response){
                     console.log("ERROR:\n", response);
                }
           });
           break;
        case '3':
            $.ajax({
                type:"GET",
                url:"http://localhost:8080/api/termin/sort/rastuce/vreme/"+fitnesscentarId,
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
                           let btn="<button class='prijava' data-id="+termin.id+">Prijavi se</button>";
                           row+="<td>"+btn+"</td>";
                           row+="</tr>";
           
                           $('#sviTermini').append(row);
                       }
                },
                error:function(response){
                     console.log("ERROR:\n", response);
                }
           });
           break;
        case '4':
            $.ajax({
                type:"GET",
                url:"http://localhost:8080/api/termin/sort/opadajuce/vreme/"+fitnesscentarId,
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
                           let btn="<button class='prijava' data-id="+termin.id+">Prijavi se</button>";
                           row+="<td>"+btn+"</td>";
                           row+="</tr>";
           
                           $('#sviTermini').append(row);
                       }
                },
                error:function(response){
                     console.log("ERROR:\n", response);
                }
           });
           break;
        case '5':
            let naziv=localStorage.getItem("naziv");
            if(naziv!=null){
            $.ajax({
                type:"GET",
                url:"http://localhost:8080/api/termin/naziv/"+naziv,
                dataType:"json",
                success:function(response){
                    console.log("SUCCESS: ", response);

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
                        let btn="<button class='prijava' data-id="+termin.id+">Prijavi se</button>";
                        row+="<td>"+btn+"</td>";
                        row+="</tr>";
        
                        $('#sviTermini').append(row);
                    }
                },
                error:function(response){
                    console.log("ERROR: ", response);
                }
            });
        }
            let tip=localStorage.getItem("tip");
            if(tip!=null){
            $.ajax({
                type:"GET",
                url:"http://localhost:8080/api/termin/tip/"+tip,
                dataType:"json",
                success:function(response){
                    console.log("SUCCESS: ", response);

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
                        let btn="<button class='prijava' data-id="+termin.id+">Prijavi se</button>";
                        row+="<td>"+btn+"</td>";
                        row+="</tr>";
        
                        $('#sviTermini').append(row);
                    }
                },
                error:function(response){
                    console.log("ERROR: ", response);
                }
            });
        }
            let cena=localStorage.getItem("cena");
            if(cena!=null){
                $.ajax({
                    type:"GET",
                    url:"http://localhost:8080/api/termin/cena/"+cena,
                    dataType:"json",
                    success:function(response){
                        console.log("SUCCESS: ", response);
    
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
                            let btn="<button class='prijava' data-id="+termin.id+">Prijavi se</button>";
                            row+="<td>"+btn+"</td>";
                            row+="</tr>";
            
                            $('#sviTermini').append(row);
                        }
                    },
                    error:function(response){
                        console.log("ERROR: ", response);
                    }
                });
            }
            let opis=localStorage.getItem("opis");
            if(opis!=null){
                $.ajax({
                    type:"GET",
                    url:"http://localhost:8080/api/termin/opis/"+opis,
                    dataType:"json",
                    success:function(response){
                        console.log("SUCCESS: ", response);
    
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
                            let btn="<button class='prijava' data-id="+termin.id+">Prijavi se</button>";
                            row+="<td>"+btn+"</td>";
                            row+="</tr>";
            
                            $('#sviTermini').append(row);
                        }
                    },
                    error:function(response){
                        console.log("ERROR: ", response);
                    }
                });
            }
            let vreme=localStorage.getItem("vreme");
            if(vreme!=null){
                $.ajax({
                    type:"GET",
                    url:"http://localhost:8080/api/termin/vreme/"+vreme,
                    dataType:"json",
                    success:function(response){
                        console.log("SUCCESS: ", response);
    
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
                            let btn="<button class='prijava' data-id="+termin.id+">Prijavi se</button>";
                            row+="<td>"+btn+"</td>";
                            row+="</tr>";
            
                            $('#sviTermini').append(row);
                        }
                    },
                    error:function(response){
                        console.log("ERROR: ", response);
                    }
                });
            }
    }

});
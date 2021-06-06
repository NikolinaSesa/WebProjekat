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
                           row+="<td>"+termin.vreme+"</td>";
                           row+="<td>"+termin.imeTrenera+"</td>";
                           row+="<td>"+termin.prezimeTrenera+"</td>";
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
                           row+="<td>"+termin.vreme+"</td>";
                           row+="<td>"+termin.imeTrenera+"</td>";
                           row+="<td>"+termin.prezimeTrenera+"</td>";
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
                           row+="<td>"+termin.vreme+"</td>";
                           row+="<td>"+termin.imeTrenera+"</td>";
                           row+="<td>"+termin.prezimeTrenera+"</td>";
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
                           row+="<td>"+termin.vreme+"</td>";
                           row+="<td>"+termin.imeTrenera+"</td>";
                           row+="<td>"+termin.prezimeTrenera+"</td>";
                           row+="</tr>";
           
                           $('#sviTermini').append(row);
                       }
                },
                error:function(response){
                     console.log("ERROR:\n", response);
                }
           });
    }

});
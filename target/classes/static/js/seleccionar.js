let appdata = document.getElementById("appdata");
appdata.innerHTML = '<div class="recuadro" id="educacion"></div>';
axios.get("/api/persons").then(
    json => {
        let datos = json.data._embedded.persons;
        // console.log(datos);
        let educacion = document.getElementById("educacion");
        educacion.innerHTML += '<span class="recuadro__titulo"> Seleccione perfil: </span>';
        for (persona of datos) {
            console.log("cargando "+persona.nombre);
            educacion.innerHTML += ''
            +'<div class="recuadro__item">'
            +'  <img src="img/silueta.png" alt="'+persona.id+'" class="recuadro__item-img" id="foto'+persona.id+'">'

            +'    <div class="recuadro__item-datos">'
            +'        <b>'+persona.nombre+'</b><br>'
            +'          <form action="index.html"><input type="hidden" name="id" value="'+persona.id+'"><button type="submit" action="">IR AL PERFIL</button></form>'
            +'    </div>'
            +'</div>'
        }
        educacion.innerHTML += '</div>';
    }
)
const queryString = window.location.search;
const urlParametros = new URLSearchParams(queryString);
const id = urlParametros.get("id");

console.log("El id recibido es "+id)


axios.get("http://localhost:8080/api/persons/"+id).then(
    json => {
        let datos = json.data;
        document.getElementById("nombre").innerHTML = datos.nombre;
        document.getElementById("nombrebanner").innerHTML = datos.nombre;
    }
)

axios.get("http://localhost:8080/api/contacts/search/findByPersonaId?id="+id).then(
    json => {
        if (json.data._embedded.contacts[0] != null) {
            datos = json.data._embedded.contacts[0];
            console.log(datos);
            document.getElementById("profesion").innerHTML = datos.profesion;
            document.querySelector(".banner__img").style.backgroundImage = "url('../img/"+datos.foto+"')";
        } else {console.log("Profesion no encontrada para el id"+id)} 
    }
)

const footer__botonera = document.querySelector(".nav__home");
footer__botonera.addEventListener("click", ()=> {
    location.reload()
})

const botonera__sobremi = document.getElementById("botonera__sobremi_link");
botonera__sobremi.addEventListener("click", ()=> {
    document.getElementById("paginacss").setAttribute("href", "css/sobremi.css");

    document.getElementById("appdata").innerHTML = '<div class="agrupados" id="sobremi"></div>'

    axios.get("http://localhost:8080/api/abouts/search/findByPersonaId?id="+id).then(
        json => {
            if (json.data._embedded.abouts[0] != null){
                let datos = json.data._embedded.abouts;
                console.log(datos);
                for (linea of datos) {
                    document.getElementById("appdata").innerHTML +=''
                        +'<div class="recuadro" id="acercaDe">'
                        +'    <span class="recuadro__titulo"> '+linea.titulo+' </span>'
                        +'    <p> '+linea.texto+' </p>'
                        +'</div>';
                    
                }
            }
        }
    )

})

const botonera__educacion = document.getElementById("botonera__educacion_link");
botonera__educacion.addEventListener("click", ()=> {
    document.getElementById("paginacss").setAttribute("href", "css/educacion.css");

    let appdata = document.getElementById("appdata");
    appdata.innerHTML = '<div class="recuadro" id="educacion"></div>';

    axios.get("http://localhost:8080/api/educations/search/findByPersonaId?id="+id).then(
        json => {
            if (json.data._embedded.educations[0] != null) {
                datos = json.data._embedded.educations;
                console.log(datos);
                let educacion = document.getElementById("educacion");
                educacion.innerHTML += '<span class="recuadro__titulo"> Educacion </span>';
                for (linea of datos) {
                educacion.innerHTML += ''
                +'<div class="recuadro__item">'
                +'    <img src="/img/'+linea.foto+'" alt="'+linea.foto+'" class="recuadro__item-img">'
                +'    <div class="recuadro__item-datos">'
                +'        <b>'+linea.titulo+'</b><br>'
                +'        '+linea.texto
                +'    </div>'
                +'</div>'
                }
            }
        }
    )
})

const botonera__proyectos = document.getElementById("botonera__proyectos_link");
botonera__proyectos.addEventListener("click", ()=> {
    document.getElementById("paginacss").setAttribute("href", "css/proyectos.css");

    let appdata = document.getElementById("appdata");
    appdata.innerHTML = '<div class="recuadro" id="proyectos"></div>'

    axios.get("http://localhost:8080/api/proyects/search/findByPersonaId?id="+id).then(
        json => {
            if (json.data._embedded.proyects != null) {
                let datos = json.data._embedded.proyects;
                console.log(datos);
                let educacion = document.getElementById("proyectos");
                proyectos.innerHTML += '<span class="recuadro__titulo"> Proyectos </span>';
                for (linea of datos) {
                    proyectos.innerHTML += ''
                    +'<div class="recuadro__item">'
                        +'<a href="'+linea.enlace+'" target="_blank"><img src="img/'+linea.foto+'" alt="imprentabuenosayres" class="recuadro__item-img"></a>'
                        +'<div class="recuadro__item-datos">'
                        +'    <b>'+linea.titulo+'</b><br>'
                        +'    '+linea.texto
                        +'</div>'
                    +'</div>'
                }
            }
        }
    )
})

const botonera__contacto = document.getElementById("botonera__contacto_link");
botonera__contacto.addEventListener("click", ()=> {
    let appdata = document.getElementById("appdata");
    appdata.innerHTML = `<object type="text/html" data="contacto.html"></object>`
})
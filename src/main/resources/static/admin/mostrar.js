let persons = document.getElementById("person")
persons.innerHTML="";

axios.get("/api/persons").then(
    json => {
        let datos = json.data._embedded.persons;
        // console.log("PERSONS: "+datos);
        persons.innerHTML += '<div class="container titulo"><div>ID</div><div>Nombre</div></div>'
        for (linea of datos) {
            persons.innerHTML += '<div class="container"><div>'+linea.id+'</div><div>'+linea.nombre+'</div><div class="basura"><a href="/basededatos/borrar/person/'+linea.id+'"><img src="/img/basura.png"></div></div>'
        }   
    }
)

let educations = document.getElementById("education")
educations.innerHTML="";

axios.get("/api/educations").then(
    json => {
        let datos = json.data._embedded.educations;
        // console.log(datos)
        educations.innerHTML += '<div class="container titulo"><div>Persona</div><div>Organismo</div><div>descripcion</div><div>foto</div></div>'
        for (linea of datos) {
                    educations.innerHTML += '<div class="container"><div>persona</div><div>'+linea.titulo+'</div> <div>'+linea.texto+'</div><div>'+linea.foto+'</div><div class="basura"><a href="/basededatos/borrar/education/'+linea.id+'"><img src="/img/basura.png"></div></div>'
        }       
    }
)

let about = document.getElementById("about")
about.innerHTML="";

axios.get("/api/abouts").then(
    json => {
        let datos = json.data._embedded.abouts;
        // console.log(datos)
        about.innerHTML += '<div class="container titulo"><div>Persona</div><div>Organismo</div><div>descripcion</div></div>'
        for (linea of datos) {
            about.innerHTML += '<div class="container"><div>persona</div><div>'+linea.titulo+'</div> <div>'+linea.texto+'</div><div class="basura"><a href="/basededatos/borrar/about/'+linea.id+'"><img src="/img/basura.png"></div></div>'
        }       
    }
)

let admin = document.getElementById("admin")
admin.innerHTML="";

axios.get("/api/admins").then(
    json => {
        let datos = json.data._embedded.admins;
        // console.log(datos)
        admin.innerHTML += '<div class="container titulo"><div>Persona</div><div>Condicion</div></div>'
        for (linea of datos) {
            admin.innerHTML += '<div class="container"><div>persona</div><div>'+linea.condicion+'</div><div class="basura"> <a href="/basededatos/borrar/admin/'+linea.id+'"><img src="/img/basura.png"></div></div>'
        }       
    }
)

let contact = document.getElementById("contact")
contact.innerHTML="";

axios.get("/api/contacts").then(
    json => {
        let datos = json.data._embedded.contacts;
        // console.log(datos)
        contact.innerHTML += '<div class="container titulo"><div>profesion</div><div>Telefono</div><div>direccion</div><div>email</div><div>foto</div></div>'
        for (linea of datos) {
            contact.innerHTML += '<div class="container">'
            +'<div>'+linea.profesion+'</div>'
            +'<div>'+linea.telefono+'</div>'
            +'<div>'+linea.direccion+'</div>'
            +'<div>'+linea.email+'</div>'
            +'<div>'+linea.foto+'</div>'
            +'<div class="basura"><a href="/basededatos/borrar/contact/'+linea.id+'"><img src="/img/basura.png"></div></div>'
        }       
    }
)

let proyect = document.getElementById("proyect")
proyect.innerHTML="";

axios.get("/api/proyects").then(
    json => {
        let datos = json.data._embedded.proyects;
        // console.log(datos)
        proyect.innerHTML += '<div class="container titulo"><div>Persona</div><div>Proyecto</div><div>descripcion</div><div>Foto</div><div>Enlace</div></div>'
        for (linea of datos) {
            proyect.innerHTML += '<div class="container"><div>persona</div><div>'+linea.titulo+'</div> <div>'+linea.texto+'</div><div>'+linea.foto+'</div><div>'+linea.enlace+'</div><div class="basura"><a href="/basededatos/borrar/proyect/'+linea.id+'"><img src="/img/basura.png"></div></div>'
        }       
    }
)
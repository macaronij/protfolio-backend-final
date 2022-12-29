let nodeList = document.querySelectorAll(".personaSelect");


axios.get("/api/persons").then(
    json => {
        datos = json.data._embedded.persons;
        console.log(datos);
        for (select of nodeList) {
            for (linea of datos) {
                select.innerHTML += '<option value="'+linea.id+'">'+linea.nombre+'</option>'
            }
        }

    }
)



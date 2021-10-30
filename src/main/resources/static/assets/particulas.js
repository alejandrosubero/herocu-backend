
var colorRandon;
var speedparti;
var speedaniparti;
var forma;
var sizeparticula;
var diatanciapart;
var off_on;

$(document).ready(function () {
  inicioautomatico();
});


function inicioautomatico() {
  colorRandon = false;
  speedparti = 0;
  speedaniparti = 0;
  forma = 'circule';
  sizeparticula = 3;
  diatanciapart = 400;
  off_on = true;
  colorparticula = '#fff';//'#3598ff';
  colorlinea = '#3598ff';
  esparticula();
}



function esparticula() {

  var ancho = $(window).width();

  if (ancho > 600) {
    /* particlesJS('dom-id', params);
/* @dom-id : set the html tag id [string, optional, default value : particles-js]
/* @params: set the params [object, optional, default values : check particles.js] */

    /* config dom id (optional) + config particles params */
    particlesJS('particles-js', {
      particles: {
        color: colorparticula,
        color_random: colorRandon,
        shape: 'circle', // "circle", "edge" or "triangle"
        opacity: {
          opacity: 1,
          anim: {
            enable: true,
            speed: speedparti,
            opacity_min: 0,
            sync: false
          }
        },
        size: sizeparticula,
        size_random: true,
        nb: 150,
        line_linked: {
          enable_auto: true,
          distance: 100,
          color_random: false,
          color: colorlinea,  //'#fffdbd',
          opacity: 1,
          width: 1,
          condensed_mode: {
            enable: false,
            rotateX: 600,
            rotateY: 600
          }
        },
        anim: {
          enable: true,
          speed: speedaniparti
        }
      },
      interactivity: {
        enable: true,
        mouse: {
          distance: diatanciapart
        },
        detect_on: 'canvas', // "canvas" or "window"
        mode: 'grab', // "grab" of false
        line_linked: {
          opacity: .5
        },
        events: {
          onclick: {
            enable: true,
            mode: 'push', // "push" or "remove"
            nb: 4
          },
          onresize: {
            enable: true,
            mode: 'out', // "out" or "bounce"
            density_auto: off_on,
            density_area: 800 // nb_particles = particles.nb * (canvas width *  canvas height / 1000) / density_area
          }
        }
      },
      /* Retina Display Support */
      retina_detect: true
    });
  }
}



function rame() {
  var memo = document.getElementsByName('drone');
  for (i = 0; i < memo.length; i++) {
    if (memo[i].checked) {
      var memory = memo[i].value;
      if (memory == 1) {
        colorRandon = true;
      } else {
        colorRandon = false
      }
    }
  }
}

function velparticula1() {

  var memo = document.getElementsByName('velo1');
  for (i = 0; i < memo.length; i++) {
    if (memo[i].checked) {
      var memory = memo[i].value;
      if (memory == 1) {
        speedparti = parseInt(document.getElementById('velocidad1').value);
      } else {
        speedparti = 0;
      }
    }
  }
}

function velpar2() {

  var memo = document.getElementsByName('velo2');
  for (i = 0; i < memo.length; i++) {
    if (memo[i].checked) {
      var memory = memo[i].value;
      if (memory == 1) {
        speedaniparti = parseInt(document.getElementById('velocidad2').value);
      } else {
        speedaniparti = 0;
      }
    }
  }
}




function distancu() {

  var memo = document.getElementsByName('distancia');
  for (i = 0; i < memo.length; i++) {
    if (memo[i].checked) {
      var memory = memo[i].value;
      if (memory == 1) {
        diatanciapart = parseInt(document.getElementById('distancias').value);
      } else {
        diatanciapart = 400;
      }
    }
  }
}

function tamano() {

  var memo = document.getElementsByName('tamano');
  for (i = 0; i < memo.length; i++) {
    if (memo[i].checked) {
      var memory = memo[i].value;
      if (memory == 1) {
        sizeparticula = parseInt(document.getElementById("tamanos").value);
      } else {
        sizeparticula = 5;
      }
    }
  }
}


function apagar() {

  var memo = document.getElementsByName('off');
  for (i = 0; i < memo.length; i++) {
    if (memo[i].checked) {
      var memory = memo[i].value;
      if (memory == 1) {
        off_on = false;
      } else {
        off_on = true;
      }
    }
  }
}

function modificar() {
  rame();
  velparticula1();
  velpar2();
  distancu();
  tamano();
  apagar();
  esparticula();
  formass();
  tema();
}


function formass() {
  //"circle", "edge" or "triangle"
  var memo = document.getElementsByName('forma');
  for (i = 0; i < memo.length; i++) {
    if (memo[i].checked) {
      var memory = memo[i].value;
      if (memory == 1) {
        var combo = document.getElementById("producto");
        var selected = combo.options[combo.selectedIndex].text;
        forma = selected;
      } else {
        forma = 'circule';
      }
    }
  }
}


function tema() {
  //"circle", "edge" or "triangle"
  var memo = document.getElementsByName('tema');
  for (i = 0; i < memo.length; i++) {
    if (memo[i].checked) {
      var memory = memo[i].value;
      if (memory == 1) {
        // var combo = document.getElementById("produc");
        // var selected = combo.options[combo.selectedIndex].text;
        // alert(selected);
        var cod = document.getElementById("produc").value;
        if (cod == 1) {//gold
          // colorparticula = '#3598ff';
          // colorlinea = '#3598ff';
          colorparticula = '#3598ff';//'#3598ff';
          colorlinea = '#3598ff';
        } else if (cod == 2) {
          //alert("blue")
          colorparticula = '#fffdbd';//'#3598ff';
          colorlinea = '#fffdbd';//'#3598ff'
        }
      } else {
        alert(" gg");
        colorparticula = '#fffdbd';//'#3598ff';
        colorlinea = '#3598ff';

      }
    }
  }
}


//colorparticula= '#fffdbd';//'#3598ff';
//colorlinea= '#fffdbd'//'#3598ff';



function validar() {

  var name = document.getElementById("name").value;
  var email = document.getElementById("email").value;
  var feedback = document.getElementById("feedback").value;

  if (!name == "" || /^\s+$/.test(name)) {
    if ((/\S+@\S+\.\S+/.test(email))) {
      if (!feedback == "") {
        mail();

      } else {
        alert("Escriba el mensaje");
      }
    } else {
      alert("Formato de correo incorrecto")
    }
  } else {
    alert("Coloque un Nombre")
  }
}

function enviaras() {
  validar();
};




function mail() {

  var http = new XMLHttpRequest();
  var url = "https://mail-backen.herokuapp.com/feedback/ligeros";
  var resultado = false;

  var name = document.getElementById("name").value;
  var email = document.getElementById("email").value;
  var feedback = document.getElementById("feedback").value;
  var tokens = "1234567891011121314151689719";


  if (name == "") {
    alert("Agrege complete el formulario");
    return resultado;
  } else if (email == "") {
    alert("Agrege complete el formulario");
    return resultado;
  } else if (feedback === "") {
    alert("Agrege complete el formulario");
    return resultado;
  }

  var data = {
    "name": name,
    "email": email,
    "feedback": feedback,
    "token": tokens
  };

  http.open("POST", url, true);
  http.setRequestHeader("Content-Type", "application/json");
  http.send(JSON.stringify(data));

  http.onreadystatechange = function () {
    if (http.readyState == 4 && http.status == 200) {
      if (http.responseText) {//respuesta del servidor al cliente
        alert("Envio exitoso");
        resultado = true;
      } else {
        alert("Envio el fallido revisar datos");
      }
    }
  }
  return resultado;
};




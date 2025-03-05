let xBolinha = 300;
let yBolinha = 200;
let diametro = 30;
let vxBolinha = 6;
let vyBolinha = 6;
let raio = diametro / 2;

let xRaqueteJogador = 10;
let yRaqueteJogador = 150;
let larguraRaquete = 10;
let alturaRaquete = 100;

let xRaqueteOponente = 580;
let yRaqueteOponente = 150;
let velocidadeOponente = 6;

let meusPontos = 0;
let pontosDoOponente = 0;

function setup() {
  createCanvas(600, 400);
}

function draw() {
  background(0);
  
  criarBolinha();
  moverBolinha();
  validarColisaoBorda();
  validarColisaoRaquetes();
  
  desenharRaquete(xRaqueteJogador, yRaqueteJogador);
  desenharRaquete(xRaqueteOponente, yRaqueteOponente);
  
  moverRaqueteJogador();
  moverRaqueteOponente();

  incluirPlacar();
}

function criarBolinha() {
  circle(xBolinha, yBolinha, diametro);
}

function moverBolinha() {
  xBolinha += vxBolinha;
  yBolinha += vyBolinha;
}

function validarColisaoBorda() {
  if (yBolinha + raio > height || yBolinha - raio < 0) {
    vyBolinha *= -1;
  }
  
  if (xBolinha - raio < 0) {
    pontosDoOponente += 1;
    resetarBolinha();
  }

  if (xBolinha + raio > width) {
    meusPontos += 1;
    resetarBolinha();
  }
}

function desenharRaquete(x, y) {
  rect(x, y, larguraRaquete, alturaRaquete);
}

function moverRaqueteJogador() {
  if (keyIsDown(UP_ARROW)) {
    yRaqueteJogador -= 10;
  }
  
  if (keyIsDown(DOWN_ARROW)) {
    yRaqueteJogador += 10;
  }

  yRaqueteJogador = constrain(yRaqueteJogador, 0, height - alturaRaquete);
}

function moverRaqueteOponente() {
  yRaqueteOponente = constrain(yBolinha - alturaRaquete / 2, 0, height - alturaRaquete);
}

function validarColisaoRaquetes() {
  if (xBolinha - raio < xRaqueteJogador + larguraRaquete &&
      yBolinha > yRaqueteJogador &&
      yBolinha < yRaqueteJogador + alturaRaquete) {
    vxBolinha *= -1;
  }

  if (xBolinha + raio > xRaqueteOponente &&
      yBolinha > yRaqueteOponente &&
      yBolinha < yRaqueteOponente + alturaRaquete) {
    vxBolinha *= -1;
  }
}

function incluirPlacar() {
  fill(255);
  textSize(20);
  text(meusPontos, 250, 30);
  text(pontosDoOponente, 350, 30);
}

function resetarBolinha() {
  xBolinha = width / 2;
  yBolinha = height / 2;
  vxBolinha *= -1;
}

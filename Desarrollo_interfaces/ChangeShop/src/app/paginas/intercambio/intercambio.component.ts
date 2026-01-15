import { Component, OnInit } from '@angular/core';
import { IonButton, IonContent, IonDatetime, IonFooter, IonInput, IonItem } from "@ionic/angular/standalone";
import { FormsModule } from "@angular/forms";
import { CommonModule } from '@angular/common';
import { NavController } from "@ionic/angular";

@Component({
  selector: 'app-intercambio',
  templateUrl: './intercambio.component.html',
  styleUrls: ['./intercambio.component.scss'],
  standalone: true,
  imports: [
    CommonModule,
    IonContent,
    IonFooter,
    IonInput,
    IonButton,
    IonDatetime,
    FormsModule
  ]
})
export class IntercambioPage implements OnInit {

  mensajes = [
    { texto: 'Hola', esMio: false },
    { texto: '¿Qué tal?', esMio: true }
  ];
  texto: string = '';


  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private navCtrl: NavController) {
  }

  ngOnInit() {
  }

  enviar() {

    // Navegar a otra página si quieres
    this.navCtrl.navigateForward('/intercambioConfirmar');
  }

  enviarMensaje() {
    this.mensajes.push({ texto: this.texto, esMio: true });
  }
}




import { Component, OnInit } from '@angular/core';
import {IonButton, IonContent, IonDatetime, IonFooter, IonInput, IonItem} from "@ionic/angular/standalone";
import {NgForOf} from "@angular/common";
import {NavController} from "@ionic/angular";
import {FormsModule} from "@angular/forms";

@Component({
    selector: 'app-prestamo',
    templateUrl: './prestamo.component.html',
    styleUrls: ['./prestamo.component.scss'],
    standalone: true,
  imports: [
    IonButton,
    IonContent,
    IonDatetime,
    IonFooter,
    IonInput,
    IonItem,
    NgForOf,
    FormsModule
  ]
})
export class PrestamoPage  implements OnInit {

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private navCtrl: NavController) { }

  ngOnInit() {}

  mensajes: string[] = [];
  texto: string = '';

  enviar() {

    // Navegar a otra página si quieres
    this.navCtrl.navigateForward('/prestamoConfirmar');
  }
}

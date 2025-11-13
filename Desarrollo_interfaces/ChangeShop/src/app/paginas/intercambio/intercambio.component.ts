import { Component, OnInit } from '@angular/core';
import {IonButton, IonContent, IonFooter, IonInput, IonItem} from "@ionic/angular/standalone";
import {FormsModule} from "@angular/forms";
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-intercambio',
  templateUrl: './intercambio.component.html',
  styleUrls: ['./intercambio.component.scss'],
  standalone: true,
  imports: [
    CommonModule,   // ✅ IMPORTANTE (para *ngFor)
    IonContent,
    IonFooter,
    IonItem,
    IonInput,
    IonButton,
    FormsModule
  ]
})
export class IntercambioPage implements OnInit {

  mensajes: string[] = [];
  texto: string = '';

  constructor() {}

  ngOnInit() {}

  enviar() {
    if (this.texto.trim() !== '') {
      this.mensajes.push(this.texto);
      this.texto = '';
    }
  }
}

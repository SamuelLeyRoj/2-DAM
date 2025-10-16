import { Component, OnInit } from '@angular/core';
import {IonButton, IonInput, IonItem, IonLabel} from "@ionic/angular/standalone";

@Component({
  selector: 'app-formulario-campos',
  templateUrl: './formulario-campos.component.html',
  styleUrls: ['./formulario-campos.component.scss'],
  standalone: true,
  imports: [
    IonItem,
    IonLabel,
    IonInput,
    IonButton
  ]
})
export class FormularioCamposComponent  implements OnInit {

  constructor() { }

  ngOnInit() {}

}

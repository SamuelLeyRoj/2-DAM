import { Component, OnInit } from '@angular/core';
import {IonContent} from "@ionic/angular/standalone";

@Component({
  selector: 'app-botones-formulario-inicio',
  templateUrl: './botones-formulario-inicio.component.html',
  styleUrls: ['./botones-formulario-inicio.component.scss'],
  standalone: true,
  imports: [
    IonContent
  ]
})
export class BotonesFormularioInicioComponent  implements OnInit {

  constructor() { }

  ngOnInit() {}

}

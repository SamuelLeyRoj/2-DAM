import { Component, OnInit } from '@angular/core';
import {MenuNavegacionComponent} from "../../componentes/menu-navegacion/menu-navegacion.component";
import {BotonesNavegacionComponent} from "../../componentes/botones-navegacion/botones-navegacion.component";
import {FormularioSubirRopaComponent} from "../../componentes/formulario-subir-ropa/formulario-subir-ropa.component";
import {IonContent} from "@ionic/angular/standalone";

@Component({
    selector: 'app-mis-prendas',
    templateUrl: './mis-prendas.component.html',
    styleUrls: ['./mis-prendas.component.scss'],
    standalone: true,
  imports: [
    MenuNavegacionComponent,
    BotonesNavegacionComponent,
    FormularioSubirRopaComponent,
    IonContent
  ]
})
export class MisPrendasPage  implements OnInit {

  constructor() { }

  ngOnInit() {}

}

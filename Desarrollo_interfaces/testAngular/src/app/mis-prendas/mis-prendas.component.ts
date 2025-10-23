import { Component, OnInit } from '@angular/core';
import {MenuNavegacionComponent} from "../menu-navegacion/menu-navegacion.component";
import {BotonesNavegacionComponent} from "../botones-navegacion/botones-navegacion.component";
import {FormularioSubirRopaComponent} from "../formulario-subir-ropa/formulario-subir-ropa.component";

@Component({
    selector: 'app-mis-prendas',
    templateUrl: './mis-prendas.component.html',
    styleUrls: ['./mis-prendas.component.scss'],
    standalone: true,
  imports: [
    MenuNavegacionComponent,
    BotonesNavegacionComponent,
    FormularioSubirRopaComponent
  ]
})
export class MisPrendasComponent  implements OnInit {

  constructor() { }

  ngOnInit() {}

}

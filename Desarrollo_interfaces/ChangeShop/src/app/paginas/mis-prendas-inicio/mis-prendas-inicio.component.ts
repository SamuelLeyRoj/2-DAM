import { Component, OnInit } from '@angular/core';
import {IonContent, IonHeader} from "@ionic/angular/standalone";
import {MenuNavegacionComponent} from "../../componentes/menu-navegacion/menu-navegacion.component";
import {BotonesNavegacionComponent} from "../../componentes/botones-navegacion/botones-navegacion.component";
import {
  MiRopaIntercambioYPendientesComponent
} from "../../componentes/mi-ropa-intercambio-ypendientes/mi-ropa-intercambio-ypendientes.component";

@Component({
  selector: 'app-mis-prendas-inicio',
  templateUrl: './mis-prendas-inicio.component.html',
  styleUrls: ['./mis-prendas-inicio.component.scss'],
  standalone: true,
  imports: [
    IonHeader,
    IonContent,
    MenuNavegacionComponent,
    BotonesNavegacionComponent,
    MiRopaIntercambioYPendientesComponent
  ]
})
export class MisPrendasInicioPage  implements OnInit {

  constructor() { }

  ngOnInit() {}

}

import { Component, OnInit } from '@angular/core';
import {MenuNavegacionComponent} from "../../componentes/menu-navegacion/menu-navegacion.component";
import {BotonesNavegacionComponent} from "../../componentes/botones-navegacion/botones-navegacion.component";
import {BuscarUsuariosComponent} from "../../componentes/buscar-usuarios/buscar-usuarios.component";
import {IonContent} from "@ionic/angular/standalone";

@Component({
  selector: 'app-conocer-gente',
  templateUrl: './conocer-gente.component.html',
  styleUrls: ['./conocer-gente.component.scss'],
  standalone: true,
  imports: [
    MenuNavegacionComponent,
    BotonesNavegacionComponent,
    BuscarUsuariosComponent,
    IonContent
  ]
})
export class ConocerGentePage  implements OnInit {

  constructor() { }

  ngOnInit() {}

}

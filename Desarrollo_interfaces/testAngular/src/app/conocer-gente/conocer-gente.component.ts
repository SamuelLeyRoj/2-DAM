import { Component, OnInit } from '@angular/core';
import {MenuNavegacionComponent} from "../menu-navegacion/menu-navegacion.component";
import {BotonesNavegacionComponent} from "../botones-navegacion/botones-navegacion.component";
import {BuscarUsuariosComponent} from "../buscar-usuarios/buscar-usuarios.component";

@Component({
  selector: 'app-conocer-gente',
  templateUrl: './conocer-gente.component.html',
  styleUrls: ['./conocer-gente.component.scss'],
  standalone: true,
  imports: [
    MenuNavegacionComponent,
    BotonesNavegacionComponent,
    BuscarUsuariosComponent
  ]
})
export class ConocerGenteComponent  implements OnInit {

  constructor() { }

  ngOnInit() {}

}

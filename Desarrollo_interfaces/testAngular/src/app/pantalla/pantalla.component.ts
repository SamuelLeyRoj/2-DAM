import { Component } from '@angular/core';
import { IonicModule } from '@ionic/angular';
import { MenuNavegacionComponent } from '../menu-navegacion/menu-navegacion.component';
import {BotonesNavegacionComponent} from "../botones-navegacion/botones-navegacion.component";
import {BotonesFormularioInicioComponent} from "../botones-formulario-inicio/botones-formulario-inicio.component";
import {BotonGrandeAccionComponent} from "../boton-grande-accion/boton-grande-accion.component";
import {CartasRopaComponent} from "../cartas-ropa/cartas-ropa.component";
import {BuscarUsuariosComponent} from "../buscar-usuarios/buscar-usuarios.component";
import {FormularioCamposComponent} from "../formulario-campos/formulario-campos.component";

@Component({
  selector: 'app-pantalla',
  templateUrl: './pantalla.component.html',
  styleUrls: ['./pantalla.component.scss'],
  standalone: true,
  imports: [IonicModule, MenuNavegacionComponent, BotonesNavegacionComponent, BotonesFormularioInicioComponent, BotonGrandeAccionComponent, CartasRopaComponent, BuscarUsuariosComponent, FormularioCamposComponent]
})
export class PantallaComponent {}

import { Component } from '@angular/core';
import { IonicModule } from '@ionic/angular';
import { MenuNavegacionComponent } from '../../componentes/menu-navegacion/menu-navegacion.component';
import {BotonesNavegacionComponent} from "../../componentes/botones-navegacion/botones-navegacion.component";
import {CartasRopaComponent} from "../../componentes/cartas-ropa/cartas-ropa.component";
import {FormsModule} from "@angular/forms";



@Component({
  selector: 'app-pantalla',
  templateUrl: './pantalla.component.html',
  styleUrls: ['./pantalla.component.scss'],
  standalone: true,
  imports: [IonicModule, MenuNavegacionComponent, BotonesNavegacionComponent, CartasRopaComponent, FormsModule]
})
export class PantallaPage {

  EstiloSeleccionado=""
}

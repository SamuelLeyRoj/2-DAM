import { Routes } from '@angular/router';
import {PantallaComponent} from "./pantalla/pantalla.component";
import {BotonComponent} from "./boton/boton.component";
import {CalendarioComponent} from "./calendario/calendario.component";

export const routes: Routes = [

  {path:'' ,component:PantallaComponent},
  {path:'boton' ,component:BotonComponent},
  {path:'calendario' ,component:CalendarioComponent},
];

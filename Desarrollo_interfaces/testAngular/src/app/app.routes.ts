import { Routes } from '@angular/router';
import {InicioComponent} from "./inicio/inicio.component";
import {InicioSesionComponent} from "./inicio-sesion/inicio-sesion.component";
import {PantallaComponent} from "./pantalla/pantalla.component";
import {RegistroComponent} from "./registro/registro.component";
import {ContactosComponent} from "./contactos/contactos.component";
import {MiPerfilComponent} from "./mi-perfil/mi-perfil.component";
import {ConocerGenteComponent} from "./conocer-gente/conocer-gente.component";
import {MisPrendasComponent} from "./mis-prendas/mis-prendas.component";



export const routes: Routes = [

  {path:'' ,component:InicioComponent},

  {path:'inicioSesion', component:InicioSesionComponent},

  {path:'inicio', component:InicioComponent},

  {path:'registro', component:RegistroComponent},

  {path:'comprarRopa', component:PantallaComponent},

  {path:'contactos', component:ContactosComponent},

  {path:'miPerfil', component:MiPerfilComponent},

  {path:'conocerGente', component:ConocerGenteComponent},

  {path:'misPrendas', component:MisPrendasComponent},


];

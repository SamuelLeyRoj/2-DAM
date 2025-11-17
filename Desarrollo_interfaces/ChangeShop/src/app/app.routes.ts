import { Routes } from '@angular/router';
import { InicioPage } from './paginas/inicio/inicio.component';
import { InicioSesionPage } from './paginas/inicio-sesion/inicio-sesion.component';
import { PantallaPage } from './paginas/pantalla/pantalla.component';
import { RegistroPage } from './paginas/registro/registro.component';
import { ContactosPage } from './paginas/contactos/contactos.component';
import { MiPerfilPage } from './paginas/mi-perfil/mi-perfil.component';
import { ConocerGentePage } from './paginas/conocer-gente/conocer-gente.component';
import { MisPrendasPage } from './paginas/mis-prendas/mis-prendas.component';
import {RopaInformacionPage} from "./paginas/ropa-informacion/ropa-informacion.component";
import {MisPrendasInicioPage} from "./paginas/mis-prendas-inicio/mis-prendas-inicio.component";
import {IntercambioPage} from "./paginas/intercambio/intercambio.component";
import {PrestamoPage} from "./paginas/prestamo/prestamo.component";
import {IntercambioConfirmarPage} from "./paginas/intercambio-confirmar/intercambio-confirmar.component";
import {PrestamoConfirmarPage} from "./paginas/prestamo-confirmar/prestamo-confirmar.component";

export const routes: Routes = [
  { path: '', component: InicioPage },
  { path: 'inicio', component: InicioPage },
  { path: 'inicioSesion', component: InicioSesionPage },
  { path: 'registro', component: RegistroPage },
  { path: 'comprarRopa', component: PantallaPage },
  { path: 'contactos', component: ContactosPage },
  { path: 'miPerfil', component: MiPerfilPage },
  { path: 'conocerGente', component: ConocerGentePage },
  { path: 'misPrendas', component: MisPrendasPage },
  { path: 'ropaInformacion', component: RopaInformacionPage },
  { path: 'misPrendasInicio', component: MisPrendasInicioPage },
  { path: 'intercambio', component: IntercambioPage },
  { path: 'prestamo', component: PrestamoPage },
  { path: 'intercambioConfirmar', component: IntercambioConfirmarPage },
  { path: 'prestamoConfirmar', component: PrestamoConfirmarPage },
];

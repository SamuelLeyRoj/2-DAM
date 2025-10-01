import { Component } from '@angular/core';
import { IonApp, IonRouterOutlet } from '@ionic/angular/standalone';
import {PantallaComponent} from "./pantalla/pantalla.component";
import {BotonComponent} from "./boton/boton.component";
import {CalendarioComponent} from "./calendario/calendario.component";

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  imports: [IonApp, IonRouterOutlet, PantallaComponent, BotonComponent,CalendarioComponent],
})
export class AppComponent {
  constructor() {}
}

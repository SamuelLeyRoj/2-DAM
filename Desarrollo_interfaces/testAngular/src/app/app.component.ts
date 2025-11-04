import { Component } from '@angular/core';
import { IonApp, IonRouterOutlet } from '@ionic/angular/standalone';
import {PantallaComponent} from "./pantalla/pantalla.component";


@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  imports: [IonApp, IonRouterOutlet, PantallaComponent],
})
export class AppComponent {
  constructor() {}
}

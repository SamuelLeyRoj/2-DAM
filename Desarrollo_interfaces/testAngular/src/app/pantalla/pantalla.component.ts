import { Component, OnInit } from '@angular/core';
import {BotonComponent} from "../boton/boton.component";
import {IonContent, IonHeader, IonTitle, IonToolbar} from "@ionic/angular/standalone";
import {CalendarioComponent} from "../calendario/calendario.component";

@Component({
  selector: 'app-pantalla',
  templateUrl: './pantalla.component.html',
  styleUrls: ['./pantalla.component.scss'],
  standalone: true,
  imports: [BotonComponent, IonHeader, IonToolbar, IonTitle, IonContent, CalendarioComponent]
})
export class PantallaComponent  implements OnInit {

  constructor() { }

  ngOnInit() {}

}

import { Component, OnInit } from '@angular/core';
import {IonCol, IonContent, IonGrid, IonRow} from "@ionic/angular/standalone";

@Component({
  selector: 'app-botones-navegacion',
  templateUrl: './botones-navegacion.component.html',
  styleUrls: ['./botones-navegacion.component.scss'],
  standalone: true,
  imports: [
    IonContent,
    IonGrid,
    IonRow,
    IonCol
  ]
})
export class BotonesNavegacionComponent  implements OnInit {

  constructor() { }

  ngOnInit() {}

}

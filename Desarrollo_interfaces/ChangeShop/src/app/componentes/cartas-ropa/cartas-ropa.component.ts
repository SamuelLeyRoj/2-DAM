import { Component, OnInit } from '@angular/core';
import {IonIcon} from "@ionic/angular/standalone";

@Component({
  selector: 'app-cartas-ropa',
  templateUrl: './cartas-ropa.component.html',
  styleUrls: ['./cartas-ropa.component.scss'],
  standalone: true,
  imports: [
    IonIcon
  ]
})
export class CartasRopaComponent  implements OnInit {

  constructor() { }

  ngOnInit() {}

}

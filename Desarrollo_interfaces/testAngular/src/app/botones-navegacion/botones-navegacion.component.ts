import { Component, OnInit } from '@angular/core';
import {IonCol, IonContent, IonGrid, IonRow} from "@ionic/angular/standalone";
import {NavController} from "@ionic/angular";

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

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private navCtrl: NavController) {}

  ngOnInit() {}

  irComprar() {
    this.navCtrl.navigateForward('/comprarRopa');
  }

  irConocerGente(){
    this.navCtrl.navigateForward('/conocerGente');
  }

  irMisPrendas(){
    this.navCtrl.navigateForward('/misPrendas');
  }
}

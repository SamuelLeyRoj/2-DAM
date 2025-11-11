import { Component, OnInit } from '@angular/core';

import {NavController} from "@ionic/angular";
import {IonInput, IonItem, IonLabel} from "@ionic/angular/standalone";


@Component({
  selector: 'app-inicio-sesion',
  templateUrl: './inicio-sesion.component.html',
  styleUrls: ['./inicio-sesion.component.scss'],
  standalone: true,
  imports: [
    IonLabel,
    IonItem,
    IonInput


  ]
})
export class InicioSesionPage  implements OnInit {

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private navCtrl: NavController) {}

  ngOnInit() {}

  irALinicio() {
    this.navCtrl.navigateForward('/inicio');
  }

  irAComprar() {
    this.navCtrl.navigateForward('/comprarRopa');
  }
}

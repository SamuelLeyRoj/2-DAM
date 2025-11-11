import { Component, OnInit } from '@angular/core';
import {BotonGrandeAccionComponent} from "../boton-grande-accion/boton-grande-accion.component";
import {IonIcon} from "@ionic/angular/standalone";
import {NavController} from "@ionic/angular";

@Component({
  selector: 'app-mi-ropa-intercambio-ypendientes',
  templateUrl: './mi-ropa-intercambio-ypendientes.component.html',
  styleUrls: ['./mi-ropa-intercambio-ypendientes.component.scss'],
  standalone: true,
  imports: [

    IonIcon
  ]
})
export class MiRopaIntercambioYPendientesComponent  implements OnInit {

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private navCtrl: NavController) { }

  ngOnInit() {}


  irRopa() {
    this.navCtrl.navigateForward('/misPrendas');
  }
}

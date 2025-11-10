import { Component, OnInit } from '@angular/core';
import {IonContent} from "@ionic/angular/standalone";
import {IonicModule, NavController} from "@ionic/angular";
import {MenuNavegacionComponent} from "../../componentes/menu-navegacion/menu-navegacion.component";
import {BotonesNavegacionComponent} from "../../componentes/botones-navegacion/botones-navegacion.component";
import {BotonGrandeAccionComponent} from "../../componentes/boton-grande-accion/boton-grande-accion.component";

@Component({
  selector: 'app-ropa-informacion',
  templateUrl: './ropa-informacion.component.html',
  styleUrls: ['./ropa-informacion.component.scss'],
  standalone: true,
  imports: [

    IonicModule,
    MenuNavegacionComponent,
    BotonesNavegacionComponent,
    BotonGrandeAccionComponent
  ]
})
export class RopaInformacionPage  implements OnInit {

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private navCtrl: NavController) { }

  ngOnInit() {}

  irInicio(){
      this.navCtrl.navigateForward('/comprarRopa')
  }
}

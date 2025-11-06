import { Component, OnInit } from '@angular/core';
import {IonItem} from "@ionic/angular/standalone";
import {IonicModule} from "@ionic/angular";
import {MenuNavegacionComponent} from "../../componentes/menu-navegacion/menu-navegacion.component";
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.scss'],
  standalone: true,
  imports: [
    IonItem,
    IonicModule,

  ]
})
export class InicioPage  implements OnInit {

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private navCtrl: NavController) {}

  ngOnInit() {}

  irALogin() {
    this.navCtrl.navigateForward('/inicioSesion');
  }

  irAlRegistro(){
    this.navCtrl.navigateForward('/registro');
  }

}

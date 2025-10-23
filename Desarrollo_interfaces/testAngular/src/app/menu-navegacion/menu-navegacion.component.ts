import { Component } from '@angular/core';
import {IonicModule, NavController} from '@ionic/angular';

@Component({
  selector: 'app-menu-navegacion',
  templateUrl: './menu-navegacion.component.html',
  styleUrls: ['./menu-navegacion.component.scss'],
  standalone: true,
  imports: [IonicModule]

})
export class MenuNavegacionComponent {

  mostrar = false;

  mostrarAlerta() {
    this.mostrar = true;
  }


  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private navCtrl: NavController) {}


  irDeVuelta() {
    this.navCtrl.navigateForward('/inicio');
  }

  irContactos(){
    this.navCtrl.navigateForward('/contactos');
  }

  irMiCuenta(){
    this.navCtrl.navigateForward('/miPerfil');
  }
}

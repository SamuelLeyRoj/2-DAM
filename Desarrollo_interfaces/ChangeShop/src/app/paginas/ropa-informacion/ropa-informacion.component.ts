import { Component, OnInit } from '@angular/core';
import {IonContent} from "@ionic/angular/standalone";
import {AlertController, IonicModule, NavController} from "@ionic/angular";
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
    BotonGrandeAccionComponent
  ]
})
export class RopaInformacionPage  implements OnInit {


  constructor(
    // eslint-disable-next-line @angular-eslint/prefer-inject
    private navCtrl: NavController,
    // eslint-disable-next-line @angular-eslint/prefer-inject
    private alertController: AlertController
  ) {}


  ngOnInit() {}

  irInicio(){
      this.navCtrl.navigateForward('/comprarRopa')
  }

  async irContactos() {
    const alert = await this.alertController.create({
      header: '¡Perfecto!',
      message: 'Has elegido contactar por esta prenda.',
      buttons: [
        {
          text: 'Aceptar',
          handler: () => {
            this.navCtrl.navigateForward('/contactos');
          }
        }
      ]
    });

    await alert.present();
  }
}

import { Component, OnInit } from '@angular/core';
import { IonContent } from "@ionic/angular/standalone";
import { IntercabioRopaComponent } from "../../componentes/intercabio-ropa/intercabio-ropa.component";
import { BotonGrandeAccionComponent } from "../../componentes/boton-grande-accion/boton-grande-accion.component";
import { AlertController, NavController } from '@ionic/angular';

@Component({
  selector: 'app-intercambio-confirmar',
  templateUrl: './intercambio-confirmar.component.html',
  styleUrls: ['./intercambio-confirmar.component.scss'],
  standalone: true,
  imports: [
    IonContent,
    IntercabioRopaComponent,
    BotonGrandeAccionComponent
  ],
})
export class IntercambioConfirmarPage implements OnInit {

  constructor(
    private alertController: AlertController,
    private navCtrl: NavController
  ) {}

  ngOnInit() {}

  // 🔥 ESTA ES LA FUNCIÓN CORRECTA DEL POPUP
  async mostrarPopup() {
    const alert = await this.alertController.create({
      header: '¿Confirmar intercambio?',
      message: '¿Estás seguro de que deseas continuar?',
      buttons: [
        {
          text: 'Cancelar',
          role: 'cancel'
        },
        {
          text: 'Aceptar',
          handler: () => {
            this.navCtrl.navigateRoot('/misPrendasInicio');
          }
        }
      ]
    });

    await alert.present();
  }

}

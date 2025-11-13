import { Component, OnInit } from '@angular/core';
import {IonIcon} from "@ionic/angular/standalone";
import {IonicModule, NavController} from '@ionic/angular';
@Component({
  selector: 'app-contactos',
  templateUrl: './contactos.component.html',
  styleUrls: ['./contactos.component.scss'],
  standalone: true,
  imports: [
    IonicModule
  ]
})
export class ContactosPage  implements OnInit {

// eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private navCtrl: NavController) {}

  ngOnInit() {}


  volver(){

    this.navCtrl.navigateForward('/comprarRopa')

  }

  irIntercambio(){
    this.navCtrl.navigateForward('/intercambio')
  }

  irPrestamo(){
    this.navCtrl.navigateForward('/prestamo')
  }
}

import { Component, OnInit } from '@angular/core';
import {NavController} from "@ionic/angular";
import {IonInput, IonItem, IonLabel} from "@ionic/angular/standalone";

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.scss'],
  standalone: true,
  imports: [
    IonInput,
    IonItem,
    IonLabel
  ]
})
export class RegistroPage  implements OnInit {

  constructor(private navCtrl: NavController) {}

  ngOnInit() {}

  irALinicio() {
    this.navCtrl.navigateForward('/inicio');
  }

  irAComprar() {
    this.navCtrl.navigateForward('/comprarRopa');
  }
}

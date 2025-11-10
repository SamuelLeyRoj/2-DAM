import { Component, OnInit } from '@angular/core';
import {IonIcon} from "@ionic/angular/standalone";
import {NavController} from "@ionic/angular";

@Component({
  selector: 'app-cartas-ropa',
  templateUrl: './cartas-ropa.component.html',
  styleUrls: ['./cartas-ropa.component.scss'],
  standalone: true,
  imports: [
    IonIcon
  ]
})
export class CartasRopaComponent  implements OnInit {

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private navCtrl: NavController) { }

  ngOnInit() {}


  irInformacionRopa() {
    this.navCtrl.navigateForward('/ropaInformacion');
  }
}

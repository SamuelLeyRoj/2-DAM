import { Component, OnInit } from '@angular/core';
import {IonButton, IonContent, IonIcon} from "@ionic/angular/standalone";
import {NavController} from "@ionic/angular";

@Component({
  selector: 'app-mi-perfil',
  templateUrl: './mi-perfil.component.html',
  styleUrls: ['./mi-perfil.component.scss'],
  standalone: true,
  imports: [
    IonIcon,
    IonButton,
    IonContent
  ]
})
export class MiPerfilPage  implements OnInit {

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private navCtrl: NavController) { }

  ngOnInit() {}


  volver(){

    this.navCtrl.navigateForward('/comprarRopa')

  }
}

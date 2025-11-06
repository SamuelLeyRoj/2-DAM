import { Component, OnInit } from '@angular/core';
import {IonIcon} from "@ionic/angular/standalone";

@Component({
  selector: 'app-mi-perfil',
  templateUrl: './mi-perfil.component.html',
  styleUrls: ['./mi-perfil.component.scss'],
  standalone: true,
  imports: [
    IonIcon
  ]
})
export class MiPerfilPage  implements OnInit {

  constructor() { }

  ngOnInit() {}

}

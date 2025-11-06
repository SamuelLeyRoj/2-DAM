import { Component, OnInit } from '@angular/core';
import {IonIcon} from "@ionic/angular/standalone";
import { IonicModule } from '@ionic/angular';
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

  constructor() { }

  ngOnInit() {}

}

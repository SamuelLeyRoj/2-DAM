import {Component, Input, OnInit} from '@angular/core';
import {
  IonAvatar,
  IonCard,
  IonCardContent,
  IonCardHeader,
  IonCardSubtitle,
  IonCardTitle, IonIcon,
  IonItem,
  IonLabel,
  IonList,
  IonThumbnail,
} from '@ionic/angular/standalone';

@Component({
  selector: 'app-buscar-usuarios',
  templateUrl: './buscar-usuarios.component.html',
  styleUrls: ['./buscar-usuarios.component.scss'],
  standalone: true,
  imports: [

    IonIcon,
  ],

})
export class BuscarUsuariosComponent  implements OnInit {

  constructor() { }

  @Input() nombreUsuario: string = "Usuario";

  @Input() imagenUsuario: string = "assets/img/cuenta.png";

  ngOnInit() {}

}

import {Component, inject, OnInit} from '@angular/core';
import {BotonGrandeAccionComponent} from "../boton-grande-accion/boton-grande-accion.component";
import {IonIcon} from "@ionic/angular/standalone";
import {NavController} from "@ionic/angular";
import {Ropa} from "../../models/Ropa";
import {RopaService} from "../../services/Ropa-Service";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-mi-ropa-intercambio-ypendientes',
  templateUrl: './mi-ropa-intercambio-ypendientes.component.html',
  styleUrls: ['./mi-ropa-intercambio-ypendientes.component.scss'],
  standalone: true,
  imports: [

    IonIcon,
    NgForOf
  ]
})
export class MiRopaIntercambioYPendientesComponent  implements OnInit {

  ropa: Ropa[] = [];
  private service = inject(RopaService);

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private navCtrl: NavController) { }

  ngOnInit() {
    this.service.consultarRopaUnicoUsuario().subscribe({
      next: (data) => this.ropa = data,
      error: error => console.log(error)
    });
  }

  irRopa() {
    this.navCtrl.navigateForward('/misPrendas');
  }
}

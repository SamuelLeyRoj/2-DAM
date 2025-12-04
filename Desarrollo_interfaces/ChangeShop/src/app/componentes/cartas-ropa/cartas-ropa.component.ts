import {Component, inject, OnInit} from '@angular/core';
import {IonIcon} from "@ionic/angular/standalone";
import {NavController} from "@ionic/angular";
import {Ropa} from "../../models/Ropa";
import { CommonModule } from '@angular/common';
import {RopaService} from "../../services/Ropa-Service";

@Component({
  selector: 'app-cartas-ropa',
  templateUrl: './cartas-ropa.component.html',
  styleUrls: ['./cartas-ropa.component.scss'],
  standalone: true,
  imports: [
    IonIcon,CommonModule
  ]
})
export class CartasRopaComponent implements OnInit {
  ropa: Ropa[] = [];
  private service = inject(RopaService);
  private navCtrl = inject(NavController);

  ngOnInit() {
    this.service.consultarRopa().subscribe({
      next: (data) => this.ropa = data,
      error: error => console.log(error)
    });
  }

  irInformacionRopa() {
    this.navCtrl.navigateForward('/ropaInformacion');
  }
}

import { Component, OnInit, Input } from '@angular/core';
import { CommonModule } from "@angular/common";
import { IonicModule } from "@ionic/angular";

@Component({
  selector: 'app-boton-grande-accion',
  templateUrl: './boton-grande-accion.component.html',
  styleUrls: ['./boton-grande-accion.component.scss'],
  standalone: true,
  imports: [CommonModule, IonicModule],
})
export class BotonGrandeAccionComponent implements OnInit {

  @Input() texto: string = "Botón";
  @Input() colorTexto: string = 'white';


  constructor() { }

  ngOnInit() {}
}

import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {IonButton, IonIcon, IonImg, IonInput, IonSelect, IonSelectOption} from "@ionic/angular/standalone";
import {FormsModule} from "@angular/forms";
import { CommonModule } from '@angular/common';
import {BotonGrandeAccionComponent} from "../boton-grande-accion/boton-grande-accion.component";
import {NavController} from "@ionic/angular";

@Component({
  selector: 'app-formulario-subir-ropa',
  templateUrl: './formulario-subir-ropa.component.html',
  styleUrls: ['./formulario-subir-ropa.component.scss'],
  standalone: true,
  imports: [
    IonSelect,
    IonSelectOption,
    FormsModule,
    IonImg,
    CommonModule,
    IonIcon,

  ]
})
export class FormularioSubirRopaComponent  implements OnInit {

  frutasSeleccionadas = '';
  tallaSeleccionada: string | null = null;   // nueva variable para la talla
  tipoRopaSeleccionada: string | null = null; // nueva variable para el tipo de ropa

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private navCtrl: NavController) { }

  ngOnInit() {}

  @ViewChild('inputImagen') inputImagen!: ElementRef<HTMLInputElement>;
  imagenPreview: string | ArrayBuffer | null = null;

  volver(){
    this.navCtrl.navigateForward('/comprarRopa')
  }

  seleccionarImagen() {
    this.inputImagen.nativeElement.click(); // simula el click en el input oculto
  }

  onFileSelected(event: Event) {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files[0]) {
      const file = input.files[0];
      const reader = new FileReader();
      reader.onload = () => {
        this.imagenPreview = reader.result; // guardamos la imagen para mostrarla
      };
      reader.readAsDataURL(file);
    }
  }

}

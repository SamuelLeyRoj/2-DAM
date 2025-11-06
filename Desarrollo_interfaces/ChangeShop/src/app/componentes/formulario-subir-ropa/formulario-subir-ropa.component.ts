import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {IonButton, IonImg, IonInput, IonSelect, IonSelectOption} from "@ionic/angular/standalone";
import {FormsModule} from "@angular/forms";
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-formulario-subir-ropa',
  templateUrl: './formulario-subir-ropa.component.html',
  styleUrls: ['./formulario-subir-ropa.component.scss'],
  standalone: true,
  imports: [
    IonInput,
    IonSelect,
    IonSelectOption,
    FormsModule,
    IonButton,
    IonImg,
    CommonModule
  ]
})
export class FormularioSubirRopaComponent  implements OnInit {




  frutasSeleccionadas = '';

  constructor() { }

  ngOnInit() {}
  @ViewChild('inputImagen') inputImagen!: ElementRef<HTMLInputElement>;
  imagenPreview: string | ArrayBuffer | null = null;

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

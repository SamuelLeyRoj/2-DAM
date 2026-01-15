import { Component, OnInit } from '@angular/core';
import {
  IonIcon,
  IonImg, IonInput,
  IonSelect,
  IonSelectOption
} from '@ionic/angular/standalone';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NavController } from '@ionic/angular';
import { RopaService } from '../../services/Ropa-Service';

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
    IonInput
  ]
})
export class FormularioSubirRopaComponent implements OnInit {

  // Añadimos variable para el nombre
  nombrePrendaInput: string = '';
  imagenUrl: string = '';
  tallaSeleccionada: string | null = null;
  tipoRopaSeleccionada: string | null = null;

  constructor(
    private navCtrl: NavController,
    private ropaService: RopaService
  ) {}

  ngOnInit() {}

  subirRopa() {
    // Validamos que todos los campos tengan datos
    if (!this.nombrePrendaInput || !this.imagenUrl || !this.tallaSeleccionada || !this.tipoRopaSeleccionada) {
      alert('Por favor, completa todos los campos (Nombre, Foto, Talla y Estilo)');
      return;
    }

    const nuevaRopa = {
      // Usamos el nombre del input
      nombre: this.nombrePrendaInput,
      foto: this.imagenUrl,
      talla: this.tallaSeleccionada,
      // Esto ahora enviará 'CASUAL', 'URBANO', etc. (lo que le gusta a tu BD)
      estilo: this.tipoRopaSeleccionada,
      estado: 'disponible'
    };

    console.log('Enviando datos:', nuevaRopa); // Para depurar

    this.ropaService.crearRopa(nuevaRopa).subscribe({
      next: () => {
        alert('¡Prenda subida correctamente!');
        this.navCtrl.navigateForward('/misPrendas');
      },
      error: err => {
        console.error('Error al subir:', err);
        // Muestra el mensaje real del servidor si existe
        alert('Error al subir: ' + (err.error?.message || 'Revisa los datos'));
      }
    });
  }

  volver() {
    this.navCtrl.navigateForward('/comprarRopa');
  }
}

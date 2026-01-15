
import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavController, AlertController } from "@ionic/angular"; // <--- 1. Importar AlertController
import { IonButton, IonIcon } from "@ionic/angular/standalone";
import { addIcons } from 'ionicons';
import { trashOutline, star, createOutline } from 'ionicons/icons'; // <--- 2. Importar createOutline (lápiz)
import { RopaService } from "../../services/Ropa-Service";
import { Ropa } from "../../models/Ropa";

@Component({
  selector: 'app-cartas-ropa',
  templateUrl: './cartas-ropa.component.html',
  styleUrls: ['./cartas-ropa.component.scss'],
  standalone: true,
  imports: [IonIcon, CommonModule, IonButton]
})
export class CartasRopaComponent implements OnInit {

  ropa: Ropa[] = [];
  private service = inject(RopaService);
  private navCtrl = inject(NavController);
  private alertCtrl = inject(AlertController); // <--- 3. Inyectar el AlertController

  constructor() {
    // 4. Registrar el icono del lápiz
    addIcons({ trashOutline, star, createOutline });
  }

  ngOnInit() {
    this.cargarRopa();
  }

  cargarRopa() {
    this.service.consultarRopa().subscribe({
      next: (data) => this.ropa = data,
      error: error => console.error('Error cargando ropa:', error)
    });
  }

  irInformacionRopa() {
    this.navCtrl.navigateForward('/ropaInformacion');
  }

  borrarPrenda(id: number | undefined, event: Event) {
    event.stopPropagation();
    event.stopImmediatePropagation();
    // ... tu código de borrar ...
    if (!id) return;
    if (!confirm('¿Seguro que quieres eliminar?')) return;

    this.service.eliminarRopa(id).subscribe({
      next: () => this.ropa = this.ropa.filter(r => r.id !== id),
      error: (err) => console.error(err)
    });
  }

  // --- 5. NUEVA FUNCIÓN: POPUP DE EDICIÓN ---
  async abrirEditar(item: Ropa, event: Event) {
    // Evitamos que se abra la página de detalles al hacer click
    event.stopPropagation();
    event.stopImmediatePropagation();

    const alert = await this.alertCtrl.create({
      header: 'Editar Ropa',
      inputs: [
        {
          name: 'nombre',
          type: 'text',
          placeholder: 'Nombre',
          value: item.nombre // Pre-cargamos el valor actual
        },
        {
          name: 'estilo',
          type: 'text',
          placeholder: 'Estilo',
          value: item.estilo
        },
        {
          name: 'foto',
          type: 'url',
          placeholder: 'URL de la foto',
          value: item.foto
        }
      ],
      buttons: [
        {
          text: 'Cancelar',
          role: 'cancel'
        },
        {
          text: 'Guardar',
          handler: (data) => {
            // 'data' contiene los nuevos valores escritos en el popup
            this.guardarEdicion(item.id, data);
          }
        }
      ]
    });

    await alert.present();
  }

  // Función auxiliar para llamar al servicio
  guardarEdicion(id: number | undefined, nuevosDatos: any) {
    if (!id) return;

    // Mezclamos los datos viejos con los nuevos
    const ropaActualizada: Ropa = {
      id: id,
      nombre: nuevosDatos.nombre,
      estilo: nuevosDatos.estilo,
      foto: nuevosDatos.foto
      // Añade aquí otros campos si son necesarios (talla, estado, etc.)
    };

    this.service.actualizarRopa(id, ropaActualizada).subscribe({
      next: (resp) => {
        console.log('Actualizado correctamente');
        // Actualizamos la lista localmente para ver el cambio al instante
        const index = this.ropa.findIndex(r => r.id === id);
        if (index > -1) {
          this.ropa[index] = resp;
        }
      },
      error: (err) => {
        console.error('Error al actualizar', err);
        alert('No se pudo actualizar la prenda.');
      }
    });
  }
}

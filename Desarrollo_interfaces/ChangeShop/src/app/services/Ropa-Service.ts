import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ropa } from '../models/Ropa';

@Injectable({
  providedIn: 'root'
})
export class RopaService {

  private http = inject(HttpClient);
  private apiUrl = '/api/ropa';

  consultarRopa(): Observable<Ropa[]> {
    return this.http.get<Ropa[]>(`${this.apiUrl}/all`);
  }

  consultarRopaUnicoUsuario(): Observable<Ropa[]> {
    return this.http.get<Ropa[]>(`${this.apiUrl}/1`);
  }

  crearRopa(ropa: Ropa): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}/crear/1`, ropa);
  }

  // --- NUEVO: Función para borrar ---
  eliminarRopa(id: number): Observable<void> {
    // Esto llama a @DeleteMapping("/{id}") en tu Java
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  // AGREGAR ESTO:
  actualizarRopa(id: number, ropa: Ropa): Observable<Ropa> {
    return this.http.put<Ropa>(`${this.apiUrl}/${id}`, ropa);
  }
}

import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Ropa} from "../models/Ropa";

@Injectable({
  providedIn: 'root'
})
export class RopaService {
  private http = inject(HttpClient);
  private apiUrl = '/api/ropa';


  consultarRopa(): Observable<Ropa[]> {
    return this.http.get<Ropa[]>(`${this.apiUrl}/all`);
  }
}

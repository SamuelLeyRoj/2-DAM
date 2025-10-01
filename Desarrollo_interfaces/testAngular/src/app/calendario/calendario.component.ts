import { Component } from '@angular/core';
import { IonDatetime } from '@ionic/angular/standalone';

@Component({
  selector: 'app-calendario',
  templateUrl: './calendario.component.html',
  styleUrls: ['./calendario.component.scss'],
  imports: [
    IonDatetime
  ],
  standalone: true
})
export class CalendarioComponent {}




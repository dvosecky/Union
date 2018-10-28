import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CreateEventService {

  constructor(private http :HttpClient) { }

  createEvent() {
    headers :HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded'
    });
  }
}

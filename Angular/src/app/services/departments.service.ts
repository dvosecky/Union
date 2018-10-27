import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DepartmentsService {

  constructor(private http :HttpClient) { }

  getDepartments() {
    let headers :HttpHeaders = new HttpHeaders({ 
      'Content-Type': 'application/x-www-form-urlencoded'
    });
    return this.http.post('http://localhost:8085/Union/GetAllDepartments', '', {headers});
  }
}

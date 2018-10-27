import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http :HttpClient) { }

  getUsers() {
    let headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded'});

    return this.http.post("http://localhost:8085/Union/GetAllAccounts", "", {headers});
  }
}

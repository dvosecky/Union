import { Session } from './../session';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MyEventsService {

    constructor(private http :HttpClient, private session :Session) { }

    getEvents() {
        let headers = new HttpHeaders({
            'Content-Type': 'application/x-www-form-urlencoded'});
        console.log(this.session.id);
        return this.http.post("http://18.220.118.195:8085/Union/GetEventByLead", 
          'accountID='+this.session.id, {headers});
    }
}

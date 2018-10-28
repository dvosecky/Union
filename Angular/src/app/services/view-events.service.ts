import { Session } from './../session';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable()
export class ViewEventsService {

    constructor(private http :HttpClient, private session :Session) { }

    getEvents(account) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/x-www-form-urlencoded'});
        return this.http.post("http://localhost:8085/Union/GetEventByAccount", 
            "accountID=" + this.session.id, {headers})
    }
}
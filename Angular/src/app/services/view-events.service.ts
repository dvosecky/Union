import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable()
export class ViewEventsService {

    constructor(private http :HttpClient) { }

    getEvents() {
        let headers = new HttpHeaders({
            'Content-Type': 'application/x-www-form-urlencoded'});
        return this.http.post("http://localhost:8085/Union/GetAllEvents", "", {headers})
    }
}
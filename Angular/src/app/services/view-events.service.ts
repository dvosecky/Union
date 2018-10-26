import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable()
export class ViewEventsService {

    constructor(private http :HttpClient) { }

    getEvents() {
        let events = null;
        let headers = new HttpHeaders({
            'Content-Type': 'application/x-www-form-urlencoded'});

        this.http.post("http://18.220.118.195:8085/Union/GetAllEvents", "", {headers})
            .subscribe((data) => {
                console.log(data);
                events = data;
            }, (error) => {
                console.log(error);
            });
        return events;
    }
}
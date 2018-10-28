import { Session } from './../session';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CreateEventService {

  constructor(private http :HttpClient, private session :Session) { }

  createEvent(name, location, time, date, description) {
    let headers :HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded'
    });
    return this.http.post('http://18.220.118.195:8085/Union/AddEvent',
    'eventName=' + name + '&location=' + location + '&time=' + time +
        '&date=' + date + '&description=' + description + '&accountID=' + this.session.id, {headers});
  }
}
// eventname = request.getParameter("eventName");
// description = request.getParameter("description");
// location = request.getParameter("location");
// date = request.getParameter("date");
// time = request.getParameter("time")
import { Session } from './../session';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CreateEventService {

  constructor(private http :HttpClient, private session :Session) { }
  headers :HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/x-www-form-urlencoded'
  });

  createEvent(name, location, time, date, description) {
    let headers = this.headers;
    return this.http.post('http://18.220.118.195:8085/Union/AddEvent',
    'eventName=' + name + '&location=' + location + '&time=' + time +
        '&date=' + date + '&description=' + description + '&accountID=' + this.session.id, {headers});
  }

  createInvitation(inviteeId, eventId) {
    let headers = this.headers;
    console.log('session id' + this.session.id);
    return this.http.post('http://18.220.118.195:8085/Union/CreateInvitation',
      'acc_id=' + inviteeId + '&inv_ev_id=' +
        eventId + '&inv_priv_flag=0', {headers});
  }

  editEvent(name, location, time, date, description, eventId) {
    let headers :HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded'
    });
    return this.http.post('http://18.220.118.195:8085/Union/EventDetailChange',
    'eventName=' + name + '&location=' + location + '&time=' + time +
        '&date=' + date + '&description=' + description + '&accountID=' + this.session.id +
        '&ev_id=' + eventId, {headers});
  }
}

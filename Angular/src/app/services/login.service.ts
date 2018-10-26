import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Session } from '../session';

@Injectable()
export class LoginService {

    constructor(private http :HttpClient, private session :Session) { }

    login(email :String, password :String) {
        console.log("email: " + email);
        console.log("password: " + password);

        this.http.post("localhost:8085/Union/Login", "email=" + email + "&password=" + password)
            .subscribe((data) => {        
                console.log("received: " + data);
            }, (error) => {
                console.log("got error: " + error);
            });

    
    }
}
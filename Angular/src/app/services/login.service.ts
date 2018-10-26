import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class LoginService {

    constructor(private http :HttpClient) { }

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
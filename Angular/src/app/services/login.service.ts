import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Session } from '../session';

@Injectable()
export class LoginService {

    constructor(private http :HttpClient, private session :Session) { }

    login(email :String, password :String) {
        console.log("email: " + email);
        console.log("password: " + password);
        // this.http.get("http://localhost:8085/Union/Login").subscribe(
        //     function() { console.log("get") },
        //     function() { console.log("geterror") }
        // );

        // this.http.post("http://localhost:8085/Union/Login", "email=" + email + "&password=" + password)
        this.http.post("http://localhost:8085/Union/Login", "email=" + email + "&password=" + password,
            {
            headers: new HttpHeaders({
              'Content-Type': 'application/x-www-form-urlencoded'
            })
          } )
            .subscribe((data) => {        
                console.log("received: " + data);
            }, (error) => {
                console.log("got error: " + error);
            });

    
    }
}
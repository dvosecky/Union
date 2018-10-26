import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Session } from '../session';

@Injectable()
export class LoginService {

    constructor(private http :HttpClient, private session :Session) { }

    login(email :String, password :String) {
        console.log("email: " + email);
        console.log("password: " + password);

        this.http.post("http://18.220.118.195:8085/Union/Login", "email=" + email + "&password=" + password,
            {
            headers: new HttpHeaders({
              'Content-Type': 'application/x-www-form-urlencoded'})
            }).subscribe((data) => {       
               
                console.log(data);

                // { id: 3200, username: "c", password: "c", firstname: "c", lastname: "c", dep: 1, role: 0 }
                this.session.id = data['id'];
                if (data['role'] === 0) {
                    this.session.role = 'emp';
                } else if (data['role'] === 1) {
                    this.session.role = 'dh';
                } else if (data['role'] === 2) {
                    this.session.role = 'admin';
                }
                
            }, (error) => {
                console.log(error);
            });

    }
}
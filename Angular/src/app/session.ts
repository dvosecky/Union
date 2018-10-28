import { Injectable } from "@angular/core";

@Injectable()
export class Session {
    id :number = 100;
    role :string = 'admin';
    event = null;
}
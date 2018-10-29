import { Injectable } from "@angular/core";

@Injectable()
export class Session {
    id :number = 1;
    role :string = 'admin';
    event = null;
}
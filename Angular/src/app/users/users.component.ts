import { Session } from './../session';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  constructor(private session :Session) { }

  ngOnInit() {

    window.scrollTo(0, 0);

  }



}

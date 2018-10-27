import { Session } from './../session';
import { Component, OnInit } from '@angular/core';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  constructor(private session :Session, private service :UsersService) { }

  users;

  ngOnInit() {

    window.scrollTo(0, 0);
    this.service.getUsers().subscribe(
      (data) => {
        this.users = data;
        console.log(data);
      }, (error) => {
        console.log(error);
      }
    )

  }



}

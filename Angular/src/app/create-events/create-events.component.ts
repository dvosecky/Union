import { Component, OnInit } from '@angular/core';
import { Session } from '../session';

@Component({
  selector: 'app-create-events',
  templateUrl: './create-events.component.html',
  styleUrls: ['./create-events.component.css']
})
export class CreateEventsComponent implements OnInit {

  constructor(private session :Session) { }

  admin :boolean;
  emp :boolean;

  ngOnInit() {

    window.scrollTo(0, 0);
    if (this.session.role === 'admin') {
      this.admin = true;
    } else if (this.session.role === 'emp') {
      this.emp = true;
    }
  }

}

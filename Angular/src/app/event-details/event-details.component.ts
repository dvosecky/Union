import { Component, OnInit } from '@angular/core';
import { Session } from '../session';

@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  styleUrls: ['./event-details.component.css']
})
export class EventDetailsComponent implements OnInit {

    constructor(private session :Session) { }

    admin :boolean = false;
    emp :boolean = false;
    event;

    ngOnInit() {
      window.scrollTo(0, 0);
      if (this.session.role === 'admin') {
        this.admin = true;
      } else if (this.session.role === 'emp') {
        this.emp = true;
      }

      this.event = this.session.event;
      this.session.event = null;
    }
  }

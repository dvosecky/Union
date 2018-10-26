import { ViewEventsService } from './../services/view-events.service';
import { Component, OnInit } from '@angular/core';
import { Session } from '../session';

@Component({
  selector: 'app-view-events',
  templateUrl: './view-events.component.html',
  styleUrls: []
})
export class ViewEventsComponent implements OnInit {

  constructor(private session :Session, private service :ViewEventsService) { }

  admin :boolean = false;
  emp :boolean = false;
  events;

  ngOnInit() {

    window.scrollTo(0, 0);
    if (this.session.role === 'admin') {
      this.admin = true;
    } else if (this.session.role === 'emp') {
      this.emp = true;
    }

    // get the list of events
    this.events = this.service.getEvents();
  }

}

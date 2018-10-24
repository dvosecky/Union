import { Component, OnInit } from '@angular/core';
import { Session } from '../session';

@Component({
  selector: 'app-view-events',
  templateUrl: './view-events.component.html',
  styleUrls: ['./view-events.component.css']
})
export class ViewEventsComponent implements OnInit {

  constructor(private session :Session) { }

  admin :boolean = false;
  emp :boolean = false;

  ngOnInit() {
    console.log(this.session.role);

    window.scrollTo(0, 0);
    if (this.session.role === 'admin') {
      this.admin = true;
    } else if (this.session.role === 'emp') {
      this.emp = true;
    }
  }

}

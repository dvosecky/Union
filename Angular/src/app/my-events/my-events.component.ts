import { MyEventsService } from './../services/my-events.service';
import { Component, OnInit } from '@angular/core';
import { Session } from '../session';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-my-events',
  templateUrl: './my-events.component.html',
  styleUrls: []
})
export class MyEventsComponent implements OnInit {

  constructor(private session :Session, private service :MyEventsService,
              private router :Router, private route :ActivatedRoute) { }

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
    this.service.getEvents().subscribe(
      (data) => {
        this.events = data;
        console.log(this.events);
      }, (error) => {
        console.log(error);
      }
    );
    
  }

  editEvent(event) {
    this.router.navigate(['../create-events']);
    this.session.event = event;
  }

}

import { Component, OnInit } from '@angular/core';
import { Session } from '../session';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-create-events',
  templateUrl: './create-events.component.html',
  styleUrls: ['./create-events.component.css']
})
export class CreateEventsComponent implements OnInit {

  constructor(private session: Session, private router :Router, 
              private route :ActivatedRoute) { }

  admin: boolean;
  emp: boolean;
  event = null;

  name :string;
  location :string;
  time;
  date;
  description;

  ngOnInit() {
    if (this.session.event != null) {
      this.event = event;
    }

    window.scrollTo(0, 0);
    if (this.session.role === 'admin') {
      this.admin = true;
    } else if (this.session.role === 'emp') {
      this.emp = true;
    }
  }

  submit() {
    if (this.name === undefined || this.name === '') {
      alert('Event must have a name');
    }
    console.log(
      "name: " + this.name + ", location: " + this.location + ", time: " + 
        this.time + ", date: " + this.date + ", description: " + this.description);
    alert('Event Created!');
    this.router.navigate(['../my-events'], { relativeTo: this.route });
  }
}

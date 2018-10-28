import { Component, OnInit } from '@angular/core';
import { Session } from '../session';
import { Router, ActivatedRoute } from '@angular/router';
import { CreateEventService } from '../services/create-event.service';

@Component({
  selector: 'app-create-events',
  templateUrl: './create-events.component.html',
  styleUrls: ['./create-events.component.css']
})
export class CreateEventsComponent implements OnInit {

  constructor(private session: Session, private router :Router, 
              private route :ActivatedRoute, private service :CreateEventService) { }

  admin: boolean;
  emp: boolean;
  edit: boolean = false;

  name :string;
  location :string;
  time;
  date;
  description;

  ngOnInit() {
    if (this.session.event != null) {
      this.edit = true;
      console.log(event);
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
      
    this.service.createEvent(this.name, this.location, this.time, this.date, this.description).subscribe(
      (data) => {
        console.log(data);
      }, (error) => {
        console.log(error);
      }
    )
    alert('Event Created!');
    this.router.navigate(['../my-events'], { relativeTo: this.route });
  }
}

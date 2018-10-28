import { DepartmentsService } from './../services/departments.service';
import { Component, OnInit } from '@angular/core';
import { Session } from '../session';
import { Router, ActivatedRoute } from '@angular/router';
import { CreateEventService } from '../services/create-event.service';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-create-events',
  templateUrl: './create-events.component.html',
  styleUrls: ['./create-events.component.css']
})
export class CreateEventsComponent implements OnInit {

  constructor(private session: Session, private router :Router, 
              private route :ActivatedRoute, private service :CreateEventService,
              private userService :UsersService, private depService :DepartmentsService) { }

  admin: boolean;
  emp: boolean;
  edit: boolean = false;
  title: string = "Add A New Event";
  subtitle: string = "Enter the information below to add a new event";

  name :string = "testname";
  location :string = 'testLocation';
  time = "03:03";
  date = "2018-03-09";
  description = 'testDesc';
  users;
  departments;
  inviteesBool = [];

  ngOnInit() {
    if (this.session.event != null) {
      this.edit = true;
      this.title = 'Edit Your Event';
      this.subtitle = 'Update the fields below to edit your event';
      let event = this.session.event;
      console.log(event);
      this.name = event.name;
      this.location = event.location;
      let ISO :string = event.datetime.toISOString();
      this.time = ISO.substring(11,16);
      this.date = ISO.substring(0,10);
      this.description = event.description;
      this.session.event = null;
    }

    window.scrollTo(0, 0);
    if (this.session.role === 'admin') {
      this.admin = true;
    } else if (this.session.role === 'emp') {
      this.emp = true;
    }

    this.userService.getUsers().subscribe(
      (data) => {
        console.log(data);
        this.users = data;
      }, (error) => {
        console.log(error);
      }
    );
    this.depService.getDepartments().subscribe(
      (data) => {
        console.log(data);
        this.departments = data;
      }, (error) => {
        console.log(error);
      }
    );
  }

  submit() {
    let invitees = [];
    console.log(this.inviteesBool);
    for (let i = 0; i < this.inviteesBool.length; i++) {
      if (this.inviteesBool[i] === true) {
        invitees.push(this.users[i]);
      }
    }
    console.log(invitees);

    console.log(
      "name: " + this.name + ", location: " + this.location + ", time: " + 
        this.time + ", date: " + this.date + ", description: " + this.description);
      

    if (this.edit === true) { 
      // NOT IMPLEMENTED
      // this.service.editEvent(this.name, this.location, this.time, this.date, this.description).subscribe(
      //   (data) => {
      //     console.log(data);
      //   }, (error) => {
      //     console.log(error);
      //   }
      // );
      // alert('Event Updated!');
    } else {
      this.service.createEvent(this.name, this.location, this.time, this.date, this.description).subscribe(
        (data) => {
          console.log(data);
          invitees.forEach(invitee => {
            this.service.createInvitation(invitee.id, data['eventid']);
          });
          
        }, (error) => {
          console.log(error);
        }
      );
      alert('Event Created!');

      
    }
    //this.router.navigate(['../my-events'], { relativeTo: this.route });
  }
}

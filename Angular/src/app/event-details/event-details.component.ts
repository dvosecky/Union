import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Session } from '../session';

@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  styleUrls: ['./event-details.component.css']
})
export class EventDetailsComponent implements OnInit {
  email :string;
  password :string;

  constructor(private router :Router, private route: ActivatedRoute,
              private session :Session) { }

  private validateEmail() {
    if (this.email === undefined || this.email === "") {
      return false;
    }
    return true;
  }

  private validatePassword() {
    if (this.password == undefined || this.password === "") {
      return false;
    }
    return true;
  }

  onSubmit() {
    if (!this.validateEmail() || !this.validatePassword()) {
      alert('Invalid email or password');
      return;
    }

    // send httpRequest to get user information, including user type, which
    // we need to know to determine which welcome page to go to"

    if (this.email === "admin") {
      this.session.role = 'admin';
      this.router.navigate(['../admin-welcome'], { relativeTo: this.route });
    } else {
      this.session.role = 'emp';
      this.router.navigate(['../emp-welcome'], { relativeTo: this.route });
    }
  }

  ngOnInit() {
    window.scrollTo(0, 0);
  }

  }

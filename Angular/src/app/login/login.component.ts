import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

// NEED TO VALIDATE INPUT

export class LoginComponent implements OnInit {
  email :string;
  password :string;
  
  constructor(private router :Router, private route: ActivatedRoute) { }

  onSubmit() {
    // request code
    alert("email: " + this.email + ", password: " + this.password);
    // send httpRequest to get user information, including user type, which 
    // we need to know to determine which welcome page to go to"
    
    // this.router.navigate(['../emp-welcome'], { relativeTo: this.route });
  }

  ngOnInit() {
  }

}

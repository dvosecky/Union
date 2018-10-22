import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-emp-welcome',
  templateUrl: './emp-welcome.component.html',
  styleUrls: ['./emp-welcome.component.css']
})
export class EmpWelcomeComponent implements OnInit {

  constructor(private router :Router, private route :ActivatedRoute) { }

  logout() {
    this.router.navigate(['../login'], { relativeTo: this.route });
  }

  ngOnInit() {
  }

}

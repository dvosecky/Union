import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-emp-navbar',
  templateUrl: './emp-navbar.component.html',
  styleUrls: ['./emp-navbar.component.css']
})
export class EmpNavbarComponent implements OnInit {

  constructor(private router :Router, private route :ActivatedRoute) { }

  logout() {
    window.scrollTo(0, 0);
    this.router.navigate(['../login'], { relativeTo: this.route });
  }

  ngOnInit() {
  }

}

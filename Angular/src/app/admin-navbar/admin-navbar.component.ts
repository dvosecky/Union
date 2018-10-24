import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-admin-navbar',
  templateUrl: './admin-navbar.component.html',
  styleUrls: ['./admin-navbar.component.css']
})
export class AdminNavbarComponent implements OnInit {

  constructor(private router :Router, private route :ActivatedRoute) { }

  logout() {
    window.scrollTo(0,0);
    this.router.navigate(['../login'], { relativeTo: this.route });
  }

  ngOnInit() {
  }

}

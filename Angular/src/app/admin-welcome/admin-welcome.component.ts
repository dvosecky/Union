import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-welcome',
  templateUrl: './admin-welcome.component.html',
  styleUrls: ['./admin-welcome.component.css']
})
export class AdminWelcomeComponent implements OnInit {

  constructor(private router :Router, private route :ActivatedRoute) { }

  logout() {
    this.router.navigate(['../login'], { relativeTo: this.route });
  }

  ngOnInit() {
  }

}

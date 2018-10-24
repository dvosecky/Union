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
    this.invisibleNavBar();

    window.addEventListener("scroll", this.updateNavBar);
  }

  invisibleNavBar() {
    var nav = document.querySelector(".navbar")
    nav.setAttribute('style', 'visibility: hidden');
    nav.classList.add('navbar-ontop');
  }
	
	updateNavBar() {

    var nav = document.querySelector(".navbar");
    var className = "navbar-ontop";

		if (window.scrollY > 30) {
      nav.classList.remove(className)
      nav.setAttribute('style', 'visibility: visible');
    } else {
      nav.classList.add(className) 
    }
	}


}


import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-welcome',
  templateUrl: './admin-welcome.component.html',
  styleUrls: ['./admin-welcome.component.css']
})
export class AdminWelcomeComponent implements OnInit {

  constructor() { }

  

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

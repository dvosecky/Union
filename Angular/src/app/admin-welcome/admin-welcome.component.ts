
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-welcome',
  templateUrl: './admin-welcome.component.html',
  styleUrls: ['./admin-welcome.component.css']
})
export class AdminWelcomeComponent implements OnInit {

  constructor() { }

  

  ngOnInit() {
    window.scrollTo(0, 0);
    setTimeout(() => {
      this.invisibleNavBar();
      window.addEventListener("scroll", this.updateNavBar);
    }
    , 20);

  }

  invisibleNavBar() {
    var nav = document.querySelector(".navbar")
    nav.setAttribute('style', 'visibility: hidden; opacity: 0 !important;');
  }
	
	updateNavBar() {
    let nav = document.querySelector(".navbar");

		if (window.scrollY > 30) {
      nav.setAttribute('style', 'visibility: visible');
      nav.setAttribute('style', '');
    } else {
      nav.setAttribute('style', 'opacity: 0 !important;');
    }
	}

}

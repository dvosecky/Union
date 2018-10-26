import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-emp-welcome',
  templateUrl: './emp-welcome.component.html',
  styleUrls: ['./emp-welcome.component.css']
})
export class EmpWelcomeComponent implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    window.scrollTo(0, 0);
    setTimeout(() => {
      this.invisibleNavBar();
      window.addEventListener("scroll", this.updateNavBar);
    }
      , 10);
  }

  ngOnDestroy() {
    window.removeEventListener("scroll", this.updateNavBar);
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

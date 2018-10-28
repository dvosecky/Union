import { DepartmentsService } from './../services/departments.service';
import { Session } from './../session';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-departments',
  templateUrl: './departments.component.html',
  styleUrls: ['./departments.component.css']
})
export class DepartmentsComponent implements OnInit {

  constructor(private session :Session, private service :DepartmentsService) { }

  admin :boolean = false;
  emp :boolean = false;

  departments;

  ngOnInit() {

    window.scrollTo(0, 0);
    if (this.session.role === 'admin') {
      this.admin = true;
    } else if (this.session.role === 'emp') {
      this.emp = true;
    }

    this.service.getDepartments().subscribe(
      (data) => {
        this.departments = data;
        console.log(data);
      }, (error) => {
        console.log(error);
      } 
    )
  }
}

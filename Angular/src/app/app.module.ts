import { ViewEventsService } from './services/view-events.service';
import { appRoutes } from './routes';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { EmpWelcomeComponent } from './emp-welcome/emp-welcome.component';
import { AdminWelcomeComponent } from './admin-welcome/admin-welcome.component';
import { ViewEventsComponent } from './view-events/view-events.component';
import { MyEventsComponent } from './my-events/my-events.component';

import { EmpNavbarComponent } from './emp-navbar/emp-navbar.component';
import { AdminNavbarComponent } from './admin-navbar/admin-navbar.component';
import { Session } from './session';
import { EventDetailsComponent } from './event-details/event-details.component';
import { ApproveEventsComponent } from './approve-events/approve-events.component';
import { CreateEventsComponent } from './create-events/create-events.component';
import { DhWelcomeComponent } from './dh-welcome/dh-welcome.component';

import { LoginService } from './services/login.service';

import { HttpClientModule } from '@angular/common/http';
import { UsersComponent } from './users/users.component';
import { DepartmentsComponent } from './departments/departments.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EmpWelcomeComponent,
    AdminWelcomeComponent,
    ViewEventsComponent,
    EmpNavbarComponent,
    AdminNavbarComponent,
    EventDetailsComponent,
    ApproveEventsComponent,
    CreateEventsComponent,
    DhWelcomeComponent,
    MyEventsComponent,
    UsersComponent,
    DepartmentsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule
  ],
  providers: [Session, LoginService, ViewEventsService],
  bootstrap: [AppComponent]
})
export class AppModule { }

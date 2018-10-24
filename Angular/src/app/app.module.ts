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
import { EmpNavbarComponent } from './emp-navbar/emp-navbar.component';
import { AdminNavbarComponent } from './admin-navbar/admin-navbar.component';
import { Session } from './session';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EmpWelcomeComponent,
    AdminWelcomeComponent,
    ViewEventsComponent,
    EmpNavbarComponent,
    AdminNavbarComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [Session],
  bootstrap: [AppComponent]
})
export class AppModule { }

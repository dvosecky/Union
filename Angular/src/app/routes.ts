import { AdminWelcomeComponent } from './admin-welcome/admin-welcome.component';
import { EmpWelcomeComponent } from './emp-welcome/emp-welcome.component';
import { LoginComponent } from './login/login.component';
import {ViewEventsComponent} from './view-events/view-events.component';
import {EventDetailsComponent} from './event-details/event-details.component';
import { Routes } from '@angular/router';

export const appRoutes: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'emp-welcome', component: EmpWelcomeComponent},
    { path: 'admin-welcome', component: AdminWelcomeComponent},
    {path: 'view-events', component: ViewEventsComponent},
    {path: 'event-details', component: EventDetailsComponent},
    { path: '',
      redirectTo: 'login',
      pathMatch: 'full' // what is this for?
    },
    { path: '**', redirectTo: '' }
  ];

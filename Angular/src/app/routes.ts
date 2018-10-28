import { MyEventsComponent } from './my-events/my-events.component';
import { UsersComponent } from './users/users.component';
import { DepartmentsComponent } from './departments/departments.component';
import { AdminWelcomeComponent } from './admin-welcome/admin-welcome.component';
import { EmpWelcomeComponent } from './emp-welcome/emp-welcome.component';
import { LoginComponent } from './login/login.component';
import {ViewEventsComponent} from './view-events/view-events.component';
import {EventDetailsComponent} from './event-details/event-details.component';
import {ApproveEventsComponent} from './approve-events/approve-events.component';
import {CreateEventsComponent} from './create-events/create-events.component';
import {DhWelcomeComponent} from './dh-welcome/dh-welcome.component';

import { Routes } from '@angular/router';

export const appRoutes: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'emp-welcome', component: EmpWelcomeComponent},
    { path: 'admin-welcome', component: AdminWelcomeComponent},
    {path: 'view-events', component: ViewEventsComponent},
    {path: 'my-events', component: MyEventsComponent},
    {path: 'event-details', component: EventDetailsComponent},
    {path: 'approve-events', component: ApproveEventsComponent},
    {path: 'create-events', component: CreateEventsComponent},
    {path: 'dh-welcome', component: DhWelcomeComponent},
    {path: 'users', component: UsersComponent},
    {path: 'departments', component: DepartmentsComponent},

    { path: '',
      redirectTo: 'login',
      pathMatch: 'full' // what is this for?
    },
    { path: '**', redirectTo: '/' }
  ];

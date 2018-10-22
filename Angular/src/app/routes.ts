import { AdminWelcomeComponent } from './admin-welcome/admin-welcome.component';
import { EmpWelcomeComponent } from './emp-welcome/emp-welcome.component';
import { LoginComponent } from './login/login.component';
import { Routes } from '@angular/router';

export const appRoutes: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'emp-welcome', component: EmpWelcomeComponent},
    { path: 'admin-welcome', component: AdminWelcomeComponent},
    { path: '',
      redirectTo: 'login',
      pathMatch: 'full' // what is this for?
    }
    // { path: '**', component: PageNotFoundComponent }
  ];
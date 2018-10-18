import { WelcomeComponent } from './welcome/welcome.component';
import { LoginComponent } from './login/login.component';
import { Routes } from '@angular/router';

export const appRoutes: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'welcome', component: WelcomeComponent},
    { path: '',
      redirectTo: 'login',
      pathMatch: 'full' // what is this for?
    }
    // { path: '**', component: PageNotFoundComponent }
  ];
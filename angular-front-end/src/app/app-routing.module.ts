import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/components/admin.component';
import { HomeComponent } from './home/components/home.component';
import { LoginComponent } from './login/components/login.component';

const routes: Routes = [
  { path: 'first-component', component: HomeComponent },
  { path: 'second-component', component: AdminComponent },
];
    // ,
  //  {
  //    path: 'login', 
  //    component: LoginComponent,
  //    children: [{
  //      path: '',
  //      loadChildren: () => import('./admin/admin.module').then(module => module.AdminModule)
  //    }]    
  //   }
// ];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    useHash: true
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }

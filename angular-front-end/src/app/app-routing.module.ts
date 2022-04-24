import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/components/admin.component';
import { AllCoursesComponent } from './courses/components/all-courses/all-courses.component';
import { CoursesComponent } from './courses/components/courses.component'; 
import { SuggestionComponent } from './courses/components/suggestion/suggestion.component';
import { LoginComponent } from './login/components/login.component';
import { ProfileComponent } from './profile/components/profile.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'courses', component: CoursesComponent,
children: [
  { path: 'all', component: AllCoursesComponent },
  { path: 'suggestion', component: SuggestionComponent },
]},
  { path: 'admin', component: AdminComponent },
  { path: 'profil', component: ProfileComponent },
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
    useHash: false
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }

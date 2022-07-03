import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/components/admin.component';
import { AllCoursesComponent } from './course/components/all-courses/all-courses.component';
import { CourseComponent } from './course/components/course.component';
import { SuggestionComponent } from './course/components/suggestion/suggestion.component';
import { LoginComponent } from './login/components/login.component';
import { ProfileComponent } from './profile/components/profile.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'courses', component: CourseComponent,
children: [
  { path: 'all', component: AllCoursesComponent },
  { path: 'suggestion', component: SuggestionComponent },
]},
  { path: 'admin', component: AdminComponent },
  { path: 'profile', component: ProfileComponent },
  { path: '', redirectTo: 'courses', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    useHash: false
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseComponent } from './components/course.component';
import { SuggestionComponent } from './components/suggestion/suggestion.component';
import { AllCoursesComponent } from './components/all-courses/all-courses.component';
import { SharedModule } from '../shared/shared.module';
import { CourseRoutingModule } from './course-routing.module';


@NgModule({
  declarations: [CourseComponent, SuggestionComponent, AllCoursesComponent],
  imports: [
    CommonModule,
    CourseRoutingModule,
    SharedModule
  ],
  exports: [CourseComponent, SuggestionComponent, AllCoursesComponent]
})
export class CourseModule { }

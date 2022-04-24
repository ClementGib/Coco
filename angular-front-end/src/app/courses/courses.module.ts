import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CoursesRoutingModule } from './courses-routing.module';
import { CoursesComponent } from './components/courses.component';
import { SuggestionComponent } from './components/suggestion/suggestion.component';
import { AllCoursesComponent } from './components/all-courses/all-courses.component';
import { SharedModule } from '@shared/shared.module';

@NgModule({
  declarations: [CoursesComponent, SuggestionComponent, AllCoursesComponent],
  imports: [
    CommonModule,
    CoursesRoutingModule,
    SharedModule
  ],
  exports: [CoursesComponent, SuggestionComponent, AllCoursesComponent]
})
export class CoursesModule { }

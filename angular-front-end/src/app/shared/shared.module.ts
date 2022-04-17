import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import * as sharedComponents from './components'
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [...sharedComponents.components],
  imports: [CommonModule, RouterModule],
  exports: [...sharedComponents.components]
})
export class SharedModule { }

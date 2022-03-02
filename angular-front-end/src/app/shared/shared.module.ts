import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import * as sharedComponents from './components'

@NgModule({
  declarations: [...sharedComponents.components],
  imports: [CommonModule],
  exports: [...sharedComponents.components]
})
export class SharedModule { }

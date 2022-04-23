import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import * as sharedComponents from '.'
import { RouterModule } from '@angular/router';
@NgModule({
  declarations: [...sharedComponents.declarationComponents],
  imports: [CommonModule, RouterModule],
  exports: [...sharedComponents.exportComponents]
})
export class SharedModule { }

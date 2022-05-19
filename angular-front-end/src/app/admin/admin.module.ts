import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './components/admin.component';
import { SharedModule } from '@shared/shared.module';
import { SwaggerUiComponent } from './components/swagger-ui/swagger-ui.component';


@NgModule({
  declarations: [AdminComponent, SwaggerUiComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    SharedModule
  ],
  exports: [AdminComponent]
})
export class AdminModule { }

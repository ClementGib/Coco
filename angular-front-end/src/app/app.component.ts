import { Component, OnInit } from '@angular/core';
import { HomeComponent } from './home/components/home.component'; 

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})


export class AppComponent {
  public title = 'coco-front-end';
  public isAdmin: boolean;
  public env: String = "dev";

  constructor(){
    this.isAdmin = true;
  }


}

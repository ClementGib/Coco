import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})


export class AppComponent {
  public title = 'coco-front-end';
  public isAdmin: boolean;
  public env: String = "dev";

  constructor(private router: Router){
    this.isAdmin = true;
  }

  isCourses() {
    return this.router.url.includes("/courses");
  }

}

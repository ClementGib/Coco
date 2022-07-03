import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent {
  public isAdmin: boolean;
  public title = 'coco-front-end';
  public isCourses: boolean = false;
  public env: String = "dev";

  constructor(private router: Router){
    this.isAdmin = true;
    this.isCourses = this.router.url.includes('/courses');
    
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.isCourses = event.url.includes('/courses') ? true : false;
      }
    });
  }
}

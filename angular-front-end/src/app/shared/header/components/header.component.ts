import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationEnd, NavigationStart, Router } from '@angular/router';
import { filter } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  
  public isCourses: boolean = false;

  constructor(private router: Router) { 
    this.router.events.subscribe((event) => {
      if(event instanceof NavigationEnd) {
        this.isCourses = event.url.includes('/courses' ) ? true : false;
      }
    });
  }

  ngOnInit(): void {
    this.isCourses = this.router.url.includes('/courses');
  }
}

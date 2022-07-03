import { Component, HostListener, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'main-navbar',
  templateUrl: './main-navbar.component.html',
  styleUrls: ['./main-navbar.component.scss']
})
export class MainNavbarComponent implements OnInit {

  public isCourses: boolean = false;
  private navFixed: boolean = false;
  private scrollOffset: number = 70;

  constructor(private router: Router) {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.isCourses = event.url.includes('/courses') ? true : false;
      }
    });
  }

  ngOnInit(): void {
    this.isCourses = this.router.url.includes('/courses');
  }

  @HostListener('window:scroll')
  onWindowScroll() {
    this.navFixed = (window.pageYOffset
      || document.documentElement.scrollTop
      || document.body.scrollTop || 0) > this.scrollOffset;
  }
  
  disconnect(){}
}

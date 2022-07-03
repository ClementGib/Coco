import { Component, HostListener, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'main-navbar',
  templateUrl: './main-navbar.component.html',
  styleUrls: ['./main-navbar.component.scss']
})
export class MainNavbarComponent implements OnInit {


navFixed: boolean = false;
private scrollOffset: number = 70;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

@HostListener('window:scroll')
onWindowScroll() {
  this.navFixed = (window.pageYOffset 
    || document.documentElement.scrollTop 
    || document.body.scrollTop || 0) > this.scrollOffset;
}


  disconnect() {
    
  }

  isCourses() {
    return this.router.url.includes("/courses");
  }
}

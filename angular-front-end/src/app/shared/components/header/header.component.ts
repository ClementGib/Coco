import { Component, OnInit } from '@angular/core';
import { ButtonUnderlineComponent } from '@shared/components';
import { iconManager } from '../../../../assets/icons/iconManager';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}

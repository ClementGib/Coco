import { Component, OnInit } from '@angular/core';
import SwaggerUI from 'swagger-ui'


@Component({
  selector: 'app-swagger-ui',
  templateUrl: './swagger-ui.component.html',
  styleUrls: ['./swagger-ui.component.scss']
})
export class SwaggerUiComponent implements OnInit {

  constructor() { }


  ngOnInit(): void {
    SwaggerUI({
      domNode: document.getElementById('swagger-ui'),
      url: 'http://127.0.0.1:8080/coco/openapi'
    });
  }
}

import { Component, OnInit } from '@angular/core';
import { VersionService } from '@core/sevices/REST/version/version.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {

  version: string ='-';

  constructor(private readonly versionService: VersionService) { }

  ngOnInit(): void {
    this.versionService.getVersion().subscribe(version => this.version = version);
  }
}

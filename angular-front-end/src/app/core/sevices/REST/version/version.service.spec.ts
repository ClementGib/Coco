import { HttpClient } from '@angular/common/http';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { fakeAsync, flush, TestBed } from '@angular/core/testing';

import { VersionService } from './version.service';

describe('VersionService', () => {
  let service: VersionService;
  let httpClient: HttpClient;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [VersionService],
      imports: [HttpClientTestingModule]
    });
    service = TestBed.inject(VersionService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  describe('getVersion', () => {
    it('should do GET HTTP request', fakeAsync(() => {
      const versionNumber: string = '1.0';
      service.getVersion().subscribe(returnedVersion => expect(returnedVersion).toEqual(versionNumber));
      
      const controllerRequest = httpTestingController.expectOne(request => request.url === '/coco/version');
      expect(service).toBeTruthy();
      expect(controllerRequest.request.method).toBe('GET');

      controllerRequest.flush(versionNumber);
      flush();
      httpTestingController.verify();
    }));
  })
});

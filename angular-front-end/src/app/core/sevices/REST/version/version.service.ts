import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Endpoint } from '../endpoint/endpoint';

@Injectable({
  providedIn: 'root'
})

export class VersionService {
  protected endpoints: Map<string, Endpoint>;

  constructor(private http: HttpClient) {
    this.endpoints = new Map<string, Endpoint>([
      ["version", new Endpoint('/version', ['GET'])]
    ]);
  }

  public getVersion(): Observable<string> {
    const url = `${this.endpoints.get('version')?.root}`;
    return this.http.get(url, {responseType: 'text'})
  }
}

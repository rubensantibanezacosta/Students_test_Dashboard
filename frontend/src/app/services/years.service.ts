import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Year } from '../classes/year';



@Injectable({
  providedIn: 'root'
})
export class YearsService {
  httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) }
  endpoint: string = "http://localhost:8080";
  constructor(private httpClient: HttpClient) { }
  getYears(): Observable<Year[]> {
    return this.httpClient.get<Year[]>(this.endpoint);
  }

  addYear(year: Year): void {
    this.httpClient.post(this.endpoint, JSON.stringify(year), this.httpOptions)
  }
  
  deleteYear(year: Year): void {
    this.httpClient.delete(this.endpoint + "/" + JSON.stringify(year), this.httpOptions)
  }
}

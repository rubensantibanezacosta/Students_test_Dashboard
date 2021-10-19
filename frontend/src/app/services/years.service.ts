import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Year } from '../classes/year';



@Injectable({
  providedIn: 'root'
})
export class YearsService {
 
  httpOptions = { headers: new HttpHeaders({'Content-Type': 'application/json'}) }
  
  endpoint: string = "http://localhost:8080/years";
  constructor(private httpClient: HttpClient) { }

  getYears(): Observable<Year[]> {
    return this.httpClient.get<Year[]>(this.endpoint);
  }

  addYear(year: Year): void {
    console.log(year);
    this.httpClient.post(this.endpoint, {"year":year.year}, this.httpOptions).subscribe(()=>{window.location.reload()})
  }

  deleteYear(year: number): void {
    this.httpClient.delete(this.endpoint + "/" + year, this.httpOptions).subscribe((res)=>{
      console.log(res);
      window.location.reload()})
  }
}

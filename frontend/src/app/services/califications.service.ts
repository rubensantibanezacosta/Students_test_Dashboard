import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Califications } from '../classes/califications';

@Injectable({
  providedIn: 'root'
})
export class CalificationsService {

  endpoint = "http://localhost:8080/califications"
  httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) }

  constructor(private httpClient: HttpClient) { }

  getAllCalificationsByDni(dni: string, year: number): Observable<Califications[]> {
    return this.httpClient.get<Califications[]>(this.endpoint + "/" + dni + "/" + year);
  }
  deleteCalification(dni: string, subjectId: number, year: number) {

    return this.httpClient.delete(this.endpoint + "/" + dni + "/" + subjectId + "/" + year).subscribe(res => console.log(res));
  }
  addCalification(calification: Califications) {
    console.log(calification);
    return this.httpClient.post(this.endpoint, JSON.stringify(calification), this.httpOptions).subscribe((data) => {
      console.log(data);
    });
  }
}

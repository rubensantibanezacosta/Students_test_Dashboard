import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Subjects } from '../classes/subjects';

@Injectable({
  providedIn: 'root'
})
export class SubjectsService {
  httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) }
  endpoint: string = "http://localhost:8080/subjects";
  constructor(private httpClient: HttpClient) { }

  getSubjects(): Observable<Subjects[]> {
    return this.httpClient.get<Subjects[]>(this.endpoint);
  }
  getSubject(subject_id: string): Observable<Subjects> {
    return this.httpClient.get<Subjects>(this.endpoint + "/" + subject_id);
  }

  addSubject(subject: Subjects): void {
    this.httpClient.post(this.endpoint, JSON.stringify(subject), this.httpOptions)
  }
  deleteSubject(subject_id: string): void {
    this.httpClient.delete(this.endpoint + "/" + JSON.stringify(subject_id), this.httpOptions)
  }
}

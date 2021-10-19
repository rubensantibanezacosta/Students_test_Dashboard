import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../classes/student';

@Injectable({
  providedIn: 'root'
})
export class StudentsService {

  httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) }
  endpoint: string = "http://localhost:8080/students";
  constructor(private httpClient: HttpClient) { }

  getStudents(): Observable<Student[]> {
    return this.httpClient.get<Student[]>(this.endpoint);
  }
  getStudent(dni: string): Observable<Student> {
    return this.httpClient.get<Student>(this.endpoint + "/" + dni);
  }

  addStudent(student: Student): void {
    this.httpClient.post(this.endpoint, JSON.stringify(student), this.httpOptions).subscribe(res=>console.log(res))
  }
  deleteStudent(dni: string): void {
    this.httpClient.delete(this.endpoint + "/" + JSON.stringify(dni), this.httpOptions)
  }
}

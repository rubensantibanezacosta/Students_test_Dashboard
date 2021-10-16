import { Component, OnInit } from '@angular/core';
import { Califications } from '../classes/califications';
import { Student } from '../classes/student';
import { Subjects } from '../classes/subjects';
import { Year } from '../classes/year';
import { StudentsService } from '../services/students.service';
import { SubjectsService } from '../services/subjects.service';
import { YearsService } from '../services/years.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public students: Array<Student> = [];
  public years: Array<Year> = [];
  public califications: Array<Califications> = [];
  public fileIcon='../../assets/icons/file-blank-solid-24.png';
  public trashIcon='../../assets/icons/trash-solid-24.png';
  public editIcon='../../assets/icons/edit-solid-24.png'

  constructor(private yearsService:YearsService, private studentsService:StudentsService) { }
  ngOnInit(): void {
    this.studentsService.getStudents().subscribe((data)=>{
      this.students=data;
    })
    this.yearsService.getYears().subscribe((data)=>{
      this.years=data;
      console.log(data);
    });
  }
  }

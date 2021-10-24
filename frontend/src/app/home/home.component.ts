import { Component, OnInit } from '@angular/core';
import { NgForm, NgModel } from '@angular/forms';
import { Califications } from '../classes/califications';
import { Student } from '../classes/student';
import { Subjects } from '../classes/subjects';

import { Year } from '../classes/year';
import { CalificationsService } from '../services/califications.service';
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
  public subjects: Array<Subjects> = [];
  public selectedStudentDni: string = "";
  public selectedYearNumber: number = 0;
  public selectedSubjectid: number = 0;
  public selectedSubjectidToSend: number = 0;
  public media: number = 0;
  public suma: number = 0;
  public updating:boolean=false;
  public updatingCalificationValue=0;
  public updatingSubject=new Subjects();

  public fileIcon = '../../assets/icons/file-blank-solid-24.png';
  public trashIcon = '../../assets/icons/trash-solid-24.png';
  public editIcon = '../../assets/icons/edit-solid-24.png'
  public closeIcon = '../../assets/icons/x-regular-24.png'
  public saveIcon = '../../assets/icons/save-solid-24.png'



  constructor(private yearsService: YearsService, private studentsService: StudentsService, private calificationsService: CalificationsService, private subjectsService: SubjectsService) { }
  ngOnInit(): void {
    this.loadInfo();
  }

  loadInfo() {
    this.studentsService.getStudents().subscribe((data) => {
      this.students = data;
    })
    this.yearsService.getYears().subscribe((data) => {
      this.years = data;

    });
    this.subjectsService.getSubjects().subscribe((data) => {
      this.subjects = data;
    })
  }

  searchCalificationsByStudentDni(studentDni: string) {
    this.selectedStudentDni = studentDni;
    this.searchCalifications();
  }

  searchCalificationsByYear(stringYear: string) {
    if (stringYear != "...") {
      this.selectedYearNumber = parseInt(stringYear);
      this.searchCalifications();
    }
    else {
      this.selectedYearNumber = 0;
    }
  }

  async searchCalifications() {

    if (this.selectedStudentDni != "" && this.selectedStudentDni != "Selecciona alumno..." && this.selectedYearNumber != 0) {
      this.calificationsService.getAllCalificationsByDni(this.selectedStudentDni, this.selectedYearNumber).subscribe((data) => {
        this.califications = data;
        this.suma = 0;
        this.califications.forEach((element) => {
          this.suma += element.calification;
        })
        this.califications.length > 0 ? this.media = this.suma / this.califications.length : this.media = 0;
      });
    }
  }

  deleteCalification(dni: string, subjectID: number, year: number) {
    this.calificationsService.deleteCalification(dni, subjectID, year);
    setTimeout(()=>{
      this.searchCalifications();
    },500)
  }

  studentSubmit(studentForm: NgForm) {
    const student: Student = studentForm.value;
    this.studentsService.addStudent(student);
    this.loadInfo();
    window.location.reload();
  }

  studentDelete() {
    this.studentsService.deleteStudent(this.selectedStudentDni);
    this.loadInfo();
   
  }

  yearSubmit(yearForm: NgForm) {
    const year: Year = yearForm.value;
    console.log(year);
    this.yearsService.addYear(year);
    this.loadInfo();
    window.location.reload();
    
  }

  deleteYear() {
    this.yearsService.deleteYear(this.selectedYearNumber);
    this.loadInfo()
    
  }

  setSelectedSubject(selectedSubjectString: string) {
    this.selectedSubjectid = parseInt(selectedSubjectString);
  }

  setSelectedSubjectToSend(selectedSubjetToSend: string) {
    this.selectedSubjectidToSend = parseInt(selectedSubjetToSend);
  }

  calificationSubmit(calificationForm: NgForm) {
    
    if(this.updating==false){
      const calification: Califications = calificationForm.value;
    calification.studentdni = this.selectedStudentDni;
    calification.subjectid = this.selectedSubjectidToSend;
    calification.years = this.selectedYearNumber;
      this.calificationsService.addCalification(calification);
      setTimeout(()=>{
        this.searchCalifications();
      },500)
    }else{
      
      const calification: Califications = calificationForm.value;
    calification.studentdni = this.selectedStudentDni;
    calification.subjectid = this.updatingSubject.idsubject;
    calification.years = this.selectedYearNumber;
 

      this.calificationsService.updateCalification(calification);
    }
    
    this.updating=false;
    setTimeout(()=>{
      this.searchCalifications();
    },500)
    
    
  }

  showModal(modal: string) {
    document.getElementById(modal).style.display = "flex";
  }

  hideModal(modal: string) {
    document.getElementById(modal).style.display = "none";
    setTimeout(()=>{this.updating=false},500);
  }

  setCalificationUpdating(value:number, subjectValue:Subjects){
    this.updating=true;
    this.updatingSubject=subjectValue;
    this.updatingCalificationValue=value;
    console.log(`updating: ${this.updating} , updatingSubject: ${this.updatingSubject.idsubject} , value: ${this.updatingCalificationValue}` )
  }
}

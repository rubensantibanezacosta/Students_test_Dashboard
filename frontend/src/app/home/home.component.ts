import { Component, OnInit } from '@angular/core';
import { Califications } from '../classes/califications';
import { Student } from '../classes/student';
import { Year } from '../classes/year';
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
  constructor(private yearsService:YearsService) { }
  ngOnInit(): void {
    console.log("init");
    this.yearsService.getYears().subscribe((data)=>{
      
      this.years=data;
      console.log(data);
    });
  }
  }

import { Subject } from "rxjs";
import { Subjects } from "./subjects";

export class Califications {
    subjectid:number=-1;
    studentdni:string="";
    subjectsBySubjectid:Subjects =new Subjects();
    year:number=0;
    calification:number=0;
}

import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/classes/user';
import { LoginserviceService } from 'src/app/services/loginservice.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users :User[]=[];

  constructor(private userService:LoginserviceService) { }

  ngOnInit(): void {
    this.allUsers()
  }

  allUsers(){
    return this.userService.allUsers().subscribe(data=>{this.users=data}
    ,error=> console.error('Error requesting book', error));
  }


}

import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { User } from 'src/app/classes/user';
import { SignupServiceService } from 'src/app/services/signup-service.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

user:User =new User();

  constructor(private userService:SignupServiceService, private router:Router)  { }

  ngOnInit(): void {
  }


addNewUser(){
  this.userService.signupUser(this.user).subscribe(data=>{alert("Added sussessfully")
    this.router.navigate(['/users'])

    }
    ,error=> alert("failed to add")
    )
}

}

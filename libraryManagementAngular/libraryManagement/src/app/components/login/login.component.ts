import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/classes/user';
import { LoginserviceService } from 'src/app/services/loginservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:User = new User();

  constructor(private userService:LoginserviceService) { }

  ngOnInit(): void {
  }
  userLogin(){
    console.log(this.user);
    this.userService.loginUser(this.user).subscribe(data=>{
      alert("login successfully")
    },error=>alert("Sorry Please Enter vali user name and password"));
    
  }
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/classes/user';
import { LoginserviceService } from 'src/app/services/loginservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:User = new User();

  constructor(private userService:LoginserviceService, private router: Router ) { }

  ngOnInit(): void {
  }
  userLogin(){
    console.log(this.user);
    this.userService.loginUser(this.user).subscribe((data:User)=>{
      console.log(data)
      localStorage.setItem('user', JSON.stringify(data.userName));
      this.router.navigate(['/bookHome']);
    },error=>alert("Sorry Please Enter valid user name and password"));

  }


}

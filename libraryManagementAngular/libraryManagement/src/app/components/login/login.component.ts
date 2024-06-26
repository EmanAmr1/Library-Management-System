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


  constructor(private userService:LoginserviceService, private router: Router ) {
    this.user.role = {
      id: 2, // Initialize with appropriate default value
      roleName: '' // Initialize with appropriate default value
    };

   }

  ngOnInit(): void {
  }
 /* userLogin(){


    this.userService.loginUser(this.user).subscribe((data:User)=>{
      if(!data.enabled){
        alert("Sorry Please check your email to verify account");
      }
      else if (this.user.role.roleName === 'admin') {
        this.user.role.id = 1;
        this.router.navigate(['/adminHome']);
      } else if (this.user.role.roleName === 'student' ) {
        this.user.role.id = 2;
        this.router.navigate(['/bookHome']);
      }
      console.log(this.user);




      console.log(data)
      localStorage.setItem('user', JSON.stringify(data.userName));
     // this.router.navigate(['/bookHome']);
    },error=>alert("Sorry Please Enter valid user name and password"));

  }*/
    userLogin(){
      if (this.user.role.roleName === 'admin') {
        this.user.role.id = 1;
        this.router.navigate(['/adminHome']);
      }
      this.userService.loginUser(this.user).subscribe((data:User)=>{
        if(!data.enabled){
          alert("check your email to verify account");
        }
        else if (this.user.role.roleName === 'student' ) {
          this.user.role.id = 2;
          this.router.navigate(['/bookHome']);
        }
        console.log(this.user);


        console.log(data)
        localStorage.setItem('user', JSON.stringify(data.userName));

      },error=>alert("Sorry Please Enter valid user name and password"));

    }

}

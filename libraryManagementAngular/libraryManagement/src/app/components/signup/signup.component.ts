import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/classes/user';
import { SignupServiceService } from 'src/app/services/signup-service.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  user:User = new User();
  constructor(private signupService:SignupServiceService , private router: Router) { }

  ngOnInit(): void {
  }

  userSignup(){
  this.signupService.signupUser(this.user).subscribe(data=>{alert("signup sussessfully")
  this.router.navigate(['/login']);
  }


  ,error=> alert("failed to signup")
  )
}


}

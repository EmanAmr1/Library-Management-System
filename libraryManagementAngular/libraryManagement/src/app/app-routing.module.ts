import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { BookHomeComponent } from './components/book-home/book-home.component';
import { UserReuestedBooksComponent } from './components/user-reuested-books/user-reuested-books.component';
import { AdminHomeComponent } from './components/admin-home/admin-home.component';
import { AddBookComponent } from './components/add-book/add-book.component';

const routes: Routes = [
{path:"login",component:LoginComponent},
{path:"signup",component:SignupComponent},
{path:"bookHome",component:BookHomeComponent},
{path:"addbook",component:AddBookComponent},
{path:"requestedBooks",component:UserReuestedBooksComponent},
{path:"adminHome",component:AdminHomeComponent},
{ path: '', redirectTo: '/login', pathMatch: 'full' },
{ path: '**', redirectTo: '/login' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

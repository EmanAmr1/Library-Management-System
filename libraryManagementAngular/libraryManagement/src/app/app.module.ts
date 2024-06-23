import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SignupComponent } from './components/signup/signup.component';
import { BookHomeComponent } from './components/book-home/book-home.component';
import { UserReuestedBooksComponent } from './components/user-reuested-books/user-reuested-books.component';
import { AdminHomeComponent } from './components/admin-home/admin-home.component';
import { AddBookComponent } from './components/add-book/add-book.component';
import { AddUserComponent } from './components/add-user/add-user.component';
import { UsersComponent } from './components/users/users.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    BookHomeComponent,
    UserReuestedBooksComponent,
    AdminHomeComponent,
    AddBookComponent,
    AddUserComponent,
    UsersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

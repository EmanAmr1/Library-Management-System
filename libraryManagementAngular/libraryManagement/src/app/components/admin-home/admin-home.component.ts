import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from 'src/app/classes/book';
import { User } from 'src/app/classes/user';
import { BookServiceService } from 'src/app/services/book-service.service';
import { RequestedBooksServiceService } from 'src/app/services/requested-books-service.service';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  books:Book[]=[]
usersName:User[]=[]
selectedBookId!: number ;
  constructor(private bookService:BookServiceService ,
    private bookreqService:RequestedBooksServiceService ,
    private router:Router ,
  private requestedBooksService:RequestedBooksServiceService ) { }

  ngOnInit(): void {
    this.getBooks()
  }


  getBooks(){
    return this.bookService.getBooks().subscribe(data=> {this.books=data },error=>
      console.log("error")

    );
  }

  manageReq(bookId: number) {
    this.bookreqService.manageReq(bookId).subscribe(
      data => {
        this.usersName = data;
        this.selectedBookId = bookId;

      },
      error => console.log("error")
    );
  }


  deleteReq(username:any, id:number ){
    this.requestedBooksService.deleteBook(username,id).subscribe(()=>{
      alert('Book request deleted successfully');

       },
    (error) => {
      console.error('Error deleting book request', error);
    }
    );
      }
}

import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/classes/book';
import { BookServiceService } from 'src/app/services/book-service.service';
import { RequestedBooksServiceService } from 'src/app/services/requested-books-service.service';

@Component({
  selector: 'app-book-home',
  templateUrl: './book-home.component.html',
  styleUrls: ['./book-home.component.css']
})
export class BookHomeComponent implements OnInit {
  username!: string;
  books:Book[]=[];
  constructor(private bookService:BookServiceService ,private bookRequestService:RequestedBooksServiceService) { }

  ngOnInit(): void {
    const user = localStorage.getItem('user');
    if (user) {
        this.username = user.replace(/"/g, '');
    }
    console.log(this.username);

    //call to fetch books
    this.getBooks();
  }

  getBooks(){
    this.bookService.getBooks().subscribe(data=>{
      this.books=data;
    },error=> console.error('Error requesting book', error))
  }

  requestBook(bookId: number): void {
    this.bookRequestService.requestBook(this.username, bookId).subscribe(
      (bookRequest) => {
        console.log('Book requested successfully', bookRequest);
        alert('Book requested successfully');
      },
      (error) => {
        console.error('Error requesting book', error);
        alert('You have aleardy requesting this book');
      }
    );
  }


}

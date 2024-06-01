import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/classes/book';
import { BookServiceService } from 'src/app/services/book-service.service';

@Component({
  selector: 'app-book-home',
  templateUrl: './book-home.component.html',
  styleUrls: ['./book-home.component.css']
})
export class BookHomeComponent implements OnInit {

  books:Book[]=[];
  constructor(private bookService:BookServiceService) { }

  ngOnInit(): void {
    this.getBooks();
  }

  getBooks(){
    this.bookService.getBooks().subscribe(data=>{
      this.books=data;
    },error=>alert("error fetching data"));
  }

}

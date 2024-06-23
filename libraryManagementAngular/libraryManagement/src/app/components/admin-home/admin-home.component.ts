import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/classes/book';
import { BookServiceService } from 'src/app/services/book-service.service';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  books:Book[]=[]


  constructor(private bookService:BookServiceService ) { }

  ngOnInit(): void {
    this.getBooks()
  }


  getBooks(){
    return this.bookService.getBooks().subscribe(data=> {this.books=data },error=>
      console.log("error")

    );
  }
}

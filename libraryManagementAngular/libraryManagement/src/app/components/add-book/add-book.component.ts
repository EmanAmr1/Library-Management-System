import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from 'src/app/classes/book';
import { BookServiceService } from 'src/app/services/book-service.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {
book:Book =new Book()
  constructor(private BookService:BookServiceService ,private router: Router ) { }

  ngOnInit(): void {
  }


  addbook(){
    this.BookService.addBook(this.book).subscribe(data=>{alert("Added sussessfully");
        this.router.navigate(['/adminHome']);} ,
      error=> alert("failed to add"));
    }

clear(){
  this.book.author="";
  this.book.description="";
  this.book.title="";
}



}

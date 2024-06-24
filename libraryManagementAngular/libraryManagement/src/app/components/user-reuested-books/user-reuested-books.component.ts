import { Component, OnInit } from '@angular/core';
import { RequestedBooks } from 'src/app/classes/requested-books';
import { RequestedBooksServiceService } from 'src/app/services/requested-books-service.service';

@Component({
  selector: 'app-user-reuested-books',
  templateUrl: './user-reuested-books.component.html',
  styleUrls: ['./user-reuested-books.component.css']
})
export class UserReuestedBooksComponent implements OnInit {
  bookRequests: RequestedBooks[] = [];
  username!: string;
  constructor(private requestedBooksService:RequestedBooksServiceService) { }

  ngOnInit(): void {

   const user = localStorage.getItem('user');
   if (user) {
       this.username = user.replace(/"/g, '');;
   }
   console.log(this.username);

this.loadRequestedBooks();
  }

  loadRequestedBooks(): void {
    this.requestedBooksService.getRequestsByUser(this.username).subscribe(
      (bookRequests: RequestedBooks[]) => {
        this.bookRequests = bookRequests;
      },
      (error) => {
        console.error('Error fetching requested books', error);
      }
    );
  }


  deleteReq(id:number ){
this.requestedBooksService.deleteBook(this.username,id).subscribe(()=>{
  console.log('Book request deleted successfully');
  
  this.loadRequestedBooks();
},
(error) => {
  console.error('Error deleting book request', error);
}
);
  }

}

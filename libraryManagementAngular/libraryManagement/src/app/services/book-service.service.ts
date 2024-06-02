import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../classes/book';

@Injectable({
  providedIn: 'root'
})
export class BookServiceService {

  private baseUrl="http://localhost:8081/book/allBooks"
  constructor(private http:HttpClient) { }

  getBooks():Observable<Book[]>{
    return this.http.get<Book[]>(this.baseUrl);
  }


  
}

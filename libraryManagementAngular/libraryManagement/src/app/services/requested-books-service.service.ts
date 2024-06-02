import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RequestedBooks } from '../classes/requested-books';

@Injectable({
  providedIn: 'root'
})
export class RequestedBooksServiceService {

  private baseUrl="http://localhost:8081/book-requests"
  constructor(private http:HttpClient) { }

  getRequestsByUser(username: string): Observable<RequestedBooks[]> {
    return this.http.get<RequestedBooks[]>(`${this.baseUrl}/user/${username}`);
  }


  requestBook(username: string, bookId: number): Observable<RequestedBooks> {
    return this.http.post<RequestedBooks>(`${this.baseUrl}/request`, null, {
      params: { username, bookId: bookId.toString() }
    });
  }
}

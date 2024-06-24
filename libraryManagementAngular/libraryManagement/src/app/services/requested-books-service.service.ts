import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RequestedBooks } from '../classes/requested-books';

@Injectable({
  providedIn: 'root'
})
export class RequestedBooksServiceService {

  private baseUrl="http://localhost:8081/book-requests"

  private deleteUrl="http://localhost:8081/book-requests/deleteBook"

  constructor(private http:HttpClient) { }

  getRequestsByUser(username: string): Observable<RequestedBooks[]> {
    return this.http.get<RequestedBooks[]>(`${this.baseUrl}/user/${username}`);
  }


  requestBook(username: string, bookId: number): Observable<RequestedBooks> {
    return this.http.post<RequestedBooks>(`${this.baseUrl}/request`, null, {
      params: { username, bookId: bookId.toString() }
    });
  }

  deleteBook(username:string,bookId:number):Observable<any>{

    const params = new HttpParams().set('username', username).set('bookId', bookId.toString());
    return this.http.delete<any>(`${this.deleteUrl}`, { params });
  }
}

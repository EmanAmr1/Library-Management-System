import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, tap } from 'rxjs';
import { RequestedBooks, UserRequestDto } from '../classes/requested-books';
import { User } from '../classes/user';

@Injectable({
  providedIn: 'root'
})
export class RequestedBooksServiceService {

  private baseUrl="http://localhost:8081/book-requests"

  private deleteUrl="http://localhost:8081/book-requests/deleteBook"

  private manageUrl="http://localhost:8081/book-requests/users"

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





  manageReq(bookId: number): Observable<UserRequestDto[]> {
    const params = new HttpParams().set('bookId', bookId.toString());
    return this.http.get<UserRequestDto[]>(`${this.manageUrl}`, { params })
  }
}

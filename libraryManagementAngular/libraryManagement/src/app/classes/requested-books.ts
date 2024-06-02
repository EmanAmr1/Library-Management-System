export class RequestedBooks {
  requestId?: number;
  user!: {
    userId: number;
    username: string;
    firstName: string;
    lastName: string;
  };
  book!: {
    bookId: number;
    title: string;
    author: string;
  };
  requestDate!: string;

}




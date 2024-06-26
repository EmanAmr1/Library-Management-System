export class RequestedBooks {
  requestId?: number;
  user!: {
    userId: number;
    username: string;
    firstName: string;
    lastName: string;
  };
  book!: {
    id: number;
    title: string;
    author: string;
  };
  requestDate!: string;

}

export class UserRequestDto {
  userName!: string;
  requestDate!: string;
  cancelDate!:string;
}




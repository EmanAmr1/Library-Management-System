import { TestBed } from '@angular/core/testing';

import { RequestedBooksServiceService } from './requested-books-service.service';

describe('RequestedBooksServiceService', () => {
  let service: RequestedBooksServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RequestedBooksServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

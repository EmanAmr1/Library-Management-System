import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserReuestedBooksComponent } from './user-reuested-books.component';

describe('UserReuestedBooksComponent', () => {
  let component: UserReuestedBooksComponent;
  let fixture: ComponentFixture<UserReuestedBooksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserReuestedBooksComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserReuestedBooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

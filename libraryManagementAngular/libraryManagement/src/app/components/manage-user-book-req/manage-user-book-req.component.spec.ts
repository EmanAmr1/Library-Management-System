import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageUserBookReqComponent } from './manage-user-book-req.component';

describe('ManageUserBookReqComponent', () => {
  let component: ManageUserBookReqComponent;
  let fixture: ComponentFixture<ManageUserBookReqComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManageUserBookReqComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ManageUserBookReqComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

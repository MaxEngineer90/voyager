import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsSidenavComponent } from './details-sidenav.component';

describe('DetailsSidenavComponent', () => {
  let component: DetailsSidenavComponent;
  let fixture: ComponentFixture<DetailsSidenavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DetailsSidenavComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DetailsSidenavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

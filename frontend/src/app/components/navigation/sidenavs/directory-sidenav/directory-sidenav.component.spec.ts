import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DirectorySidenavComponent } from './directory-sidenav.component';

describe('DirectorySidenavComponent', () => {
  let component: DirectorySidenavComponent;
  let fixture: ComponentFixture<DirectorySidenavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DirectorySidenavComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DirectorySidenavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

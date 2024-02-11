import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PathBarComponent } from './path-bar.component';

describe('PathComponent', () => {
  let component: PathBarComponent;
  let fixture: ComponentFixture<PathBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PathBarComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PathBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

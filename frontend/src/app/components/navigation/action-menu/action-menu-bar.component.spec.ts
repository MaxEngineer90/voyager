import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActionMenuBarComponent } from './action-menu-bar.component';

describe('ActionMenuComponent', () => {
  let component: ActionMenuBarComponent;
  let fixture: ComponentFixture<ActionMenuBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ActionMenuBarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActionMenuBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

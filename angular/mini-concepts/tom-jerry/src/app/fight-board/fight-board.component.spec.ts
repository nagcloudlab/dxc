import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FightBoardComponent } from './fight-board.component';

describe('FightBoardComponent', () => {
  let component: FightBoardComponent;
  let fixture: ComponentFixture<FightBoardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FightBoardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FightBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import {Component, OnInit} from '@angular/core';
import {FightService} from "../fight.service";

@Component({
  selector: 'app-fight-board',
  templateUrl: './fight-board.component.html',
  styleUrls: ['./fight-board.component.css']
})
export class FightBoardComponent implements OnInit {


  fightCount: number = 0;

  constructor(private fightService:FightService) {}

  ngOnInit(): void {
    this.fightService.fightStream.subscribe({
      next: data => {
        this.fightCount = data.fightCount
      }
    })
  }

}

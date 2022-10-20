import {Component, OnInit} from '@angular/core';
import {FightService} from '../fight.service';

@Component({
  selector: 'app-jerry',
  templateUrl: './jerry.component.html',
  styleUrls: ['./jerry.component.css']
})
export class JerryComponent implements OnInit {


  jerryFightCount: number = 0;

  fightService: FightService;

  constructor(fightService: FightService) {
    // this.fightService = new FightService();
    this.fightService = fightService;
  }

  ngOnInit(): void {
  }

  doFight() {
    this.jerryFightCount++;
    this.fightService.doIncFightCount()
  }


}

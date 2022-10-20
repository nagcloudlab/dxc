import {Component, OnInit} from '@angular/core';
import {FightService} from "../fight.service";

@Component({
  selector: 'app-tom',
  templateUrl: './tom.component.html',
  styleUrls: ['./tom.component.css']
})
export class TomComponent implements OnInit {


  tomFightCount: number = 0;

  fightService: FightService;

  constructor(fightService: FightService) {
    // this.fightService = new FightService();
    this.fightService = fightService;
  }

  ngOnInit(): void {
  }

  doFight() {
    this.tomFightCount++;
    this.fightService.doIncFightCount()
  }


}

import {Injectable} from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FightService {

  fightCount = 0;
  fightStream = new BehaviorSubject<any>({fightCount: 0})

  doIncFightCount() {
    this.fightCount++;
    this.fightStream.next({fightCount: this.fightCount});
  }


  constructor() {
  }
}

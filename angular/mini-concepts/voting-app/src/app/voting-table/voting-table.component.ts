import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-voting-table',
  templateUrl: './voting-table.component.html',
  styleUrls: ['./voting-table.component.css']
})
export class VotingTableComponent implements OnInit {

  @Input()
  lines: Array<any>=[]

  constructor() { }

  ngOnInit(): void {
  }

}

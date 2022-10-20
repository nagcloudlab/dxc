import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-voting-box',
  templateUrl: './voting-box.component.html',
  styleUrls: ['./voting-box.component.css']
})
export class VotingBoxComponent implements OnInit {


  subjects: Array<string> = []

  votingLines: Array<any> = []

  constructor() {
  }

  ngOnInit(): void {
  }

  addSubject(subject: string) {
    this.subjects.push(subject)
  }

  handleDel(event: any): void {
    let {item} = event
    this.subjects = this.subjects.filter(s => s !== item)
  }

  handleVote(event: any) {
    let {item, likes, dislikes} = event
    let votingLine = this.votingLines.find(line => line.item === item)
    if (votingLine) {
      votingLine.likes = likes
      votingLine.dislikes = dislikes
    } else {
      this.votingLines.push({
        item,
        likes,
        dislikes
      })
    }
  }


}

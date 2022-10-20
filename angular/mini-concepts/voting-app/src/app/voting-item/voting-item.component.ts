import {Component, EventEmitter, Input, OnInit, Output, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-voting-item',
  templateUrl: './voting-item.component.html',
  styleUrls: ['./voting-item.component.css']
})
export class VotingItemComponent {

  @Input()
  value: string = "";
  likes: number = 0
  dislikes: number = 0
  @Output()
  vote = new EventEmitter<any>()
  @Output()
  del = new EventEmitter<any>()

  constructor() {
    console.log("VotingItemComponent::constructor")
    // to initialize the component fields
    // to inject services
  }

  ngOnChanges(changes: SimpleChanges) {
    console.log("VotingItemComponent::ngOnChanges", changes)
    // to do any action on new input properties
  }

  ngOnInit(): void {
    console.log("VotingItemComponent::ngOnInit")
    // to do one-time initialization e.g subscribing to observable streams
  }

  ngOnDestroy(): void {
    console.log("VotingItemComponent::ngOnDestroy")
    // to do any clean up tasks like unsubscribing from the observable stream
  }

  handleLikesEvent(event: any) {
    this.likes++
    this.vote.emit({item: this.value, likes: this.likes, dislikes: this.dislikes});
  }

  handleDislikesEvent(event: any) {
    this.dislikes++
    this.vote.emit({item: this.value, likes: this.likes, dislikes: this.dislikes});
  }

  handleDel(event: any) {
    this.del.emit({item: this.value})
  }


}

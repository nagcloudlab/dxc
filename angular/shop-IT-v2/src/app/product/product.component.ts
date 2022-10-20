import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @Input("value")
  product: any = {}

  @Output() buy = new EventEmitter<any>();

  currentTabIndex = 1

  reviews: Array<any> = [
    {id: 1, author: 'who-1', stars: 3, body: "sample review-1"},
    {id: 2, author: 'who-2', stars: 4, body: "sample review"}
  ]

  handleBuy($event: any) {
    this.buy.emit(this.product)
  }

  changeTab(event: any, tabIndex: number) {
    event.preventDefault()
    this.currentTabIndex = tabIndex
  }

  isTabSelected(tabIndex: number) {
    return this.currentTabIndex === tabIndex
  }


  constructor() {
  }

  ngOnInit(): void {
  }

}

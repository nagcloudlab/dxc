import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {

  @Input("value")
  product: any = {}

  currentTabIndex = 1

  reviews: Array<any> = [
    {id: 1, author: 'who-1', stars: 3, body: "sample review-1"},
    {id: 2, author: 'who-2', stars: 4, body: "sample review"}
  ]

  constructor(private cartService: CartService) {}

  handleBuy($event: any) {
    this.cartService.addToCart(this.product)
  }

  changeTab(event: any, tabIndex: number) {
    event.preventDefault()
    this.currentTabIndex = tabIndex
  }

  isTabSelected(tabIndex: number) {
    return this.currentTabIndex === tabIndex
  }


}

import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CartService} from '../cart.service';
import {ProductsService} from "../products.service";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {

  @Input("value")
  product: any = {}

  currentTabIndex = 1

  reviews: Array<any> = []

  constructor(
    private cartService: CartService,
    private productsService: ProductsService
  ) {
  }

  handleBuy($event: any) {
    this.cartService.addToCart(this.product)
  }

  changeTab(event: any, tabIndex: number) {
    event.preventDefault()
    this.currentTabIndex = tabIndex
    if (this.currentTabIndex === 3) {
      this.productsService.getReviews(this.product.id)
        .subscribe((reviews:any) => {
          this.reviews = reviews
        })
    }
  }

  isTabSelected(tabIndex: number) {
    return this.currentTabIndex === tabIndex
  }


}

import {Component, Input, OnInit} from '@angular/core';
import {CartService} from "../cart.service";

@Component({
  selector: 'app-cart-badge',
  templateUrl: './cart-badge.component.html',
  styleUrls: ['./cart-badge.component.css']
})
export class CartBadgeComponent implements OnInit {

  cartCount: number = 0;

  constructor(private cartService: CartService) {
  }

  ngOnInit(): void {
    this.cartService.cartStream.subscribe((cart: Array<any>) => {
      this.cartCount = cart.length;
    })
  }

}

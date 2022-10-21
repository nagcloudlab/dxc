import {Component, OnInit} from '@angular/core';
import {CartService} from "../cart.service";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cart: Array<any> = []

  constructor(private cartService: CartService) {
  }

  ngOnInit(): void {
    this.cart = this.cartService.cart
  }

}
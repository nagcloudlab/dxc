import {EventEmitter, Injectable} from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cart: Array<any> = []
  cartStream = new BehaviorSubject(this.cart)

  addToCart(product: any) {
    this.cart.push(product)
    this.cartStream.next(this.cart)
  }

}

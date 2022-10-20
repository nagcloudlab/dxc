import {Component} from '@angular/core';


// component = template + style + behavior

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'shop-IT-v2';
  cart: Array<any> = []

  handleBuy(product: any) {
    this.cart.push(product)
  }


}

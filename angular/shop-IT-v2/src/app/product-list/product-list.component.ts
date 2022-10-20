import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  @Output() buy: EventEmitter<any> = new EventEmitter<any>()

  products = [
    {
      id: 1,
      name: "laptop",
      price: 450000,
      discount: 10000,
      currencyCode: "INR",
      description: "New Mac pro",
      isAvailable: true,
      imgPath: "assets/Laptop.png",
      makeDate: Date.now()
    },
    {
      id: 2,
      name: "mobile",
      price: 150000,
      currencyCode: "INR",
      description: "New pro",
      isAvailable: true,
      imgPath: "assets/Mobile.png",
      makeDate: Date.now()
    },
  ]

  constructor() { }

  ngOnInit(): void {
  }

  handleBuy(event: any) {
    this.buy.emit(event)
  }

}

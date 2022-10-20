import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor() {}

  getProducts() {
    return [
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
  }

}

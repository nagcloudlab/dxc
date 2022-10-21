import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient) {
  }

  getProducts() {
    //return this.http.get("http://localhost:8080/v1/api/products");
    return new BehaviorSubject([
      {
        "id": 1,
        "name": "Product 1",
        "description": "Description for Product 1",
        "price": 10,
        "discount": 0,
        "imgPath": "assets/Laptop.png",
        "available": true
      },
      {
        "id": 2,
        "name": "Product 2",
        "description": "Description for Product 2",
        "price": 20,
        "discount": 0,
        "imgPath": "assets/Mobile.png",
        "available": true
      }
    ])
  }

  getReviews(productId: number) {
    //return this.http.get(`http://localhost:8080/v1/api/products/${productId}/reviews`);
    return new BehaviorSubject([
      {"stars": 1, author: 'who-1', body: 'This is a review message'},
      {"stars": 2, author: 'who-2', body: 'This is a review message'},
    ])
  }

}

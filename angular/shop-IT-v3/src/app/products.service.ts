import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient) {
  }

  getProducts() {
    return this.http.get("http://localhost:8080/v1/api/products");
  }
  getReviews(productId: number) {
    return this.http.get(`http://localhost:8080/v1/api/products/${productId}/reviews`);
  }

}

import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ProductsService} from "../products.service";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products:Array<any> = []

  constructor(private productsService:ProductsService) { }

  ngOnInit(): void {
    this.products=this.productsService.getProducts()
  }

}

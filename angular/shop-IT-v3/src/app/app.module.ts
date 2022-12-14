import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'

import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {ProductComponent} from './product/product.component';
import {ProductListComponent} from './product-list/product-list.component';
import {ReviewComponent} from './review/review.component';
import {CartBadgeComponent} from './cart-badge/cart-badge.component';
import {DiscountPipe} from './discount.pipe';
import {HighlightDirective} from './highlight.directive';
import { CartComponent } from './cart/cart.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ProductComponent,
    ProductListComponent,
    ReviewComponent,
    CartBadgeComponent,
    DiscountPipe,
    HighlightDirective,
    CartComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

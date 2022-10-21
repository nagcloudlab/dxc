import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'
import {RouterModule, Routes} from "@angular/router";

import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {ProductComponent} from './product/product.component';
import {ProductListComponent} from './product-list/product-list.component';
import {ReviewComponent} from './review/review.component';
import {CartBadgeComponent} from './cart-badge/cart-badge.component';
import {DiscountPipe} from './discount.pipe';
import {HighlightDirective} from './highlight.directive';
import {CartComponent} from './cart/cart.component';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';
import {NotFoundComponent} from './not-found/not-found.component';


const ROUTES: Routes = [
  {path: '', component: HomeComponent, pathMatch:'prefix'},
  {path: 'login', component: LoginComponent},
  {path: 'cart', component: CartComponent},
  {path: 'products', component: ProductListComponent},
  {path: '**', component: NotFoundComponent}
]


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
    CartComponent,
    HomeComponent,
    LoginComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(ROUTES, {useHash: false})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

import {Component} from '@angular/core';


// component = template + style + behavior

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'shop-IT-v2';

  isCartOpen = false;

  toggleCart(event: any) {
    event.preventDefault();
    this.isCartOpen = !this.isCartOpen;
  }
}



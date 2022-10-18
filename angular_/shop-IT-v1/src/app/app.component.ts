import { Component } from '@angular/core';


// component = template + style + behavior

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'shop-IT-v1';

  products = [
    {
      id: 1,
      name: "laptop",
      price: 450000,
      description: "New Mac pro",
      isAvailable: true,
      imgPath: "assets/Laptop.png"
    },
    {
      id: 2,
      name: "mobile",
      price: 150000,
      description: "New pro",
      isAvailable: true,
      imgPath: "assets/Mobile.png"
    },
  ]

  currentTabIndex = 1

  changeTab(event: any, tabIndex: number) {
    //console.log(event);
    event.preventDefault()
    this.currentTabIndex = tabIndex
  }
  isTabSelected(tabIndex: number) {
    return this.currentTabIndex === tabIndex
  }


}

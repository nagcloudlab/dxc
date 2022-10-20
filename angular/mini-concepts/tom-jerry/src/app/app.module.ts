import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TomComponent } from './tom/tom.component';
import { JerryComponent } from './jerry/jerry.component';
import { FightBoardComponent } from './fight-board/fight-board.component';

@NgModule({
  declarations: [
    AppComponent,
    TomComponent,
    JerryComponent,
    FightBoardComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

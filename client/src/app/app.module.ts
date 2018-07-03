
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import {routing} from './app.routes';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AccountFormComponent } from './account/account.component';

import { AccountService } from './account/account.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AccountFormComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    routing,
  ],
  providers: [
    AccountService,
  ],
  bootstrap: [
    AppComponent,
  ]
})
export class AppModule { }

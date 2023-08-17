import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {RouterOutlet} from "@angular/router";
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import {LoginService} from "./service/login.service";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent
  ],
    imports: [
        BrowserModule,
        RouterOutlet
    ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }

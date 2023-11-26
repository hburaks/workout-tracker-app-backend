import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {RouterLink, RouterOutlet} from "@angular/router";
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import {LoginService} from "./service/login.service";
import { AppRoutingModule } from './app-routing.module';
import { NavbarComponent } from './header/navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    NavbarComponent
  ],
    imports: [
        BrowserModule,
        RouterOutlet,
        RouterLink,
        AppRoutingModule,
    ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }

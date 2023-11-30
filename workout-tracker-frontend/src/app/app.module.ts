import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {RouterLink, RouterOutlet} from "@angular/router";
import { HeaderComponent } from './header/header.component';
import {LoginService} from "./service/login.service";
import { AppRoutingModule } from './app-routing.module';
import { NavbarComponent } from './header/navbar/navbar.component';
import { BodyComponent } from './body/body.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { LoginComponent } from './login/login.component';
import {FormsModule} from "@angular/forms";
import { MainComponent } from './main/main.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { ProfileComponent } from './user-dashboard/profile/profile.component';
import {NgOptimizedImage} from "@angular/common";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavbarComponent,
    BodyComponent,
    CreateAccountComponent,
    LoginComponent,
    MainComponent,
    UserDashboardComponent,
    ProfileComponent
  ],
    imports: [
        BrowserModule,
        RouterOutlet,
        RouterLink,
        AppRoutingModule,
        FormsModule,
        NgOptimizedImage,
    ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }

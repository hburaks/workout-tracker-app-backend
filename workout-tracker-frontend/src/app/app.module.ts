import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {RouterLink, RouterOutlet} from "@angular/router";
import { HeaderComponent } from './main/header/header.component';
import {LoginService} from "./service/login.service";
import { AppRoutingModule } from './app-routing.module';
import { NavbarComponent } from './main/header/navbar/navbar.component';
import { BodyComponent } from './main/body/body.component';
import { CreateAccountComponent } from './main/body/create-account/create-account.component';
import { LoginComponent } from './main/header/login/login.component';
import {FormsModule} from "@angular/forms";
import { MainComponent } from './main/main.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { ProfileComponent } from './user-dashboard/dash-header/profile/profile.component';
import {NgOptimizedImage} from "@angular/common";
import { FooterComponent } from './main/footer/footer.component';
import { IconComponent } from './main/header/icon/icon.component';
import { FeaturesComponent } from './main/body/features/features.component';
import { PricingComponent } from './main/body/pricing/pricing.component';
import { DashHeaderComponent } from './user-dashboard/dash-header/dash-header.component';
import { DashSideBarComponent } from './user-dashboard/dash-side-bar/dash-side-bar.component';
import { DashMainComponent } from './user-dashboard/dash-main/dash-main.component';
import { DashFooterComponent } from './user-dashboard/dash-footer/dash-footer.component';

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
    ProfileComponent,
    FooterComponent,
    IconComponent,
    FeaturesComponent,
    PricingComponent,
    DashHeaderComponent,
    DashSideBarComponent,
    DashMainComponent,
    DashFooterComponent
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

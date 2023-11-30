import {Component, OnInit} from '@angular/core';
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{
  constructor(private breakpointObserver: BreakpointObserver) {}

  ngOnInit() {
    this.breakpointObserver.observe("(min-width: 768px)")
      .subscribe(result => {
        if(result.matches){
          this.isNavbarVisible = false;
        }
      });
  }

  navbarItems: { text: string, link: string }[] = [
    {text: "Premium", link: "#"},
    {text: "Explore", link: "#"},
    {text: "Product", link: "#"},
    {text: "Coach", link: "#"},
    {text: "Login", link: "login"}
  ]
  isNavbarVisible: boolean = false;

  toggleNavBar(): void {
    this.isNavbarVisible = !this.isNavbarVisible;
  }
}

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
    {text: "Home", link: "#"},
    {text: "Service", link: "#"},
    {text: "Pricing", link: "#"},
    {text: "Our Work", link: "#"},
    {text: "Why Us", link: "#"}
  ]
  isNavbarVisible: boolean = false;

  toggleNavBar(): void {
    this.isNavbarVisible = !this.isNavbarVisible;
  }
}

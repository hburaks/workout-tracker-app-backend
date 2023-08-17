import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  /*constructor(http: HttpClient) {
  }

  protected serverUrl = "http://localhost:4555"
  username?: string;
  password?: string;
  user$ = this.http.get<any>(`${this.serverUrl}/users?name=${this.username}&page=${this.password}&size=${this.password}`)

  login(username: string, password: string) {
    return this.http.post<any>(`${this.serverUrl}/login`, {username, password})
      .pipe(map(user => {
        // login successful if there's a jwt token in the response
        if (user && user.token) {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem('currentUser', JSON.stringify(user));
        }

        return user;
      }));
  }*/
}

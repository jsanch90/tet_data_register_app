import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CookieService} from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  response = false;

  constructor(private http: HttpClient, private cookieService: CookieService) {
  }

  getToken(user: string, pass: string): boolean {
    this.http.post('user/login', {username: user, password: pass}).subscribe(res => {
      if (res['successful']) {
        this.cookieService.set('USER_TOKEN', res['response']);
        this.cookieService.set('IS_LOGGED', res['successful']);
        this.response = res['successful'];
      } else {
        this.cookieService.set('IS_LOGGED', res['successful']);
        alert(res['response']);
        this.response = res['successful'];
      }
    });
    return this.response;
  }

}

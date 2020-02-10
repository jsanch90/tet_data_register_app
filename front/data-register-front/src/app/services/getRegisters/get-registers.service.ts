import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {RegisterModel} from '../../models/RegisterModel';
import {Observable} from 'rxjs';
import {CookieService} from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class GetRegistersService {

  constructor(private http: HttpClient, private cookieService: CookieService) {
  }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      // tslint:disable-next-line:max-line-length
      Authorization: this.cookieService.get('USER_TOKEN')
    })
  };


  getUserData(user: string): Observable<RegisterModel[]> {
    console.log(this.cookieService.get('USER_TOKEN'),'---------------------')
    return this.http.get<RegisterModel[]>('register/user_registers?userId=' + user, this.httpOptions);
  }

  getAllData(): Observable<RegisterModel[]> {
    console.log(this.cookieService.get('USER_TOKEN'))
    return this.http.get<RegisterModel[]>('register/all', this.httpOptions);
  }
}

import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {RegisterModel} from '../../models/RegisterModel';
import {Observable} from 'rxjs';
import {CookieService} from 'ngx-cookie-service';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class GetRegistersService {

  constructor(private http: HttpClient) {
  }


  getUserData(user: string): Observable<RegisterModel[]> {
    return this.http.get<RegisterModel[]>('register/user_registers?userId=' + user);
  }

  getAllData(): Observable<RegisterModel[]> {
    return this.http.get<RegisterModel[]>('register/all');
  }
}

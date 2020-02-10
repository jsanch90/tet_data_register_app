import {Component, OnInit} from '@angular/core';
import {GetRegistersService} from './services/getRegisters/get-registers.service';
import {RegisterModel} from './models/RegisterModel';
import {CookieService} from 'ngx-cookie-service';
import {passBoolean} from 'protractor/built/util';
import {LoginService} from './services/login/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  user = '';
  user2 = '';
  password = '';
  registers: RegisterModel[];
  showLogin = true;

  //showTable = JSON.parse(this.cookieService.get('IS_LOGGED'));

  constructor(private getRegistersService: GetRegistersService, private cookieService: CookieService, private loginService: LoginService) {
  }

  ngOnInit() {
    this.cookieService.delete('IS_LOGGED');
    this.cookieService.delete('USER_TOKEN');
  }

  getUserData(user: string) {
    this.getRegistersService.getUserData(user).subscribe(registers => this.registers = registers);
  }

  getAllData() {
    this.getRegistersService.getAllData().subscribe(registers => this.registers = registers);
  }


  onSubmit() {
    // tslint:disable-next-line:triple-equals
    if (this.user2 == '' || this.user2 == null) {
      this.getAllData();
    } else {
      this.getUserData(this.user2);
    }
    this.user2 = '';
  }

  onSubmitLogin() {
    // this.loginService.getToken(this.user, this.password);
    // console.log(this.loginService.getToken(this.user, this.password));
    let res = this.loginService.getToken(this.user, this.password);
    if (res) {
      this.showLogin = false;
    }
    this.user = '';
    this.password = '';
  }

  logOut() {
    this.cookieService.delete('IS_LOGGED');
    this.cookieService.delete('USER_TOKEN');
    this.showLogin = true;
  }

}

import {Component, OnInit} from '@angular/core';
import {LoginService} from '../../services/login/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = '';
  password = '';

  constructor(private loginService: LoginService) {
  }

  ngOnInit() {
  }

  onSubmit() {
    this.loginService.getToken(this.user, this.password);
    this.user = '';
    this.password = '';
  }

}

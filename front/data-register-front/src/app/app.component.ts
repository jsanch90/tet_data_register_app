import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {GetRegistersService} from './services/getRegisters/get-registers.service';
import {RegisterModel} from './models/RegisterModel';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  token = '';
  user = '';
  registers: RegisterModel[];

  constructor(private getRegistersService: GetRegistersService) {
  }

  ngOnInit() {

  }

  getUserData(user: string) {
    this.getRegistersService.getUserData(user).subscribe(registers => this.registers = registers);
  }

  getAllData() {
    this.getRegistersService.getAllData().subscribe(registers => this.registers = registers);
  }


  onSubmit() {
    // tslint:disable-next-line:triple-equals
    if (this.user == '' || this.user  == null) {
      this.getAllData();
    } else {
      this.getUserData(this.user);
    }

  }
}

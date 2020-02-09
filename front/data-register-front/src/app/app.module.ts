import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {ServicesSettings} from './services/ServicesConfig';
import {GetRegistersService} from './services/getRegisters/get-registers.service';
import {CookieService} from 'ngx-cookie-service';
import {FormsModule} from '@angular/forms';
import { LoginComponent } from './components/login/login.component';
import {LoginService} from './services/login/login.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ServicesSettings, GetRegistersService, CookieService, LoginService],
  bootstrap: [AppComponent]
})
export class AppModule {
}

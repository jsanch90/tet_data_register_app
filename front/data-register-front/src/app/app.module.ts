import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {ServicesSettings} from './services/ServicesConfig';
import {GetRegistersService} from './services/getRegisters/get-registers.service';
import {CookieService} from 'ngx-cookie-service';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ServicesSettings, GetRegistersService, CookieService],
  bootstrap: [AppComponent]
})
export class AppModule {
}

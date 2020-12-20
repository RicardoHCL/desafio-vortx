import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { MainRoutingModule } from './main-routing.module';
import { HomePageComponent } from './home-page/home-page.component';
import { ApiService } from './shared/api.service';
import { TariffCalculationComponent } from './tariff-calculation/tariff-calculation.component';


@NgModule({
  declarations: [HomePageComponent, TariffCalculationComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    MainRoutingModule,
    ReactiveFormsModule
  ],
  providers:[ApiService]
})
export class MainModule { }

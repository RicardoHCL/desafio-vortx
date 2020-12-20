import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { TariffCalculationComponent } from './tariff-calculation/tariff-calculation.component';

const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'calcular-tarifa', component: TariffCalculationComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainRoutingModule { }

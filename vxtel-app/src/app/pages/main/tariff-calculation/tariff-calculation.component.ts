import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { Request } from './../shared/request.model';
import { ApiService } from './../shared/api.service';
import { Util } from './../shared/utils';
import toastr from 'toastr';

@Component({
  selector: 'app-tariff-calculation',
  templateUrl: './tariff-calculation.component.html',
  styleUrls: ['./tariff-calculation.component.css']
})
export class TariffCalculationComponent implements OnInit {

  tariffForm: FormGroup;
  submittingForm: boolean = false;
  valueWithPlan: any = 0;
  valueWithoutPlan: any = 0 ;
  planValue: number = 0;
  showCards: boolean = false;

  constructor(
    private service: ApiService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.buildForm();
  }

  public async submitForm(){
    this.submittingForm = true;

    const request: Request = Object.assign(new Request(), this.tariffForm.value);

    await this.service.postTariffs(request).subscribe(
      response => {
        this.showCards = true;
        this.submittingForm = false;
        this.planValue = request.plan;
        this.valueWithPlan = Util.formatRealWhitValueZero(response.valueWithPlan.toFixed(2).toString());
        this.valueWithoutPlan = Util.formatRealWhitValueZero(response.valueWithoutPlan.toFixed(2).toString());
      },
      error => {
        toastr.error(error.error.message);
        this.showCards = false;
        this.submittingForm = false;
      }

    );
  }

  private buildForm(){
    this.tariffForm = this.formBuilder.group({
      origin: [null, [Validators.required]],
      destiny: [null, [Validators.required]],
      minutes: [null, [Validators.required]],
      plan: ['', [Validators.required]],
    })
  }

}

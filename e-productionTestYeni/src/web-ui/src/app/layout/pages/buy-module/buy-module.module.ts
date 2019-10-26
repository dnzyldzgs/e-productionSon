import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {BuyModuleRoutingModule} from "./buyModule-routing.module";
import {BuyModuleComponent} from "./buy-module.component";
import {FlexLayoutModule} from "@angular/flex-layout";
@NgModule({
  declarations: [BuyModuleComponent],
  imports: [
    CommonModule,
    BuyModuleRoutingModule,
    FlexLayoutModule.withConfig({addFlexToParent: false})
  ]
})
export class BuyModuleModule { }
